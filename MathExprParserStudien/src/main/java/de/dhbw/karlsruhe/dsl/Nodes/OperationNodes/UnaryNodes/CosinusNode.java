package de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.UnaryNodes;

import com.oracle.truffle.api.dsl.Specialization;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.UnaryNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public abstract class CosinusNode extends UnaryNode {

    @Specialization(guards = "isINDArray(node)")
    public INDArray exCos(INDArray node) {
        return Transforms.cos(node);
    }

    @Specialization(guards = "isDouble(node)")
    public double exCos(double node) {
        return Math.cos(node);
    }
}
