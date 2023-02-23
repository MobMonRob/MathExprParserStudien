package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Dummy.DummyVector;
import org.example.Dummy.Dummymatrix;
import org.example.Nodes.MathExprNode;

public class PotentiateNode extends MathExprNode {
    @Child
    private MathExprNode leftNode, rightNode;

    public PotentiateNode(MathExprNode leftNode, MathExprNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        return 0;
    }

    @Override
    public DummyVector executeDummyVector(VirtualFrame frame) throws UnexpectedResultException {
        return null;
    }

    @Override
    public Dummymatrix executeDummyMatrix(VirtualFrame frame) {
        return null;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return null;
    }
}
