package de.dhbw.karlsruhe.dsl.Parsing;

import de.dhbw.karlsruhe.dsl.Nodes.LiteralNodes.DoubleLiteralNode;
import de.dhbw.karlsruhe.dsl.Nodes.LiteralNodes.MatrixLiteralNode;
import de.dhbw.karlsruhe.dsl.Nodes.LiteralNodes.VectorLiteralNode;
import de.dhbw.karlsruhe.dsl.Nodes.MathExprNode;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.BinaryNodes.*;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.UnaryNodes.*;
import de.dhbw.karlsruhe.dsl.Parsing.Gen.MathExprLexer;
import de.dhbw.karlsruhe.dsl.Parsing.Gen.MathExprParser;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
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
        if (expr instanceof MathExprParser.TransExprContext) {
            return transExpr2TransposeNode((MathExprParser.TransExprContext) expr);
        }
        if (expr instanceof MathExprParser.LiteralExprContext) {
            return literalExpr2ExprNode((MathExprParser.LiteralExprContext) expr);
        }
        throw new RuntimeException("unimplemented in MathExprTruffleParser " + expr.getClass());
    }

    private static MathExprNode transExpr2TransposeNode(MathExprParser.TransExprContext transposeExpr) {
        if (transposeExpr.matrix() != null) {
            MathExprNode transposeNode = TransposeNodeGen.create(ParseTree2MatrixNode(transposeExpr.matrix().children));
            return transposeNode;
        }
        if (transposeExpr.vector() != null) {
            TransposeNode transposeNode = TransposeNodeGen.create(ParseTree2VectorNode(transposeExpr.vector().children));
            return transposeNode;
        }
        throw new RuntimeException("error in antlr configuration");
    }

    private static MathExprNode negationExpr2NegationNode(MathExprParser.NegationExprContext negationExpr) {
        NegationNode negationNode = NegationNodeGen.create(expr2TruffleNode(negationExpr.expr()));
        return negationNode;
    }

    private static MathExprNode functionExpr2ExpressionNode(MathExprParser.FunctionExprContext sinusExpr) {
        if (sinusExpr.IDENTIFIER().toString().equals("sin")) {
            SinusNode sinusNode = SinusNodeGen.create(expr2TruffleNode(sinusExpr.expr()));
            return sinusNode;
        }
        if (sinusExpr.IDENTIFIER().toString().equals("cos")) {
            CosinusNode cosinusNode = CosinusNodeGen.create(expr2TruffleNode(sinusExpr.expr()));
            return cosinusNode;
        }
        throw new RuntimeException("function not implemented yet");
    }

    private static MatrixLiteralNode ParseTree2MatrixNode(List<ParseTree> matrixLiterals) {
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
        return new MatrixLiteralNode(Nd4j.createFromArray(matrixLines));
    }

    private static MathExprNode matrixExpr2MatrixNode(MathExprParser.MatrixExprContext expr) {
        var matrixExprLiteral = (MathExprParser.MatrixContext) expr.children.get(0);
        var matrixLiterals = matrixExprLiteral.children;
        return ParseTree2MatrixNode(matrixLiterals);
    }

    private static VectorLiteralNode ParseTree2VectorNode(List<ParseTree> vectorLiterals) {
        var array = literalsToArray(vectorLiterals);
        return new VectorLiteralNode(Nd4j.createFromArray(array).reshape(array.length, 1));
    }

    private static MathExprNode vectorExpr2VectorNode(MathExprParser.VectorExprContext expr) {
        var vectorExprLiteral = (MathExprParser.VectorContext) expr.children.get(0);
        var vectorLiterals = vectorExprLiteral.children;
        return ParseTree2VectorNode(vectorLiterals);
    }

    private static double[] literalsToArray(List<ParseTree> children) {
        return children.stream().filter(e -> e instanceof MathExprParser.DoubleLiteralContext).map(e -> e.getText()).mapToDouble(e -> Double.valueOf(e)).toArray();
    }

    private static MathExprNode parenExpr2ExpressionNode(MathExprParser.ParenExprContext parenExpr) {
        return expr2TruffleNode(parenExpr.expr());
    }

    private static MathExprNode multExpr2MultNode(MathExprParser.MultExprContext multExpr) {
        if (multExpr.SOLIDUS() != null) {
            DivNode divNode = DivNodeGen.create(expr2TruffleNode(multExpr.expr(0)), expr2TruffleNode(multExpr.expr(1)));
            return divNode;
        }
        if (multExpr.ASTERISK() != null) {
            MultNode multNode = MultNodeGen.create(expr2TruffleNode(multExpr.expr(0)), expr2TruffleNode(multExpr.expr(1)));
            return multNode;
        }
        CrossProductNode crossProductNode = CrossProductNodeGen.create(expr2TruffleNode(multExpr.expr(0)), expr2TruffleNode(multExpr.expr(1)));
        return crossProductNode;
    }

    private static MathExprNode addExpr2AddNode(MathExprParser.AddExprContext addExpr) {
        if (addExpr.HYPHEN_MINUS() != null) {
            SubstrNode substrNode = SubstrNodeGen.create(expr2TruffleNode(addExpr.expr(0)), expr2TruffleNode(addExpr.expr(1)));
            return substrNode;
        }
        AddNode addNode = AddNodeGen.create(expr2TruffleNode(addExpr.expr(0)), expr2TruffleNode(addExpr.expr(1)));
        return addNode;
    }

    private static MathExprNode literalExpr2ExprNode(MathExprParser.LiteralExprContext literalExpr) {
        return new DoubleLiteralNode(Double.parseDouble(literalExpr.POSITIVEDOUBLE().toString()));
    }

    private static MathExprNode expExpr2PotentialNode(MathExprParser.ExponentExprContext expExpr) {
        PotentiateNode potentiateNode = PotentiateNodeGen.create(expr2TruffleNode(expExpr.expr(0)), expr2TruffleNode(expExpr.expr(1)));
        return potentiateNode;
    }
}
