package org.example.Parsing;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.Nodes.DataTypeNodes.DoubleLiteralNode;
import org.example.Nodes.DataTypeNodes.MatrixLiteralNode;
import org.example.Nodes.DataTypeNodes.VectorLiteralNode;
import org.example.Nodes.MathExprNode;
import org.example.Nodes.OperationNodes.*;
import org.example.Parsing.Gen.MathExprLexer;
import org.example.Parsing.Gen.MathExprParser;
import org.nd4j.linalg.factory.Nd4j;

import java.util.ArrayList;
import java.util.List;

public class MathExprTruffleParser {

    public static MathExprNode parse(String program) {
        return parse(CharStreams.fromString(program));
    }

    private static MathExprNode parse(CharStream inputStream) {
        var lexer = new MathExprLexer(inputStream);
        // remove the default console error listener
        lexer.removeErrorListeners();
        var parser = new MathExprParser(new CommonTokenStream(lexer));
        // remove the default console error listener
        parser.removeErrorListeners();
        // throw an exception when a parsing error is encountered
        parser.setErrorHandler(new BailErrorStrategy());
        MathExprParser.ExprContext context = parser.expr();
        return expr2TruffleNode(context);
    }

    private static MathExprNode expr2TruffleNode(MathExprParser.ExprContext expr) {
        if (expr instanceof MathExprParser.ParenExprContext) {
            return parenExpr2ExpressionNode((MathExprParser.ParenExprContext) expr);
        }
        if (expr instanceof MathExprParser.FunctionExprContext) {
            return functionExpr2ExpressionNode((MathExprParser.FunctionExprContext) expr);
        }
        if (expr instanceof MathExprParser.ExponentExprContext) {
            return expExpr2PotentialNode((MathExprParser.ExponentExprContext) expr);
        }
        if (expr instanceof MathExprParser.NegationExprContext) {
            return negationExpr2NegationNode((MathExprParser.NegationExprContext) expr);
        }
        if (expr instanceof MathExprParser.MultExprContext) {
            return multExpr2MultNode((MathExprParser.MultExprContext) expr);
        }
        if (expr instanceof MathExprParser.AddExprContext) {
            return addExpr2AddNode((MathExprParser.AddExprContext) expr);
        }
        if (expr instanceof MathExprParser.VectorExprContext) {
            return vectorExpr2VectorNode((MathExprParser.VectorExprContext) expr);
        }
        if (expr instanceof MathExprParser.MatrixExprContext) {
            return matrixExpr2MatrixNode((MathExprParser.MatrixExprContext) expr);
        }
        if (expr instanceof MathExprParser.LiteralExprContext) {
            return literalExpr2ExprNode((MathExprParser.LiteralExprContext) expr);
        }
        throw new RuntimeException("unimplemented in MathExprTruffleParser " + expr.getClass());
    }

    private static MathExprNode negationExpr2NegationNode(MathExprParser.NegationExprContext negationExpr) {
        return new NegationNode(
                expr2TruffleNode(negationExpr.expr())
        );
    }

    private static MathExprNode functionExpr2ExpressionNode(MathExprParser.FunctionExprContext sinusExpr) {
        if (sinusExpr.IDENTIFIER().toString().equals("sin")){
            return new SinusNode(
                    expr2TruffleNode(sinusExpr.expr())
            );
        }
        if (sinusExpr.IDENTIFIER().toString().equals("cos")){
            return new CosinusNode(
                    expr2TruffleNode(sinusExpr.expr())
            );
        }
        throw new RuntimeException("function not implemented yet");
    }

    private static MathExprNode matrixExpr2MatrixNode(MathExprParser.MatrixExprContext expr) {
        var matrixExprLiteral = (MathExprParser.MatrixContext) expr.children.get(0);
        var matrixLiterals = matrixExprLiteral.children;
        matrixLiterals.remove(matrixLiterals.size() - 1); //remove last index which is ']'
        matrixLiterals.remove(0); //remove first literal which is '['
        ArrayList<double[]> lines = new ArrayList<>();
        for (ParseTree matrixChild : matrixLiterals) {
            var transposedVector = (MathExprParser.TransposedVectorContext) matrixChild;
            var transposedVectorChildren = transposedVector.children;
            var array = literalsToArray(transposedVectorChildren);
            lines.add(array);
        }
        double[][] matrixLines = new double[lines.get(0).length][lines.size()];
        lines.toArray(matrixLines);
        return new MatrixLiteralNode(
                Nd4j.createFromArray(matrixLines)
        );
    }

    private static MathExprNode vectorExpr2VectorNode(MathExprParser.VectorExprContext expr) {
        var vectorExprLiteral = (MathExprParser.VectorContext) expr.children.get(0);
        var vectorLiterals = vectorExprLiteral.children;
        var array = literalsToArray(vectorLiterals);

        return new VectorLiteralNode(
                Nd4j.createFromArray(array).reshape(array.length, 1)
        );
    }

    private static double[] literalsToArray(List<ParseTree> children) {
        return children.stream()
                .filter( e -> e instanceof MathExprParser.DoubleLiteralContext)
                .map(e -> e.getText())
                .mapToDouble(e -> Double.valueOf(e))
                .toArray();
    }

    private static MathExprNode parenExpr2ExpressionNode(MathExprParser.ParenExprContext parenExpr) {
        return expr2TruffleNode(parenExpr.expr());
    }

    private static MathExprNode multExpr2MultNode(MathExprParser.MultExprContext multExpr) {
        if (multExpr.SOLIDUS() != null) {
            return new DivNode(
                    expr2TruffleNode(multExpr.expr(0)),
                    expr2TruffleNode(multExpr.expr(1))
            );
        }
        if (multExpr.ASTERISK() != null) {
            return new MultNode(
                    expr2TruffleNode(multExpr.expr(0)),
                    expr2TruffleNode(multExpr.expr(1))
            );
        }
        return new CrossProductNode(
                expr2TruffleNode(multExpr.expr(0)),
                expr2TruffleNode(multExpr.expr(1))
        );
    }

    private static MathExprNode addExpr2AddNode(MathExprParser.AddExprContext addExpr) {
        if (addExpr.HYPHEN_MINUS() != null){
            return new SubstrNode(
                    expr2TruffleNode(addExpr.expr(0)),
                    expr2TruffleNode(addExpr.expr(1))
            );
        }
        return new AddNode(
                expr2TruffleNode(addExpr.expr(0)),
                expr2TruffleNode(addExpr.expr(1))
        );
    }

    private static MathExprNode literalExpr2ExprNode(MathExprParser.LiteralExprContext literalExpr) {
        return new DoubleLiteralNode(Double.parseDouble(literalExpr.POSITIVEDOUBLE().toString()));
    }

    private static MathExprNode expExpr2PotentialNode(MathExprParser.ExponentExprContext expExpr) {
        return new PotentiateNode(
                expr2TruffleNode(expExpr.expr(0)),
                expr2TruffleNode(expExpr.expr(1))
        );
    }
}
