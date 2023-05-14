package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.BinaryNode;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public abstract class MultNode extends BinaryNode {

    @Specialization
    public double exScScToSc(double left, double right) {
        return left * right;
    }

    /*
    @Specialization
    public double exMaMaToSc(INDArray left, INDArray right){
        if (left.length() != right.length()) {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            System.err.println("Error during execution of scalar product. Vectors have different length");
        }
        double scalar = Nd4j.getBlasWrapper().dot(left, right);
        return scalar;
    }
    */

    @Specialization
    public INDArray exMaMaToMa(INDArray left, INDArray right) {

        return left.mmul(right);
    }

    @Specialization
    public INDArray exMaScToMa(INDArray left, double right){
        return left.mul(right);
    }

    @Specialization
    public INDArray exScMaToMa(double left, INDArray right){
        return right.mul(left);
    }
}
