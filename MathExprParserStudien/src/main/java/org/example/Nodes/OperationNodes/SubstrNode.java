package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Dummy.DummyVector;
import org.example.Dummy.Dummymatrix;
import org.example.Nodes.DataTypeNodes.DoubleLiteralNode;
import org.example.Nodes.MathExprNode;
import com.oracle.truffle.api.dsl.NodeChild;

public class SubstrNode extends MathExprNode {

    public SubstrNode(DoubleLiteralNode left, DoubleLiteralNode right) {
        super();
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
