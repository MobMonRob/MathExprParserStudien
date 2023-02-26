package mep;

import com.oracle.truffle.api.CallTarget;
import org.example.Nodes.MathExprRootNode;
import org.example.Parsing.MathExprTruffleParser;
import org.junit.Test;
import org.nd4j.linalg.factory.Nd4j;

import static org.junit.Assert.assertEquals;

public class ParseMatrixTest {
    @Test
    public void VectorExprTest(){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse("[2; 4; 5; 7.7;]");
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        var expectedArr = new double[][]{{2} , {4} , {5} , {7.7}};
        var expectedBase = Nd4j.createFromArray(expectedArr);

        assertEquals( expectedBase, result);
    }
    @Test
    public void MatrixExprTest(){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse("[0 1; 2 3;]");
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        var expectedBase = Nd4j.arange(4).reshape(2,2);

        assertEquals( expectedBase.toString(), result.toString());
    }

    @Test
    public void MatrixMultTeest(){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse("[0 1; 2 3;] * [0 1; 2 3;]");
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();
        var result = callTarget.call();
        var expected = new Double[][]{
                {2.0,3.0},
                {6.0,11.0}
        };
        var expectedBase = Nd4j.createFromArray(expected);
        assertEquals( expectedBase.toString(), result.toString());
    }
}
