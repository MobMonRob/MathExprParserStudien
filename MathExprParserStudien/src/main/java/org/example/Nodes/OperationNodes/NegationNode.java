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
    public INDArray executeVector(VirtualFrame frame) {
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
