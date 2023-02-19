package org.example.Nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class IntLiteralNode extends MathExprNode{
    private final int value;

    public IntLiteralNode(int value) {
        this.value = value;
    }

    @Override
    public int executeInt(VirtualFrame frame) {
        return this.value;
    }

    wichtigere changes;
}
