package de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.UnaryNodes;

import com.oracle.truffle.api.dsl.Specialization;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.UnaryNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public abstract class SinusNode extends UnaryNode {

    @Specialization(guards = "isDouble(node)")
    public double exScScToSc(double node) {
        return Math.sin(node);
    }

    @Specialization(guards = "isINDArray(node)")
    public INDArray exMaMaToMa(INDArray node) {
        return Transforms.sin(node);
    }
}
