package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import org.example.Nodes.BinaryNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public abstract class CrossProductNode extends BinaryNode {
    @Specialization(guards = "isCrossProduct(left, right)")
    public INDArray exMaMaToMa(INDArray left, INDArray right) {
        left = left.reshape(1, 3);
        right = right.reshape(1, 3);

        return Transforms.cross(left, right);
    }

    protected boolean isCrossProduct(INDArray left, INDArray right) {
        return left.isVector() && right.isVector() && left.length() != 3 && right.length() != 3;
    }
}
