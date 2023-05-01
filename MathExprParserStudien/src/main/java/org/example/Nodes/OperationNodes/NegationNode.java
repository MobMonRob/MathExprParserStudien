package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class NegationNode extends MathExprNode {
    @Child
    private MathExprNode valNode;

    public NegationNode(MathExprNode valNode) {
        this.valNode = valNode;
    }

    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        return -valNode.executeDouble(frame);
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        return valNode.executeVector(frame).neg();
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        return valNode.executeMatrix(frame).neg();
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object value = valNode.executeGeneric(frame);

        if (value instanceof Double) {
            return executeDouble(frame);
        } else if (value instanceof INDArray) {
            INDArray val = (INDArray) value;
            if (val.isVector()) {
                return executeVector(frame);
            }
            return executeMatrix(frame);
        }

        throw new UnexpectedResultException("Error in NegationNode");
    }
}
