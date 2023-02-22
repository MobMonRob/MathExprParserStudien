package mep;

import com.oracle.truffle.api.CallTarget;
import org.example.Nodes.MathExprRootNode;
import org.example.Parsing.MathExprTruffleParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParseAddTest {
    @Test
    public void SmallIntegersTest(){
        MathExprTruffleParser parser2 = new MathExprTruffleParser();
        var men = parser2.parse("1+2");
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(3 , result);
    }
}
