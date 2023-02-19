package mep;

import org.example.Nodes.AddNode;
import org.example.Nodes.IntLiteralNode;
import org.example.Nodes.MathExprNode;
import org.example.Nodes.MathExprRootNode;
import com.oracle.truffle.api.CallTarget;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class ExecuteNodesTest {
    @Test
    public void addIntegers(){
        MathExprNode exprNode = new AddNode(
                new IntLiteralNode(22),
                new IntLiteralNode(9)
        );
        var rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();
        wichtige changes

        assertEquals(31, result);
    }
}
