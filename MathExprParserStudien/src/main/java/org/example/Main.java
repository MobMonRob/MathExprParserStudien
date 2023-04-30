package org.example;

import com.oracle.truffle.api.nodes.RootNode;
import org.example.Nodes.MathExprNode;
import org.example.Nodes.MathExprRootNode;
import org.example.Parsing.MathExprTruffleParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Warm up
        new MathExprRootNode(MathExprTruffleParser.parse("[2 2; 3 3;] * [2 2; 3 3;]")).getCallTarget().call();

        while (true){
            System.out.print("Function: ");
            String input = new Scanner(System.in).nextLine();
            long start = System.currentTimeMillis();
            MathExprNode mathExprNode = MathExprTruffleParser.parse(input);
            RootNode rootNode = new MathExprRootNode(mathExprNode);
            String result = rootNode.getCallTarget().call().toString();
            long end = System.currentTimeMillis();
            System.out.println("Result: " + result + " in " + (end - start) + "ms");
        }
    }
}