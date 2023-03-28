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
        try {
            double leftVal = this.leftNode.executeDouble(frame);
            double rightVal = this.rightNode.executeDouble(frame);
            return leftVal * rightVal;
        } catch (UnexpectedResultException e){}
        // Execute scalar product
        INDArray leftVal = this.leftNode.executeVector(frame);
        INDArray rightVal = this.rightNode.executeVector(frame);
        if (leftVal.length() != rightVal.length()) {
            throw new UnexpectedResultException(this);
        }
        double scalar = Nd4j.getBlasWrapper().dot(leftVal, rightVal);
        return scalar;
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        try {
            INDArray leftVal = this.leftNode.executeVector(frame);
            INDArray rightVal = this.rightNode.executeVector(frame);
            return leftVal.mul(rightVal);
        } catch (UnexpectedResultException e){
        }
        try {
            INDArray leftVal = this.leftNode.executeVector(frame);
            Double rightVal = this.rightNode.executeDouble(frame);
            return leftVal.mul(rightVal);
        } catch (UnexpectedResultException e){
        }
        double leftVal = this.leftNode.executeDouble(frame);
        INDArray rightVal = this.rightNode.executeVector(frame);
        return rightVal.mul(leftVal);
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        try {
            INDArray leftVal = this.leftNode.executeMatrix(frame);
            INDArray rightVal = this.rightNode.executeMatrix(frame);
            return leftVal.mmul(rightVal);
        } catch (UnexpectedResultException e){}
        try {
            INDArray leftVal = this.leftNode.executeMatrix(frame);
            Double rightVal = this.rightNode.executeDouble(frame);
            return leftVal.mul(rightVal);
        } catch (UnexpectedResultException e){}
        double leftVal = this.leftNode.executeDouble(frame);
        INDArray rightVal = this.rightNode.executeMatrix(frame);
        return rightVal.mul(leftVal);
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
