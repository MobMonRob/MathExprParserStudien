package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class TransposeNode extends MathExprNode {

    @Child
    private final MathExprNode childNode;

    public TransposeNode(MathExprNode childNode) {
        this.childNode = childNode;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        throw new UnexpectedResultException(this);
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        INDArray matrix = this.childNode.executeMatrix(frame);

        matrix = matrix.transpose();
        if (!matrix.isVector()) {
            throw new UnexpectedResultException(this);
        }
        return matrix;
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        try {
            INDArray matrix = this.childNode.executeMatrix(frame);
            return matrix.transpose();
        } catch (UnexpectedResultException e) {
        }
        INDArray vector = this.childNode.executeVector(frame);
        INDArray matrix = vector.reshape(1, vector.length());
        return matrix.transpose();
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        try {
            return executeVector(frame);
        } catch (UnexpectedResultException e) {
        }
        return executeMatrix(frame);
    }
}
