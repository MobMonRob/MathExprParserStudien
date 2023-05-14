package org.example.Nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import org.nd4j.linalg.api.ndarray.INDArray;

@NodeChild("node")
public abstract class SingleNode extends MathExprNode {
    protected boolean isDouble(double node) {
        return true;
    }

    protected boolean isINDArray(INDArray node) {
        return true;
    }
}
