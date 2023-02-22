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
            return addExpr2AddNode((MathExprParser.AddExprContext)expr);
        }
        if (expr instanceof MathExprParser.LiteralExprContext){
            return literalExpr2ExprNode((MathExprParser.LiteralExprContext)expr);
        }
        return null;
   }

    private static AddNode addExpr2AddNode(MathExprParser.AddExprContext addExpr) {
        return new AddNode(
                expr2TruffleNode(addExpr.expr(0)),
                expr2TruffleNode(addExpr.expr(1))
        );
    }

    private static MathExprNode literalExpr2ExprNode(MathExprParser.LiteralExprContext literalExpr) {
        return new IntLiteralNode(Integer.parseInt(literalExpr.NUM().toString()));
    }
}
