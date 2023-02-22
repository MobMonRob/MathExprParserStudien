package org.example;

import com.oracle.truffle.api.CallTarget;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.example.Nodes.MathExprNode;
import org.example.Nodes.MathExprRootNode;
import org.example.Parsing.Gen.MathExprParser;
import org.example.Parsing.Gen.MathExprLexer;
import org.example.Parsing.MathExprTruffleParser;

public class Main {
    public static void main(String[] args) {

    }
}