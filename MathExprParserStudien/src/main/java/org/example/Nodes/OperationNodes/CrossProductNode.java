package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public class CrossProductNode extends MathExprNode {
    @Child
    private final MathExprNode leftNode;
    @Child
    private final MathExprNode rightNode;

    public CrossProductNode(MathExprNode leftNode, MathExprNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        throw new UnexpectedResultException(this);
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        INDArray leftVal = this.leftNode.executeVector(frame);
        INDArray rightVal = this.rightNode.executeVector(frame);

        if (leftVal.length() != 3 || rightVal.length() != 3) {
            throw new UnexpectedResultException(this);
        }

        leftVal = leftVal.reshape(1, 3);
        rightVal = rightVal.reshape(1, 3);

        return Transforms.cross(leftVal, rightVal);
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        throw new UnexpectedResultException(this);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeVector(frame);
    }
}
