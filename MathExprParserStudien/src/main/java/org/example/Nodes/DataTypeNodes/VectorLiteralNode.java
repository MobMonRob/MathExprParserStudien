package org.example.Nodes.DataTypeNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Dummy.DummyVector;
import org.example.Dummy.Dummymatrix;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class VectorLiteralNode extends MathExprNode {
    private final INDArray value;

    public VectorLiteralNode(INDArray value) {
        this.value = value;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        throw new UnexpectedResultException(this.value);
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) {
        return this.value;
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) {
        return this.value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return this.executeVector(frame);
    }
}
