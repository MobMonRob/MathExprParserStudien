package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class MultNode extends MathExprNode {
    @Child
    private MathExprNode leftNode, rightNode;

    public MultNode(MathExprNode leftNode, MathExprNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        double leftVal = this.leftNode.executeDouble(frame);
        double rightVal = this.rightNode.executeDouble(frame);
        return leftVal * rightVal;
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        INDArray leftVal = this.leftNode.executeVector(frame);
        try {
            INDArray rightVal = this.rightNode.executeMatrix(frame);
            return leftVal.mul(rightVal);
        } catch (UnexpectedResultException e){}
        double rightVal = this.rightNode.executeDouble(frame);
        return leftVal.mul(rightVal);
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        INDArray leftVal = this.leftNode.executeMatrix(frame);
        try {
            INDArray rightVal = this.rightNode.executeMatrix(frame);
            return leftVal.mmul(rightVal);
        } catch (UnexpectedResultException e){}
        double rightVal = this.rightNode.executeDouble(frame);
        return leftVal.mul(rightVal);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        try {
            return executeDouble(frame);
        } catch (UnexpectedResultException e){}
        try {
            return executeVector(frame);
        } catch (UnexpectedResultException e){
            return executeMatrix(frame);
        }
    }
}
