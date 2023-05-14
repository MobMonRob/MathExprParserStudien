package org.example.Nodes;

import com.oracle.truffle.api.dsl.NodeChild;
import org.nd4j.linalg.api.ndarray.INDArray;

@NodeChild("leftNode")
@NodeChild("rightNode")
public abstract class BinaryNode extends MathExprNode {
    protected boolean areDoubles(double left, double right) {
        return true;
    }

    protected boolean isINDArrayAndDouble(INDArray left, double right) {
        return true;
    }

    protected boolean areINDArrays(INDArray left, INDArray right) {
        return true;
    }
}
