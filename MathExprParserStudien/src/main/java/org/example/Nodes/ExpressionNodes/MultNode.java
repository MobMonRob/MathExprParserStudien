package org.example.Nodes.ExpressionNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.example.Nodes.MathExprNode;

public class MultNode extends MathExprNode {
    @Child
    private MathExprNode leftNode, rightNode;

    public MultNode(MathExprNode leftNode, MathExprNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public int executeInt(VirtualFrame frame) {
        int leftVal = this.leftNode.executeInt(frame);
        int rightVal = this.rightNode.executeInt(frame);
        return leftVal * rightVal;
    }
}
