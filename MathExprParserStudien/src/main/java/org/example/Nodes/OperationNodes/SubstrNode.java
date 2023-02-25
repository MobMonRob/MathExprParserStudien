package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class SubstrNode extends MathExprNode {
    private MathExprNode leftNode, rightNode;
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
        return null;
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) {
        return null;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeDouble(frame);
    }
}
