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
        Object leftVal = this.leftNode.executeGeneric(frame);
        Object rightVal = this.rightNode.executeGeneric(frame);

        if (leftVal instanceof INDArray && rightVal instanceof INDArray) {
            INDArray left = (INDArray) leftVal;
            INDArray right = (INDArray) rightVal;
            return left.sub(right);
        } else if (leftVal instanceof INDArray && rightVal instanceof Double) {
            INDArray left = (INDArray) leftVal;
            Double right = (Double) rightVal;
            return left.sub(right);
        } else if (leftVal instanceof Double && rightVal instanceof INDArray) {
            Double left = (Double) leftVal;
            INDArray right = (INDArray) rightVal;
            return right.sub(left);
        }

        throw new UnexpectedResultException("Error in SubstrNode");
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        INDArray leftVal = this.leftNode.executeMatrix(frame);
        INDArray rightVal = this.rightNode.executeMatrix(frame);
        return leftVal.sub(rightVal);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object leftVal = this.leftNode.executeGeneric(frame);
        Object rightVal = this.rightNode.executeGeneric(frame);

        if (leftVal instanceof Double && rightVal instanceof Double) {
            return executeDouble(frame);
        } else if (leftVal instanceof INDArray && rightVal instanceof INDArray && (!((INDArray) leftVal).isVector() || !((INDArray) rightVal).isVector())) {
            return executeMatrix(frame);
        } else {
            return executeVector(frame);
        }
    }
}
