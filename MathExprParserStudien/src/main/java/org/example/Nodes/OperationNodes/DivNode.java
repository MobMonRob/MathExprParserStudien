package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import org.example.Nodes.BinaryNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public abstract class DivNode extends BinaryNode {

    @Specialization
    public double exScScToSc(double left, double right){
        return left / right;
    }

    @Specialization
    public INDArray exMaMaToMa(INDArray left, INDArray right){
        return left.div(right);
    }

    @Specialization
    public INDArray exMaScToMa(INDArray left, double right){
        return left.div(right);
    }

    @Specialization
    public INDArray exScMaToMa(double left, INDArray right){
        return null;
    }
}
