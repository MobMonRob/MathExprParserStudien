package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import org.example.Nodes.MathExprNode;
import org.example.Nodes.SingleNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public abstract class NegationNode extends SingleNode {

    @Specialization
    public double exScScToSc(double node){
        return -node;
    }

    @Specialization
    public INDArray exMaMaToMa(INDArray node){
        return node.neg();
    }
}
