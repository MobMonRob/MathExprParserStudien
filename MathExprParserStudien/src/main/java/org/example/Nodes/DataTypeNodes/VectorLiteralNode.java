package org.example.Nodes.DataTypeNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Dummy.DummyVector;
import org.example.Dummy.Dummymatrix;
import org.example.Nodes.MathExprNode;

public class VectorLiteralNode extends MathExprNode {
    private final DummyVector value;

    public VectorLiteralNode(DummyVector value) {
        this.value = value;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        throw new UnexpectedResultException(this.value);
    }

    @Override
    public DummyVector executeDummyVector(VirtualFrame frame) {
        return this.value;
    }

    @Override
    public Dummymatrix executeDummyMatrix(VirtualFrame frame) {
        return new Dummymatrix(this.value);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return this.executeDummyVector(frame);
    }
}
