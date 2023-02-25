package org.example.Nodes.DataTypeNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class DoubleLiteralNode extends MathExprNode {

    private final double value;

    public DoubleLiteralNode(double value) {
        this.value = value;
    }

    @Override
    public double executeDouble(VirtualFrame frame) {
        return this.value;
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        throw new UnexpectedResultException(value);
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        throw new UnexpectedResultException(value);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return executeDouble(frame);
    }

}
