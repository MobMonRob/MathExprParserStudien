package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import org.example.Nodes.BinaryNode;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;


public abstract class PotentiateNode extends BinaryNode {

    @Specialization
    public double exScScToSc(double left, double right){
        return Math.pow(left, right);
    }

    @Specialization
    public INDArray exMaScToMa(INDArray left, double right){
        return Transforms.pow(left, right);
    }

    public abstract Object execute(Object left, Object right);
}
