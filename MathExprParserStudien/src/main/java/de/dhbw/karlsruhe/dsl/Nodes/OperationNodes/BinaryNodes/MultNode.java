package de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.BinaryNodes;

import com.oracle.truffle.api.dsl.Specialization;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.BinaryNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public abstract class MultNode extends BinaryNode {

    @Specialization
    public double exScScToSc(double left, double right) {
        return left * right;
    }

    @Specialization(guards = "isScalarProduct(left, right)")
    public double exMaMaToSc(INDArray left, INDArray right) {
        //TODO: is not executed
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
        //TODO: check for vector
        return left.length() == right.length() && left.length() == 3;
    }

    protected boolean isNotScalarProduct(INDArray left, INDArray right) {
        return !isScalarProduct(left, right);
    }
}
