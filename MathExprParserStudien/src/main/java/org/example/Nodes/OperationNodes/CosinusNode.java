package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public class CosinusNode extends MathExprNode {
    @Child
    private MathExprNode valNode;

    public CosinusNode(MathExprNode valNode) {
        this.valNode = valNode;
    }

    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        double value = this.valNode.executeDouble(frame);
        return Math.cos(value);
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        INDArray value = this.valNode.executeVector(frame);
        return Transforms.cos(value);
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        INDArray value = this.valNode.executeMatrix(frame);
        return Transforms.cos(value);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object value = this.valNode.executeGeneric(frame);

        if (value instanceof Double) {
            return executeDouble(frame);
        }
        if (value instanceof INDArray) {
            INDArray val = (INDArray) value;
            if (val.isVector()) {
                return executeVector(frame);
            }
            return executeMatrix(frame);
        }

        throw new UnexpectedResultException("Error in CosinusNode");
    }
}
