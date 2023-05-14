package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import org.example.Nodes.SingleNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public abstract class CosinusNode extends SingleNode {

    @Specialization(guards = "isINDArray(node)")
    public INDArray exCos(INDArray node) {
        return Transforms.cos(node);
    }

    @Specialization(guards = "isDouble(node)")
    public double exCos(double node) {
        return Math.cos(node);
    }
}
