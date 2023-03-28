package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public class CosinusNode extends MathExprNode {
    @Child
    private final MathExprNode childNode;

    public CosinusNode(MathExprNode childNode) {
        this.childNode = childNode;
    }

    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        double childVal = this.childNode.executeDouble(frame);
        return Math.cos(childVal); //TODO on graphics card?
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        INDArray child = this.childNode.executeVector(frame);
        return Transforms.cos(child);
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        INDArray child = this.childNode.executeMatrix(frame);
        return Transforms.cos(child);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        try {
            return executeDouble(frame);
        } catch (UnexpectedResultException e) {
        }
        try {
            return executeVector(frame);
        } catch (UnexpectedResultException e) {
            return executeMatrix(frame);
        }
    }
}
