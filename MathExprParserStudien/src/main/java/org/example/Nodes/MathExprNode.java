package org.example.Nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.nd4j.linalg.api.ndarray.INDArray;


public abstract class MathExprNode extends Node{

    public abstract double executeDouble(VirtualFrame frame) throws UnexpectedResultException;

    public abstract INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException;

    public abstract INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException;

    public abstract Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException;

}
