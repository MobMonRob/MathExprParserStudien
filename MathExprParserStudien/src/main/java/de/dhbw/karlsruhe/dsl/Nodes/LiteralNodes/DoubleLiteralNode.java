package de.dhbw.karlsruhe.dsl.Nodes.LiteralNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import de.dhbw.karlsruhe.dsl.Nodes.MathExprNode;

public final class DoubleLiteralNode extends MathExprNode {

    private final double value;

    public DoubleLiteralNode(double value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return this.value;
    }
}
