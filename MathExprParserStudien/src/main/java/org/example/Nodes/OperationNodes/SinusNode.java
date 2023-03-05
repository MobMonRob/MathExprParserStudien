package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class SinusNode extends MathExprNode {
    @Child
    private MathExprNode childNode;

    public SinusNode(MathExprNode childNode) {
        this.childNode = childNode;
    }

    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        double childVal = this.childNode.executeDouble(frame);
        return Math.sin(childVal); //TODO on graphics card?
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