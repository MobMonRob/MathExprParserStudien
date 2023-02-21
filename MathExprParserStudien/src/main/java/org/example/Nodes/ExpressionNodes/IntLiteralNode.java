package org.example.Nodes.ExpressionNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.example.Nodes.MathExprNode;

public class IntLiteralNode extends MathExprNode {
    private final int value;

    public IntLiteralNode(int value) {
        this.value = value;
    }

    @Override
    public int executeInt(VirtualFrame frame) {
        return this.value;
    }
}
