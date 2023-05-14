package de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.BinaryNodes;

import com.oracle.truffle.api.dsl.Specialization;
import de.dhbw.karlsruhe.dsl.Nodes.OperationNodes.BinaryNode;
import org.nd4j.linalg.api.ndarray.INDArray;

public abstract class SubstrNode extends BinaryNode {

    @Specialization(guards = "areDoubles(left, right)")
    public double exScScToSc(double left, double right) {
        return left - right;
    }

    @Specialization(guards = "areINDArrays(left, right)")
    public INDArray exMaMaToMa(INDArray left, INDArray right) {
        return left.sub(right);
    }

    @Specialization(guards = "isINDArrayAndDouble(left, right)")
    public INDArray exMaScToMa(INDArray left, double right) {
        return left.sub(right);
    }
}
