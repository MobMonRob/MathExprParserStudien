package mep;

import com.oracle.truffle.api.CallTarget;
import org.example.Nodes.DataTypeNodes.DoubleLiteralNode;
import org.example.Nodes.DataTypeNodes.MatrixLiteralNode;
import org.example.Nodes.DataTypeNodes.VectorLiteralNode;
import org.example.Nodes.MathExprNode;
import org.example.Nodes.MathExprRootNode;
import org.example.Nodes.OperationNodes.*;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import static org.junit.Assert.assertEquals;

public class ExecuteNodesTest {
    @Test
    public void addNodeDouble() {
        MathExprNode exprNode = new AddNode(new DoubleLiteralNode(22), new DoubleLiteralNode(9));
        MathExprRootNode rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(31.0, result, 0.00001);
    }

    @Test
    public void substrNodeDouble() {
        MathExprNode exprNode = new SubstrNode(new DoubleLiteralNode(22), new DoubleLiteralNode(9));
        MathExprRootNode rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(13.0, result, 0.00001);
    }

    @Test
    public void cosinusNodeDouble() {
        MathExprNode exprNode = new CosinusNode(new DoubleLiteralNode(Math.PI));
        MathExprRootNode rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(-1.0, result, 0.00001);
    }

    @Test
    public void sinusNodeDouble() {
        MathExprNode exprNode = new SinusNode(new DoubleLiteralNode(Math.PI));
        MathExprRootNode rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(0.0, result, 0.00001);
    }

    @Test
    public void divNodeDouble() {
        MathExprNode exprNode = new DivNode(new DoubleLiteralNode(22), new DoubleLiteralNode(11));
        MathExprRootNode rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(2.0, result, 0.00001);
    }

    @Test
    public void multNodeDouble() {
        MathExprNode exprNode = new MultNode(new DoubleLiteralNode(22), new DoubleLiteralNode(5));
        MathExprRootNode rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(110.0, result, 0.00001);

        INDArray vector = Nd4j.create(new double[]{1, 2, 3});
        MathExprNode exprNode1 = new MultNode(new VectorLiteralNode(vector), new VectorLiteralNode(vector));
        MathExprRootNode rootNode1 = new MathExprRootNode(exprNode1);
        CallTarget callTarget1 = rootNode1.getCallTarget();

        result = (double) callTarget1.call();
        assertEquals(14.0, result, 0.00001);
    }

    @Test
    public void potentiateNodeDouble() {
        MathExprNode exprNode = new PotentiateNode(new DoubleLiteralNode(4), new DoubleLiteralNode(4));
        MathExprRootNode rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(256.0, result, 0.00001);
    }

    @Test
    public void transposeNodeVector() {
        INDArray matrix = Nd4j.create(new double[][]{{1, 2, 3}});
        MathExprNode exprNode = new TransposeNode(new VectorLiteralNode(matrix));
        MathExprRootNode rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        INDArray result = (INDArray) callTarget.call();
        INDArray expected = Nd4j.create(new double[][]{{1}, {2}, {3}});
        assertEquals(expected, result);
    }

    @Test
    public void transposeNodeMatrix() {
        INDArray matrix = Nd4j.create(new double[][]{{1, 2, 3}, {4, 5, 6}});
        MathExprNode exprNode = new TransposeNode(new MatrixLiteralNode(matrix));
        MathExprRootNode rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        INDArray result = (INDArray) callTarget.call();
        INDArray expected = Nd4j.create(new double[][]{{1, 4}, {2, 5}, {3, 6}});
        assertEquals(expected, result);
    }

    @Test
    public void crossProductNodeVector() {
        INDArray vector = Nd4j.create(new double[][]{{1}, {2}, {3}});
        INDArray vector1 = Nd4j.create(new double[][]{{4}, {5}, {6}});
        MathExprNode exprNode = new CrossProductNode(new VectorLiteralNode(vector), new VectorLiteralNode(vector1));
        MathExprRootNode rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        INDArray result = (INDArray) callTarget.call();
        INDArray expected = Nd4j.create(new double[][]{{-3}, {6}, {-3}});
        assertEquals(expected, result);
    }
}
