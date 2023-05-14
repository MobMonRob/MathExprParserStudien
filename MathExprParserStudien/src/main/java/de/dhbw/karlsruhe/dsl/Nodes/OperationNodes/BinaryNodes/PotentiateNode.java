package de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.BinaryNodes;

import com.oracle.truffle.api.dsl.Specialization;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.BinaryNode;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;


public abstract class PotentiateNode extends BinaryNode {

    @Specialization(guards = "areDoubles(left, right)")
    public double exScScToSc(double left, double right) {
        return Math.pow(left, right);
    }

    @Specialization(guards = "isINDArrayAndDouble(left, right)")
    public INDArray exMaScToMa(INDArray left, double right) {
        return Transforms.pow(left, right);
    }
}
