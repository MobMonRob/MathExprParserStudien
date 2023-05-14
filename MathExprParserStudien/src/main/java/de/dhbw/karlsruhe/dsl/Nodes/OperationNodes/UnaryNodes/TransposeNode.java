package de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.UnaryNodes;

import com.oracle.truffle.api.dsl.Specialization;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.UnaryNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public abstract class TransposeNode extends UnaryNode {

    @Specialization(guards = "isINDArray(node)")
    public INDArray exMaMaToMa(INDArray node) {
        if (node.isVector()) {
            node = node.reshape(1, node.length());
        }
        return node.transpose();
    }
}
