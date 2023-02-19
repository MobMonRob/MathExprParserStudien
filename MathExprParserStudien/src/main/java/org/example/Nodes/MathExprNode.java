package org.example.Nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;

public abstract class MathExprNode extends Node{
    public abstract int executeInt(VirtualFrame frame);
}
