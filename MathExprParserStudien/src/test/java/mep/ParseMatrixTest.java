package mep;

import org.junit.Test;
import org.nd4j.linalg.factory.Nd4j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
        var expected = new double[][]{
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

        var resultVectorDouble = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] + 3.7");
        var newExpectedArr = new double[][]{{5.7} , {7.7} , {8.7} , {11.4}};
        var newExpectedBase = Nd4j.createFromArray(newExpectedArr);
        assertEquals( newExpectedBase.toString(), resultVectorDouble.toString());

        assertThrows(IllegalStateException.class, () -> Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] + [3.7;4;]"));
        //TODO what exception should be returned?
    }
    @Test
    public void MatrixAddTest(){
        var result2Vectors = Testevaluation.evaluateStringtoArray("[1 2; 5 14;] + [-1 3.3; 5 14;]");
        var expected = new double[][]{
                {0.0,5.3},
                {10.0,28.0}
        };
        var expectedBase = Nd4j.createFromArray(expected);

        assertEquals( expectedBase.toString(), result2Vectors.toString());

        var resultVectorDouble = Testevaluation.evaluateStringtoArray("[1 2; 5 14;] + 7");
        var newExpected = new double[][]{
                {8.0,9},
                {12.0,21.0}
        };
        var newExpectedBase = Nd4j.createFromArray(newExpected);
        assertEquals( newExpectedBase.toString(), resultVectorDouble.toString());
    }
    @Test
    public void VMCosTest(){
        var resultVector = Testevaluation.evaluateStringtoArray("cos([1; 2; 5; -3;])");
        assertEquals(0.54030230586 , resultVector.getDouble(0),0.0001);
        assertEquals(-0.41614683654 , resultVector.getDouble(1),0.0001);
        assertEquals(0.28366218546 , resultVector.getDouble(2),0.0001);
        assertEquals(-0.9899924966 , resultVector.getDouble(3),0.0001);

        var resultMatrix = Testevaluation.evaluateStringtoArray("cos([1 2; 5 -3;])");

        assertEquals(0.54030230586 , resultMatrix.getDouble(0),0.0001);
        assertEquals(-0.41614683654 , resultMatrix.getDouble(1),0.0001);
        assertEquals(0.28366218546 , resultMatrix.getDouble(2),0.0001);
        assertEquals(-0.9899924966 , resultMatrix.getDouble(3),0.0001);
    }
    @Test
    public void VMSinTest(){
        var resultVector = Testevaluation.evaluateStringtoArray("sin([1; 2; 5; -3;])");
        assertEquals(0.8414709848 , resultVector.getDouble(0),0.0001);
        assertEquals(0.90929742682 , resultVector.getDouble(1),0.0001);
        assertEquals(-0.95892427466 , resultVector.getDouble(2),0.0001);
        assertEquals(-0.14112000806 , resultVector.getDouble(3),0.0001);

        var resultMatrix = Testevaluation.evaluateStringtoArray("sin([1 2; 5 -3;])");
        assertEquals(0.8414709848 , resultMatrix.getDouble(0),0.0001);
        assertEquals(0.90929742682 , resultMatrix.getDouble(1),0.0001);
        assertEquals(-0.95892427466 , resultMatrix.getDouble(2),0.0001);
        assertEquals(-0.14112000806 , resultMatrix.getDouble(3),0.0001);
    }
    @Test
    public void VMDivTest(){
        var result2Vectors = Testevaluation.evaluateStringtoArray("[2; 4; 5;] / [2; 1; -1;]");
        var expected = new double[][]{{1} , {4} , {-5}};
        var expectedBase = Nd4j.createFromArray(expected);

        assertEquals( expectedBase.toString(), result2Vectors.toString());

        var resultVectorDouble = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] / 0.5");
        expected = new double[][]{{4} , {8} , {10} , {15.4}};
        expectedBase = Nd4j.createFromArray(expected);
        assertEquals( expectedBase.toString(), resultVectorDouble.toString());

        assertThrows(IllegalStateException.class, () -> Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] / [3.7;4;]"));

        var result2Matrix = Testevaluation.evaluateStringtoArray("[1 2; 5 14;] / [-1 3.3; 5 7;]");
        expected = new double[][]{
                {-1.0000,    0.6061},
                {1,2}
        };
        expectedBase = Nd4j.createFromArray(expected);

        assertEquals( expectedBase.toString(), result2Matrix.toString());

        var resultMatrixDouble = Testevaluation.evaluateStringtoArray("[1 2; 5 14;] / 7");
        expected = new double[][]{
                {0.1429,0.2857},
                {0.7143,    2.0000}
        };
        expectedBase = Nd4j.createFromArray(expected);
        assertEquals( expectedBase.toString(), resultMatrixDouble.toString());
    }
    @Test
    public void VMMulTest(){
        var result2Vectors = Testevaluation.evaluateStringtoArray("[2; 4; 5;] * [2; 1; -1;]");
        var expected = new double[][]{{4} , {4} , {-5}};
        var expectedBase = Nd4j.createFromArray(expected);

        assertEquals( expectedBase.toString(), result2Vectors.toString());

        var resultVectorDouble = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;]* 0.5");
        expected = new double[][]{{1} , {2} , {2.5} , {3.85}};
        expectedBase = Nd4j.createFromArray(expected);
        assertEquals( expectedBase.toString(), resultVectorDouble.toString());

        assertThrows(IllegalStateException.class, () -> Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] * [3.7;4;]"));

        var result2Matrix = Testevaluation.evaluateStringtoArray("[1 2; 5 14;] * [-1 3.3; 5 7;]");
        expected = new double[][]{
                {9,    17.3},
                {65,114.5}
        };
        expectedBase = Nd4j.createFromArray(expected);

        assertEquals( expectedBase.toString(), result2Matrix.toString());

        var resultMatrixDouble = Testevaluation.evaluateStringtoArray("[1 2; 5 -3.3;] * 7");
        expected = new double[][]{
                {7,14},
                {35,    -23.1}
        };
        expectedBase = Nd4j.createFromArray(expected);
        assertEquals( expectedBase.toString(), resultMatrixDouble.toString());
    }
    @Test
    public void VMSubstrTest(){
        var result2Vectors = Testevaluation.evaluateStringtoArray("[2; 4; 5;] - [2; 1; -1;]");
        var expected = new double[][]{{0} , {3} , {6}};
        var expectedBase = Nd4j.createFromArray(expected);

        assertEquals( expectedBase.toString(), result2Vectors.toString());

        var resultVectorDouble = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;]- 0.5");
        expected = new double[][]{{1.5} , {3.5} , {4.5} , {7.2}};
        expectedBase = Nd4j.createFromArray(expected);
        assertEquals( expectedBase.toString(), resultVectorDouble.toString());

        assertThrows(IllegalStateException.class, () -> Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] - [3.7;4;]"));

        var result2Matrix = Testevaluation.evaluateStringtoArray("[1 2; 5 14;] - [-1 3.3; 5 7;]");
        expected = new double[][]{
                {2, -1.3},
                {0,7}
        };
        expectedBase = Nd4j.createFromArray(expected);

        assertEquals( expectedBase.toString(), result2Matrix.toString());

        var resultMatrixDouble = Testevaluation.evaluateStringtoArray("[1 2; 5 -3.3;] - 7");
        expected = new double[][]{
                {-6,-5},
                {-2, -10.3}
        };
        expectedBase = Nd4j.createFromArray(expected);
        assertEquals( expectedBase.toString(), resultMatrixDouble.toString());
    }
    @Test
    public void VMNegationTest(){
        var result2Vectors = Testevaluation.evaluateStringtoArray("-[2; 1; -1;]");
        var expected = new double[][]{{-2} , {-1} , {1}};
        var expectedBase = Nd4j.createFromArray(expected);

        assertEquals(expectedBase.toString(), result2Vectors.toString());

        var result2Matrix = Testevaluation.evaluateStringtoArray("-[1 2; 5 -14.3;]");
        expected = new double[][]{
                {-1,   -2},
                {-5, 14.3}
        };
        expectedBase = Nd4j.createFromArray(expected);

        assertEquals( expectedBase.toString(), result2Matrix.toString());
    }
    @Test
    public void VMPowTest(){
        var result2Vectors = Testevaluation.evaluateStringtoArray("[2; 1; -1;]^3");
        var expected = new double[][]{{8} , {1} , {-1}};
        var expectedBase = Nd4j.createFromArray(expected);

        assertEquals(expectedBase.toString(), result2Vectors.toString());

        var result2Matrix = Testevaluation.evaluateStringtoArray("[1 2; 5 -4.3;]^3");
        expected = new double[][]{
                {1,   8},
                {125, -79.5070}
        };
        expectedBase = Nd4j.createFromArray(expected);

        assertEquals( expectedBase.toString(), result2Matrix.toString());
    }
    @Test
    public void VMTransposeTest(){
        var result2Vectors = Testevaluation.evaluateStringtoArray("[2; 1; -1;]'");
        var expected = new double[][]{{2} , {1} , {-1}};
        var expectedBase = Nd4j.createFromArray(expected);

        assertEquals(expectedBase.toString(), result2Vectors.toString());

        var result2Matrix = Testevaluation.evaluateStringtoArray("[1 2; 5 -4.3;]'");
        expected = new double[][]{
                {1,   5},
                {2, -4.3}
        };
        expectedBase = Nd4j.createFromArray(expected);

        assertEquals( expectedBase.toString(), result2Matrix.toString());
    }

    /*public void CrossProduct(){
        var result = Testevaluation.evaluateStringtoArray("[2; 4; 5;] x [0; 3; 2;]");

        var expectedArr = new double[][]{{-7} , {-4}, {6}};
        var expectedBase = Nd4j.createFromArray(expectedArr);

        assertEquals( expectedBase, result);
    }*/
}
