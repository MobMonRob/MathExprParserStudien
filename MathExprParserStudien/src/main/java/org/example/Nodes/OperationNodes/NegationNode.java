package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class NegationNode extends MathExprNode {
    @Child
    private MathExprNode childNode;

    public NegationNode(MathExprNode childNode) {
        this.childNode = childNode;
    }

    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        return -childNode.executeDouble(frame);
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        return childNode.executeVector(frame).neg();
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        return childNode.executeMatrix(frame).neg();
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
