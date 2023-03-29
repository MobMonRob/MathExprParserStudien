package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class SubstrNode extends MathExprNode {
    @Child
    private MathExprNode leftNode;
    @Child
    private MathExprNode rightNode;

    public SubstrNode(MathExprNode left, MathExprNode right) {
        this.leftNode = left;
        this.rightNode = right;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        double leftVal = this.leftNode.executeDouble(frame);
        double rightVal = this.rightNode.executeDouble(frame);
        return leftVal - rightVal;
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        try {
            INDArray leftVal = this.leftNode.executeVector(frame);
            INDArray rightVal = this.rightNode.executeVector(frame);
            return leftVal.sub(rightVal);
        } catch (UnexpectedResultException e) {
        }
        try {
            INDArray leftVal = this.leftNode.executeVector(frame);
            Double rightVal = this.rightNode.executeDouble(frame);
            return leftVal.sub(rightVal);
        } catch (UnexpectedResultException e) {
        }
        Double leftVal = this.leftNode.executeDouble(frame);
        INDArray rightVal = this.rightNode.executeVector(frame);
        return rightVal.sub(leftVal);
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        // Matrix - Scalar ist nicht definiert, von daher wird nur Matrix - Matrix und Matrix - Vector unterstützt
        INDArray leftVal = this.leftNode.executeMatrix(frame);
        INDArray rightVal = this.rightNode.executeMatrix(frame);
        return leftVal.sub(rightVal);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        try {
            return executeDouble(frame);
        } catch (UnexpectedResultException e) {
        }
        try {
            return executeVector(frame);
        } catch (UnexpectedResultException e) {
            return executeMatrix(frame);
        }
    }
}
