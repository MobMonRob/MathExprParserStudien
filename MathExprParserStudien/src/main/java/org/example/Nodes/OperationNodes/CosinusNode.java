package org.example.Nodes.OperationNodes;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import org.example.Nodes.MathExprNode;
import org.example.Nodes.SingleNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public abstract class CosinusNode extends SingleNode {

    @Specialization
    public INDArray exCos(INDArray node){
        return Transforms.cos(node);
    }

    @Specialization
    public double exCos(double node){
        return Math.cos(node);
    }
}
