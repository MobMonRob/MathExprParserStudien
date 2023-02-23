package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Dummy.DummyVector;
import org.example.Dummy.Dummymatrix;
import org.example.Nodes.MathExprNode;

public class AddNode extends MathExprNode {
    @Child
    private MathExprNode leftNode, rightNode;

    public AddNode(MathExprNode left, MathExprNode right) {
        this.leftNode = left;
        this.rightNode = right;
    }

    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        double leftVal = this.leftNode.executeDouble(frame);
        double rightVal = this.rightNode.executeDouble(frame);
        return leftVal + rightVal;
    }

    @Override
    public DummyVector executeDummyVector(VirtualFrame frame) {
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
