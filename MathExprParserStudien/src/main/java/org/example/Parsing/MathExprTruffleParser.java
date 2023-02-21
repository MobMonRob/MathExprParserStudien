package org.example.Parsing;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.example.Nodes.ExpressionNodes.AddNode;
import org.example.Nodes.ExpressionNodes.IntLiteralNode;
import org.example.Nodes.MathExprNode;
import org.example.Parsing.Gen.MathExprLexer;
import org.example.Parsing.Gen.MathExprParser;

import java.io.IOException;
import java.io.Reader;

public class MathExprTruffleParser {

    public static MathExprNode parse(String program) {
        return parse(CharStreams.fromString(program));
    }
/*
    public static MathExprNode parse(Reader program) throws IOException {
        return parse(CharStreams.fromReader(program));
    }*/

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
        if (expr instanceof MathExprParser.AddExprContext){
            MathExprParser.AddExprContext addexpr = (MathExprParser.AddExprContext) expr;
            return new AddNode(
                    expr2TruffleNode(addexpr.expr(0)),
                    expr2TruffleNode(addexpr.expr(2))
            ); //;addExpr2AddNode((MathExprParser.AddExprContext)expr);
        }
        return null;
        /*return expr instanceof MathExprParser.ExprContext
                ? addExpr2AdditionNode((MathExprParser.AddExprContext) expr)
                : literalExpr2ExprNode((MathExprParser.LiteralExprContext) expr);
*/

    }

    /*private static AddNode addExpr2AddNode(MathExprParser.AddExprContext addExpr) {
        /*return new AddNode(
                new IntLiteralNode(22),
                new IntLiteralNode(9)
        );
    }*/



    /*private static MathExprNode literalExpr2ExprNode(MathExprParser.LiteralExprContext literalExpr) {
        TerminalNode intTerminal = literalExpr.literal().INT();
        return intTerminal != null
                ? parseIntLiteral(intTerminal.getText())
                : parseDoubleLiteral(literalExpr.getText());
    }

    private static MathExprNode parseIntLiteral(String text) {
        try {
            return new IntLiteralNode(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            // it's possible that the integer literal is too big to fit in a 32-bit Java `int` -
            // in that case, fall back to a double literal
            return parseDoubleLiteral(text);
        }
    }*/
}
