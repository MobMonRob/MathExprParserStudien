package mep;

import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ParseMatrixTest {
    @Test
    public void VectorExprTest() {
        INDArray result = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;]");
        INDArray expectedBase = Nd4j.createFromArray(new double[][]{{2}, {4}, {5}, {7.7}});
        assertEquals(expectedBase, result);
    }

    @Test
    public void MatrixExprTest() {
        INDArray result = Testevaluation.evaluateStringtoArray("[0 1; 2 3;]");
        INDArray expectedBase = Nd4j.arange(4).reshape(2, 2);
        assertEquals(expectedBase.toString(), result.toString());
    }

    @Test
    public void MatrixMultTest() {
        INDArray result = Testevaluation.evaluateStringtoArray("[0 1; 2 3;] * [0 1; 2 3;]");
        INDArray expectedBase = Nd4j.createFromArray(new double[][]{{2.0, 3.0}, {6.0, 11.0}});
        assertEquals(expectedBase, result);
    }

    @Test
    public void VectorAddTest() {
        INDArray resultVector = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] + [2; 0; -1; -2;]");
        INDArray expected = Nd4j.createFromArray(new double[][]{{4}, {4}, {4}, {5.7}});
        assertEquals(expected, resultVector);

        resultVector = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] + 3.7");
        expected = Nd4j.createFromArray(new double[][]{{5.7}, {7.7}, {8.7}, {11.4}});
        assertEquals(expected, resultVector);

        assertThrows(IllegalStateException.class, () -> Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] + [3.7;4;]"));
        //TODO what exception should be returned?
    }

    @Test
    public void MatrixAddTest() {
        INDArray resultVector = Testevaluation.evaluateStringtoArray("[1 2; 5 14;] + [-1 3.3; 5 14;]");
        INDArray expected = Nd4j.createFromArray(new double[][]{{0.0, 5.3}, {10.0, 28.0}});
        assertEquals(expected, resultVector);

        INDArray resultMatrix = Testevaluation.evaluateStringtoArray("[1 2; 5 14;] + 7");
        expected = Nd4j.createFromArray(new double[][]{{8.0, 9.0}, {12.0, 21.0}});
        assertEquals(expected, resultMatrix);
    }

    @Test
    public void VMCosTest() {
        INDArray resultVector = Testevaluation.evaluateStringtoArray("cos([1; 2; 5; -3;])");
        assertEquals(0.54030230586, resultVector.getDouble(0), 0.0001);
        assertEquals(-0.41614683654, resultVector.getDouble(1), 0.0001);
        assertEquals(0.28366218546, resultVector.getDouble(2), 0.0001);
        assertEquals(-0.9899924966, resultVector.getDouble(3), 0.0001);

        INDArray resultMatrix = Testevaluation.evaluateStringtoArray("cos([1 2; 5 -3;])");
        assertEquals(0.54030230586, resultMatrix.getDouble(0), 0.0001);
        assertEquals(-0.41614683654, resultMatrix.getDouble(1), 0.0001);
        assertEquals(0.28366218546, resultMatrix.getDouble(2), 0.0001);
        assertEquals(-0.9899924966, resultMatrix.getDouble(3), 0.0001);
    }

    @Test
    public void VMSinTest() {
        INDArray resultVector = Testevaluation.evaluateStringtoArray("sin([1; 2; 5; -3;])");
        assertEquals(0.8414709848, resultVector.getDouble(0), 0.0001);
        assertEquals(0.90929742682, resultVector.getDouble(1), 0.0001);
        assertEquals(-0.95892427466, resultVector.getDouble(2), 0.0001);
        assertEquals(-0.14112000806, resultVector.getDouble(3), 0.0001);

        INDArray resultMatrix = Testevaluation.evaluateStringtoArray("sin([1 2; 5 -3;])");
        assertEquals(0.8414709848, resultMatrix.getDouble(0), 0.0001);
        assertEquals(0.90929742682, resultMatrix.getDouble(1), 0.0001);
        assertEquals(-0.95892427466, resultMatrix.getDouble(2), 0.0001);
        assertEquals(-0.14112000806, resultMatrix.getDouble(3), 0.0001);
    }

    @Test
    public void VMDivTest() {
        INDArray resultVector = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.5;] / 0.5");
        INDArray expected = Nd4j.createFromArray(new double[][]{{4}, {8}, {10}, {15}});
        assertEquals(expected, resultVector);

        INDArray resultMatrix = Testevaluation.evaluateStringtoArray("[14 21; 28 7;] / 7");
        expected = Nd4j.createFromArray(new double[][]{{2, 3}, {4, 1}});
        assertEquals(expected, resultMatrix);
    }

    @Test
    public void VMMulTest() {
        double resultDouble = Testevaluation.evaluateStringtoDouble("[2; 4; 5;] * [2; 1; -1;]");
        assertEquals(3.0, resultDouble, 0.0001);

        INDArray resultVector = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;]* 0.5");
        INDArray expected = Nd4j.createFromArray(new double[][]{{1}, {2}, {2.5}, {3.85}});
        assertEquals(expected, resultVector);

        INDArray resultMatrix = Testevaluation.evaluateStringtoArray("[1 2; 5 14;] * [-1 3.3; 5 7;]");
        expected = Nd4j.createFromArray(new double[][]{{9, 17.3}, {65, 114.5}});
        assertEquals(expected, resultMatrix);

        resultMatrix = Testevaluation.evaluateStringtoArray("[1 2; 5 -3.3;] * 7");
        expected = Nd4j.createFromArray(new double[][]{{7, 14}, {35, -23.1}});
        assertEquals(expected, resultMatrix);

        assertThrows(IllegalStateException.class, () -> Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] * [3.7;4;]"));
    }

    @Test
    public void VMSubstrTest() {
        INDArray resultVector = Testevaluation.evaluateStringtoArray("[2; 4; 5;] - [2; 1; -1;]");
        INDArray expected = Nd4j.createFromArray(new double[][]{{0}, {3}, {6}});
        assertEquals(expected, resultVector);

        resultVector = Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;]- 0.5");
        expected = Nd4j.createFromArray(new double[][]{{1.5}, {3.5}, {4.5}, {7.2}});
        assertEquals(expected, resultVector);

        INDArray resultMatrix = Testevaluation.evaluateStringtoArray("[1 2; 5 14;] - [-1 3.3; 5 7;]");
        expected = Nd4j.createFromArray(new double[][]{{2, -1.3}, {0, 7}});
        assertEquals(expected, resultMatrix);

        assertThrows(IllegalStateException.class, () -> Testevaluation.evaluateStringtoArray("[2; 4; 5; 7.7;] - [3.7;4;]"));
    }

    @Test
    public void VMNegationTest() {
        INDArray resultVector = Testevaluation.evaluateStringtoArray("-[2; 1; -1;]");
        INDArray expected = Nd4j.createFromArray(new double[][]{{-2}, {-1}, {1}});
        assertEquals(expected, resultVector);

        INDArray resultMatrix = Testevaluation.evaluateStringtoArray("-[1 2; 5 -14.3;]");
        expected = Nd4j.createFromArray(new double[][]{{-1, -2}, {-5, 14.3}});
        assertEquals(expected, resultMatrix);
    }

    @Test
    public void VMPowTest() {
        INDArray resultVector = Testevaluation.evaluateStringtoArray("[2; 1; -1;]^3");
        INDArray expected = Nd4j.createFromArray(new double[][]{{8}, {1}, {-1}});
        assertEquals(expected, resultVector);

        INDArray resultMatrix = Testevaluation.evaluateStringtoArray("[1 2; 5 -4.3;]^3");
        expected = Nd4j.createFromArray(new double[][]{{1, 8}, {125, -79.5070}});
        assertEquals(expected, resultMatrix);
    }

    @Test
    public void VMTransposeTest() {
        // TODO: transpose node is not executed correctly but transpose node is correct
        // TODO: weird error for 3x2 matrices
        INDArray resultMatrix = Testevaluation.evaluateStringtoArray("[2 6 7; 5 1 7; 4 7 7;]'");
        INDArray expected = Nd4j.create(new double[][]{{2, 5, 4}, {6, 1 , 7}, {7, 7 ,7}});
        assertEquals(expected, resultMatrix);
    }

    @Test
    public void CrossProduct() {
        INDArray result = Testevaluation.evaluateStringtoArray("[2; 4; 5;] x [0; 3; 2;]");
        INDArray expected = Nd4j.createFromArray(new double[][]{{-7}, {-4}, {6}});
        assertEquals(expected, result);
    }
}
