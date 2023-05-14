package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import org.example.Nodes.MathExprNode;
import org.example.Nodes.SingleNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public abstract class SinusNode extends SingleNode {

    @Specialization
    public double exScScToSc(double node){
        return Math.sin(node);
    }

    @Specialization
    public INDArray exMaMaToMa(INDArray node){
        return Transforms.sin(node);
    }
}
