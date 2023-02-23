package org.example.Parsing;

import org.antlr.v4.runtime.*;
import org.example.Nodes.DataTypeNodes.DoubleLiteralNode;
import org.example.Nodes.OperationNodes.*;
import org.example.Nodes.MathExprNode;
import org.example.Parsing.Gen.MathExprLexer;
import org.example.Parsing.Gen.MathExprParser;

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
        if (expr instanceof MathExprParser.AddExprContext) {
            return addExpr2AddNode((MathExprParser.AddExprContext) expr);
        }
        if (expr instanceof MathExprParser.LiteralExprContext) {
            return literalExpr2ExprNode((MathExprParser.LiteralExprContext) expr);
        }
        if (expr instanceof MathExprParser.DifExprContext) {
            return difExpr2DivNode((MathExprParser.DifExprContext) expr);
        }
        if (expr instanceof MathExprParser.MultExprContext) {
            return multExpr2MultNode((MathExprParser.MultExprContext) expr);
        }
        if (expr instanceof MathExprParser.DivExprContext) {
            return divExpr2MultNode((MathExprParser.DivExprContext) expr);
        }
        if (expr instanceof MathExprParser.ExponentExprContext) {
            return expExpr2PotentialNode((MathExprParser.ExponentExprContext) expr);
        }
        if(expr instanceof  MathExprParser.ParenExprContext){
            return parenExpr2ExpressionNode((MathExprParser.ParenExprContext) expr);
        }
        return null;
    }

    private static MathExprNode parenExpr2ExpressionNode(MathExprParser.ParenExprContext parenExpr) {
        return expr2TruffleNode(parenExpr.expr());
    }

    private static MathExprNode divExpr2MultNode (MathExprParser.DivExprContext divExpr){
            return new DivNode(
                    expr2TruffleNode(divExpr.expr(0)),
                    expr2TruffleNode(divExpr.expr(1))
            );
        }

        private static MathExprNode multExpr2MultNode (MathExprParser.MultExprContext multExpr){
            return new MultNode(
                    expr2TruffleNode(multExpr.expr(0)),
                    expr2TruffleNode(multExpr.expr(1))
            );
        }

        private static MathExprNode difExpr2DivNode (MathExprParser.DifExprContext difExpr){
            return new SubstrNode(
                    expr2TruffleNode(difExpr.expr(0)),
                    expr2TruffleNode(difExpr.expr(1))
            );
        }

        private static AddNode addExpr2AddNode (MathExprParser.AddExprContext addExpr){
            return new AddNode(
                    expr2TruffleNode(addExpr.expr(0)),
                    expr2TruffleNode(addExpr.expr(1))
            );
        }

        private static MathExprNode literalExpr2ExprNode (MathExprParser.LiteralExprContext literalExpr){
            return new DoubleLiteralNode(Integer.parseInt(literalExpr.DOUBLE().toString()));
        }


        private static MathExprNode expExpr2PotentialNode (MathExprParser.ExponentExprContext expExpr){
            return new PotentiateNode(
                    expr2TruffleNode(expExpr.expr(0)),
                    expr2TruffleNode(expExpr.expr(1))
            );
        }
    }
