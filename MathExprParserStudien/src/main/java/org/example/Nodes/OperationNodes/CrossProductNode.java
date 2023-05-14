package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import org.example.Nodes.BinaryNode;
import org.example.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public abstract class CrossProductNode extends BinaryNode {
    @Specialization
    public INDArray exMaMaToMa(INDArray left, INDArray right){
        if (left.length() != 3 || right.length() != 3) {
            System.err.println("Cross product is only defined for vectors of length 3");
        }

        left = left.reshape(1, 3);
        right = right.reshape(1, 3);

        return Transforms.cross(left, right);
    }
}
