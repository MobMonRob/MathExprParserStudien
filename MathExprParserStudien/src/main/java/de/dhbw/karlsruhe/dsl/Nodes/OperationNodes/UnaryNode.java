package de.dhbw.karlsruhe.dsl.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.NodeChild;
import de.dhbw.karlsruhe.dsl.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

@NodeChild("node")
public abstract class UnaryNode extends MathExprNode {
    protected boolean isDouble(double node) {
        return true;
    }

    protected boolean isINDArray(INDArray node) {
        return true;
    }
}
