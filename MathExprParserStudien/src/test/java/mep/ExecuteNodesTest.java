package mep;

import org.example.Nodes.DataTypeNodes.DoubleLiteralNode;
import org.example.Nodes.OperationNodes.*;
import org.example.Nodes.MathExprNode;
import org.example.Nodes.MathExprRootNode;
import com.oracle.truffle.api.CallTarget;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class ExecuteNodesTest {
    @Test
    public void addNodeDouble(){
        MathExprNode exprNode = new AddNode(
                new DoubleLiteralNode(22),
                new DoubleLiteralNode(9)
        );
        var rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(31.0, result);
    }
    @Test
    public void substrNodeDouble(){
        MathExprNode exprNode = new SubstrNode(
                new DoubleLiteralNode(22),
                new DoubleLiteralNode(9)
        );
        var rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(13.0, result);
    }

    @Test
    public void divNodeDouble(){
        MathExprNode exprNode = new DivNode(
                new DoubleLiteralNode(22),
                new DoubleLiteralNode(11)
        );
        var rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(2.0, result);
    }

    @Test
    public void multNodeDouble(){
        MathExprNode exprNode = new MultNode(
                new DoubleLiteralNode(22),
                new DoubleLiteralNode(5)
        );
        var rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(110.0, result);
    }

    @Test
    public void potentiateNodeDouble(){
        MathExprNode exprNode = new PotentiateNode(
                new DoubleLiteralNode(4),
                new DoubleLiteralNode(4)
        );
        var rootNode = new MathExprRootNode(exprNode);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(256.0, result);
    }
}
