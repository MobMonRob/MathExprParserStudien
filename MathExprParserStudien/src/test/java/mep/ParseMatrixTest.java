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
        var result = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;]");

        var expectedArr = new double[][]{{2} , {4} , {5} , {7.7}};
        var expectedBase = Nd4j.createFromArray(expectedArr);

        assertEquals( expectedBase, result);
    }
    @Test
    public void MatrixExprTest(){
        var result = Testevaluation.evaluateStringtoArray("[0 1; 2 3;]");

        var expectedBase = Nd4j.arange(4).reshape(2,2);

        assertEquals( expectedBase.toString(), result.toString());
    }
    @Test
    public void MatrixMultTest(){
        var result = Testevaluation.evaluateStringtoArray("[0 1; 2 3;] * [0 1; 2 3;]");
        var expected = new Double[][]{
                {2.0,3.0},
                {6.0,11.0}
        };
        var expectedBase = Nd4j.createFromArray(expected);
        assertEquals( expectedBase.toString(), result.toString());
    }

    @Test
    public void VectorAddTest(){
        var result2Vectors = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] + [2; 0; -1; -2;]");
        var expectedArr = new double[][]{{4} , {4} , {4} , {5.7}};
        var expectedBase = Nd4j.createFromArray(expectedArr);

        assertEquals( expectedBase.toString(), result2Vectors.toString());
    }
}
