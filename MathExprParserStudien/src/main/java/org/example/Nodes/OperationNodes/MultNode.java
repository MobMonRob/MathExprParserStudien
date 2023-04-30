package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class MultNode extends MathExprNode {
    @Child
    private MathExprNode leftNode;
    @Child
    private MathExprNode rightNode;

    public MultNode(MathExprNode leftNode, MathExprNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        double leftVal = this.leftNode.executeDouble(frame);
        double rightVal = this.rightNode.executeDouble(frame);
        return leftVal * rightVal;
    }

    public double executeScalarProduct(VirtualFrame frame) throws UnexpectedResultException {
        INDArray leftVal = this.leftNode.executeVector(frame);
        INDArray rightVal = this.rightNode.executeVector(frame);
        if (leftVal.length() != rightVal.length()) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new UnexpectedResultException("Error during execution of scalar product. Vectors have different length");
        }
        double scalar = Nd4j.getBlasWrapper().dot(leftVal, rightVal);
        return scalar;
    }

    public INDArray executeVector(VirtualFrame frame) throws UnexpectedResultException {
        Object leftResult = leftNode.executeGeneric(frame);
        Object rightResult = rightNode.executeGeneric(frame);

        if (leftResult instanceof INDArray && rightResult instanceof Double) {
            INDArray leftVal = (INDArray) leftResult;
            Double rightVal = (Double) rightResult;
            return leftVal.mul(rightVal);
        }else if(leftResult instanceof Double && rightResult instanceof INDArray){
            Double leftVal = (Double) leftResult;
            INDArray rightVal = (INDArray) rightResult;
            return rightVal.mul(leftVal);
        }

        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new UnexpectedResultException("Error during execution of vector multiplication");
    }

    @Override
    public INDArray executeMatrix(VirtualFrame frame) throws UnexpectedResultException {
        Object leftResult = leftNode.executeGeneric(frame);
        Object rightResult = rightNode.executeGeneric(frame);

        boolean leftIsINDArray = leftResult instanceof INDArray;
        boolean rightIsINDArray = rightResult instanceof INDArray;

        if (CompilerDirectives.injectBranchProbability(CompilerDirectives.LIKELY_PROBABILITY,
                leftIsINDArray && rightIsINDArray)) {
            INDArray leftVal = (INDArray) leftResult;
            INDArray rightVal = (INDArray) rightResult;
            return leftVal.mmul(rightVal);
        } else if (leftIsINDArray) {
            INDArray leftVal = (INDArray) leftResult;
            double rightVal = rightNode.executeDouble(frame);
            return leftVal.mul(rightVal);
        } else if (rightIsINDArray) {
            double leftVal = leftNode.executeDouble(frame);
            INDArray rightVal = (INDArray) rightResult;
            return rightVal.mul(leftVal);
        }

        CompilerDirectives.transferToInterpreterAndInvalidate();
        throw new IllegalStateException("Error during execution of matrix multiplication");
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object leftValue = leftNode.executeGeneric(frame);
        Object rightValue = rightNode.executeGeneric(frame);

        if (leftValue instanceof Double && rightValue instanceof Double) {
            return executeDouble(frame);
        }
        else if (leftValue instanceof INDArray && rightValue instanceof INDArray) {
            if (((INDArray) leftValue).isVector() && ((INDArray) rightValue).isVector()) {
                return executeScalarProduct(frame);
            }
        }
        return executeMatrix(frame);
    }
}
