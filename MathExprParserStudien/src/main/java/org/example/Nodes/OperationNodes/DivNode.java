package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class DivNode extends MathExprNode {
    @Child
    private MathExprNode leftNode;
    @Child
    private MathExprNode rightNode;

    public DivNode(MathExprNode leftNode, MathExprNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        double leftVal = this.leftNode.executeDouble(frame);
        double rightVal = this.rightNode.executeDouble(frame);
        return leftVal / rightVal;
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        INDArray leftVal = this.leftNode.executeVector(frame);
        double rightVal = this.rightNode.executeDouble(frame);
        return leftVal.div(rightVal);
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        INDArray leftVal = this.leftNode.executeMatrix(frame);
        double rightVal = this.rightNode.executeDouble(frame);
        return leftVal.div(rightVal);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object leftVal = this.leftNode.executeGeneric(frame);
        Object rightVal = this.rightNode.executeGeneric(frame);

        if (leftVal instanceof Double && rightVal instanceof Double) {
            return executeDouble(frame);
        }else if (leftVal instanceof INDArray && rightVal instanceof Double) {
            INDArray left = (INDArray) leftVal;
            if (left.isVector()) {
                return executeVector(frame);
            } else {
                return executeMatrix(frame);
            }
        }
        throw new UnexpectedResultException("Error in DivNode");
    }
}
