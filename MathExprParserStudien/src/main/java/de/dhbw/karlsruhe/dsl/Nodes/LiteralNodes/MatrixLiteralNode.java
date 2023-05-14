package de.dhbw.karlsruhe.dsl.Nodes.LiteralNodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import de.dhbw.karlsruhe.dsl.Nodes.MathExprNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public final class MatrixLiteralNode extends MathExprNode {
    private final INDArray value;

    public MatrixLiteralNode(INDArray value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return this.value;
    }
}
