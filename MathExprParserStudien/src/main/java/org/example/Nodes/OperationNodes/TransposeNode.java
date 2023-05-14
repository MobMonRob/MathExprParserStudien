package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import org.example.Nodes.SingleNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public abstract class TransposeNode extends SingleNode {

    @Specialization(guards = "isINDArray(node)")
    public INDArray exMaMaToMa(INDArray node) {
        if (node.isVector()) {
            node = node.reshape(1, node.length());
        }
        return node.transpose();
    }
}
