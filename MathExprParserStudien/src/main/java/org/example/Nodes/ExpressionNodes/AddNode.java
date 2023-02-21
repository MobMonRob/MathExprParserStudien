package org.example.Nodes.ExpressionNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.example.Nodes.MathExprNode;

public class AddNode extends MathExprNode {
    @Child
    private MathExprNode leftNode, rightNode;

    public AddNode(MathExprNode left, MathExprNode right) {
        this.leftNode = left;
        this.rightNode = right;
    }

    @Override
    public int executeInt(VirtualFrame frame) {
        int leftVal = this.leftNode.executeInt(frame);
        int rightVal = this.rightNode.executeInt(frame);
        return leftVal + rightVal;
    }
}
