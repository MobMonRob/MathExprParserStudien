package de.dhbw.karlsruhe.dsl;

import com.oracle.truffle.api.CallTarget;
import de.dhbw.karlsruhe.dsl.Nodes.LiteralNodes.DoubleLiteralNode;
import de.dhbw.karlsruhe.dsl.Nodes.LiteralNodes.MatrixLiteralNode;
import de.dhbw.karlsruhe.dsl.Nodes.LiteralNodes.VectorLiteralNode;
import de.dhbw.karlsruhe.dsl.Nodes.MathExprRootNode;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.BinaryNodes.*;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.UnaryNodes.*;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import static org.junit.Assert.assertEquals;

public class ExecuteNodesTest {
    @Test
    public void addNodeDouble() {
        AddNode addNode = AddNodeGen.create(new DoubleLiteralNode(22), new DoubleLiteralNode(9));
        MathExprRootNode rootNode = new MathExprRootNode(addNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(31.0, result, 0.00001);
    }

    @Test
    public void substrNodeDouble() {
        SubstrNode substrNode = SubstrNodeGen.create(new DoubleLiteralNode(22), new DoubleLiteralNode(9));
        MathExprRootNode rootNode = new MathExprRootNode(substrNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(13.0, result, 0.00001);
    }

    @Test
    public void cosinusNodeDouble() {
        CosinusNode cosinusNode = CosinusNodeGen.create(new DoubleLiteralNode(Math.PI));
        MathExprRootNode rootNode = new MathExprRootNode(cosinusNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(-1.0, result, 0.00001);
    }

    @Test
    public void sinusNodeDouble() {
        SinusNode sinusNode = SinusNodeGen.create(new DoubleLiteralNode(Math.PI));
        MathExprRootNode rootNode = new MathExprRootNode(sinusNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(0.0, result, 0.00001);
    }

    @Test
    public void divNodeDouble() {
        DivNode divNode = DivNodeGen.create(new DoubleLiteralNode(22), new DoubleLiteralNode(11));
        MathExprRootNode rootNode = new MathExprRootNode(divNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(2.0, result, 0.00001);
    }

    @Test
    public void multNodeDouble() {
        MultNode multNode = MultNodeGen.create(new DoubleLiteralNode(22), new DoubleLiteralNode(5));
        MathExprRootNode rootNode = new MathExprRootNode(multNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(110.0, result, 0.00001);

        INDArray vector = Nd4j.create(new double[]{1, 2, 3});
        MultNode multNode1 = MultNodeGen.create(new DoubleLiteralNode(2), new VectorLiteralNode(vector));
        MathExprRootNode rootNode1 = new MathExprRootNode(multNode1);
        CallTarget callTarget1 = rootNode1.getCallTarget();

        INDArray result2 = (INDArray) callTarget1.call();
        assertEquals(Nd4j.create(new double[]{2, 4, 6}), result2);
    }

    @Test
    public void potentiateNodeDouble() {
        PotentiateNode potentiateNode = PotentiateNodeGen.create(new DoubleLiteralNode(4), new DoubleLiteralNode(4));
        MathExprRootNode rootNode = new MathExprRootNode(potentiateNode);
        CallTarget callTarget = rootNode.getCallTarget();

        double result = (double) callTarget.call();
        assertEquals(256.0, result, 0.00001);
    }

    @Test
    public void transposeNodeVector() {
        INDArray matrix = Nd4j.create(new double[][]{{1, 2, 3}});
        TransposeNode transposeNode = TransposeNodeGen.create(new VectorLiteralNode(matrix));
        MathExprRootNode rootNode = new MathExprRootNode(transposeNode);
        CallTarget callTarget = rootNode.getCallTarget();

        INDArray result = (INDArray) callTarget.call();
        INDArray expected = Nd4j.create(new double[][]{{1}, {2}, {3}});
        assertEquals(expected, result);
    }

    @Test
    public void transposeNodeMatrix() {
        INDArray matrix = Nd4j.create(new double[][]{{1, 2, 3}, {4, 5, 6}});
        TransposeNode transposeNode = TransposeNodeGen.create(new MatrixLiteralNode(matrix));
        MathExprRootNode rootNode = new MathExprRootNode(transposeNode);
        CallTarget callTarget = rootNode.getCallTarget();

        INDArray result = (INDArray) callTarget.call();
        INDArray expected = Nd4j.create(new double[][]{{1, 4}, {2, 5}, {3, 6}});
        assertEquals(expected, result);
    }

    @Test
    public void crossProductNodeVector() {
        INDArray vector = Nd4j.create(new double[][]{{1}, {2}, {3}});
        INDArray vector1 = Nd4j.create(new double[][]{{4}, {5}, {6}});
        CrossProductNode crossProductNode = CrossProductNodeGen.create(new VectorLiteralNode(vector), new VectorLiteralNode(vector1));
        MathExprRootNode rootNode = new MathExprRootNode(crossProductNode);
        CallTarget callTarget = rootNode.getCallTarget();

        INDArray result = (INDArray) callTarget.call();
        INDArray expected = Nd4j.create(new double[][]{{-3}, {6}, {-3}});
        assertEquals(expected, result);
    }
}
