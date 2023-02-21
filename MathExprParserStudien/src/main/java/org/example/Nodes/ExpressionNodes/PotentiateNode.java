package org.example.Nodes.ExpressionNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import org.example.Nodes.MathExprNode;

public class PotentiateNode extends MathExprNode {
    @Child
    private MathExprNode leftNode, rightNode;

    public PotentiateNode(MathExprNode leftNode, MathExprNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public int executeInt(VirtualFrame frame) {
        int leftVal = this.leftNode.executeInt(frame);
        int rightVal = this.rightNode.executeInt(frame);
        return (int) Math.pow(leftVal, rightVal);
    }
}
