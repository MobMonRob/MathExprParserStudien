package mep;

import com.oracle.truffle.api.CallTarget;
import org.example.Nodes.MathExprRootNode;
import org.example.Parsing.MathExprTruffleParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParseDoubleTest {
    @Test
    public void addTest(){
        MathExprTruffleParser parser2 = new MathExprTruffleParser();
        var men = parser2.parse("1+7+2");

        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(10.0 , result);
    }

    @Test
    public void substTest(){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse("1-7-2");
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(-8.0 , result);
    }

    @Test
    public void divideTest(){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse("55/11");
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(5.0 , result);
    }

    @Test
    public void multiplyTest(){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse("2*11*7");
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(154.0 , result);
    }

    @Test
    public void potentiateTest(){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse("2^10");
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(1024.0 , result);
    }

    @Test
    public void preferenceTest(){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse("2+8*8-2^5");
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(34.0 , result);
    }

    @Test
    public void parenthesisTest(){
        MathExprTruffleParser parser = new MathExprTruffleParser();
        var men = parser.parse("(2+8)*(8+3)");
        var rootNode = new MathExprRootNode(men);
        CallTarget callTarget = rootNode.getCallTarget();

        var result = callTarget.call();

        assertEquals(110.0 , result);
    }
}
