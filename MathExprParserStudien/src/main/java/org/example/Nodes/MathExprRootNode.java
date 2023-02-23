package org.example.Nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public final class MathExprRootNode extends RootNode {
    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private MathExprNode exprNode;

    public MathExprRootNode(MathExprNode exprNode){
        super(null);
        this.exprNode = exprNode;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return this.exprNode.executeGeneric(frame);
    }
}
