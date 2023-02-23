package org.example.Nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Dummy.DummyVector;
import org.example.Dummy.Dummymatrix;


public abstract class MathExprNode extends Node{

    public abstract double executeDouble(VirtualFrame frame) throws UnexpectedResultException;

    public abstract DummyVector executeDummyVector(VirtualFrame frame) throws UnexpectedResultException;

    public abstract Dummymatrix executeDummyMatrix(VirtualFrame frame);

    public abstract Object executeGeneric(VirtualFrame frame);
}
