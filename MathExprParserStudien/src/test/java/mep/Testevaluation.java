package mep;

import com.oracle.truffle.api.CallTarget;
import org.example.Nodes.MathExprRootNode;
import org.example.Parsing.MathExprTruffleParser;
import org.nd4j.linalg.api.ndarray.INDArray;

public class Testevaluation {
    public static double evaluateStringtoDouble(String s){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse(s);
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        return (double) callTarget.call();
    }

    public static INDArray evaluateStringtoArray(String s){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse(s);
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        return (INDArray) callTarget.call();
    }
}
