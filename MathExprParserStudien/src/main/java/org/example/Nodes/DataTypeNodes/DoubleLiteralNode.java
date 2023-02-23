package org.example.Nodes.DataTypeNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Dummy.DummyVector;
import org.example.Dummy.Dummymatrix;
import org.example.Nodes.MathExprNode;

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
    public DummyVector executeDummyVector(VirtualFrame frame) {
        return new DummyVector(value);
    }

    @Override
    public Dummymatrix executeDummyMatrix(VirtualFrame frame) {
        return new Dummymatrix(value);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return executeDouble(frame);
    }

}
