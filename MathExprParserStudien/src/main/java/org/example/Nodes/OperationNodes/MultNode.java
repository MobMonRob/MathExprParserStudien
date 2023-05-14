package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import org.example.Nodes.BinaryNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public abstract class MultNode extends BinaryNode {

    @Specialization
    public double exScScToSc(double left, double right) {
        return left * right;
    }

    @Specialization(guards = "isScalarProduct(left, right)")
    public double exMaMaToSc(INDArray left, INDArray right) {
        double scalar = Nd4j.getBlasWrapper().dot(left, right);
        return scalar;
    }

    @Specialization(guards = "isNotScalarProduct(left, right)")
    public INDArray exMaMaToMa(INDArray left, INDArray right) {
        return left.mmul(right);
    }

    @Specialization(guards = "isINDArrayAndDouble(left, right)")
    public INDArray exMaScToMa(INDArray left, double right) {
        return left.mul(right);
    }

    @Specialization(guards = "isINDArrayAndDouble(right, left)")
    public INDArray exScMaToMa(double left, INDArray right) {
        return right.mul(left);
    }

    protected boolean isScalarProduct(INDArray left, INDArray right) {
        return left.isVector() && right.isVector() && left.length() == right.length();
    }

    protected boolean isNotScalarProduct(INDArray left, INDArray right) {
        return !isScalarProduct(left, right);
    }
}
