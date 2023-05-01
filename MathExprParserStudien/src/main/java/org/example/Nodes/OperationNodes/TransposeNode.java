package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class TransposeNode extends MathExprNode {

    @Child
    private MathExprNode valNode;

    public TransposeNode(MathExprNode valNode) {
        this.valNode = valNode;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        throw new UnexpectedResultException(this);
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        INDArray matrix = this.valNode.executeMatrix(frame);

        matrix = matrix.transpose();
        if (!matrix.isVector()) {
            throw new UnexpectedResultException(this);
        };
        return matrix;
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        Object val = this.valNode.executeGeneric(frame);

        if (val instanceof INDArray) {
            INDArray value = (INDArray) val;
            if (value.isVector()) {
                value = value.reshape(1, value.length());
            }
            return value.transpose();
        }

        throw new UnexpectedResultException(this);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeMatrix(frame);
    }
}
