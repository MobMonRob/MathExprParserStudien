package de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.UnaryNodes;

import com.oracle.truffle.api.dsl.Specialization;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.UnaryNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public abstract class NegationNode extends UnaryNode {

    @Specialization(guards = "isDouble(node)")
    public double exScScToSc(double node) {
        return -node;
    }

    @Specialization(guards = "isINDArray(node)")
    public INDArray exMaMaToMa(INDArray node) {
        return node.neg();
    }
}
