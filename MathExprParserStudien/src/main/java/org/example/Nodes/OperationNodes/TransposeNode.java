package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public class TransposeNode extends MathExprNode {

    @Child
    private MathExprNode childNode;

    public TransposeNode(MathExprNode childNode) {
        this.childNode = childNode;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        throw new UnexpectedResultException(this);
    }

    @Override
    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        INDArray child = this.childNode.executeMatrix(frame);
        var shit = child.transpose();
        if (shit.isColumnVector()) {
            return child.transpose();
        }
        throw new UnexpectedResultException(frame);
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        try {
            INDArray childVal = this.childNode.executeMatrix(frame);
            return childVal.transpose();
        } catch (UnexpectedResultException e){}
        INDArray childVal = this.childNode.executeVector(frame);
        return childVal.transpose();
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
