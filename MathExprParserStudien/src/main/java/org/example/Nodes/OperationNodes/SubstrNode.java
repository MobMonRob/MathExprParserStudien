package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.BinaryNode;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public abstract class SubstrNode extends BinaryNode {

    @Specialization
    public double exScScToSc(double left, double right){
        return left - right;
    }


    @Specialization
    public INDArray exMaMaToMa(INDArray left, INDArray right){
        return left.sub(right);
    }


    @Specialization
    public INDArray exMaScToMa(INDArray left, double right) {
        return left.sub(right);
    }
}
