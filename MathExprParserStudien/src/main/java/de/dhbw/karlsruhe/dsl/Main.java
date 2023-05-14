package de.dhbw.karlsruhe.dsl;

import com.oracle.truffle.api.nodes.RootNode;
import de.dhbw.karlsruhe.dsl.Nodes.MathExprNode;
import de.dhbw.karlsruhe.dsl.Nodes.MathExprRootNode;
import de.dhbw.karlsruhe.dsl.Parsing.MathExprTruffleParser;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        timeMeasure();
        //inputFunction();
    }

    private static void inputFunction(){
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

    private static void timeMeasure(){
        int rounds = 1000;
        int[] results = new int[rounds];

        for (int i = 0; i < rounds; i++) {
            String input = generateFunction(10,10);
            long start = System.currentTimeMillis();
            MathExprNode mathExprNode = MathExprTruffleParser.parse(input);
            RootNode rootNode = new MathExprRootNode(mathExprNode);
            String result = rootNode.getCallTarget().call().toString();
            long end = System.currentTimeMillis();
            //System.out.println("Result: " + result + " in " + (end - start) + "ms");
            results[i] = (int) (end - start);
            System.out.println("Round " + (i+1) + " of " + rounds);
        }

        System.out.println("Results: " + Arrays.toString(results));
        System.out.println("Median: " + Arrays.stream(results).sorted().toArray()[rounds/2]);
        System.out.println("Average: " + Arrays.stream(results).average().getAsDouble());
        System.out.println("Max: " + Arrays.stream(results).max().getAsInt());
        System.out.println("Min: " + Arrays.stream(results).min().getAsInt());

    }

    private static String generateFunction(int size, int multiplications){
        Random random = new Random();
        StringBuilder function = new StringBuilder();
        int[] numbers = new int[size];

        for (int i = 0; i <= multiplications; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    numbers[k] = random.nextInt(256);
                }
                function.append(String.join(" ", Arrays.stream(numbers)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)));
                function.append("; ");
            }
            if (i != multiplications) function.append("] * [" );
        }
        String result = "[" + function + "]";

        return result;
    }
}