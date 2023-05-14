package de.dhbw.karlsruhe.dsl.Nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;

public abstract class MathExprNode extends Node {
    public abstract Object executeGeneric(VirtualFrame frame);
}
