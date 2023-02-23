package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Dummy.DummyVector;
import org.example.Dummy.Dummymatrix;
import org.example.Nodes.DataTypeNodes.DoubleLiteralNode;
import org.example.Nodes.MathExprNode;

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
    public DummyVector executeDummyVector(VirtualFrame frame) throws UnexpectedResultException {
        return null;
    }

    @Override
    public Dummymatrix executeDummyMatrix(VirtualFrame frame) {
        return null;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeDouble(frame);
    }
}
