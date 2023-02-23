package mep;

import org.example.Nodes.DataTypeNodes.DoubleLiteralNode;
import org.example.Nodes.OperationNodes.AddNode;
import org.example.Nodes.OperationNodes.SubstrNode;
import org.example.Nodes.MathExprNode;
import org.example.Nodes.MathExprRootNode;
import com.oracle.truffle.api.CallTarget;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class ExecuteNodesTest {
    @Test
    public void addIntegers(){
        MathExprNode exprNode = new AddNode(
                new DoubleLiteralNode(22),
                new DoubleLiteralNode(9)
        );
        var rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(31, result);
    }
    @Test
    public void substIntegers(){
        MathExprNode exprNode = new SubstrNode(
                new DoubleLiteralNode(22),
                new DoubleLiteralNode(9)
        );
        var rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(13, result);
    }
}
