package mep;

import com.oracle.truffle.api.CallTarget;
import org.example.Nodes.MathExprRootNode;
import org.example.Parsing.MathExprTruffleParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParseDoubleTest {
    @Test
    public void addTest(){
        var result = Testevaluation.evaluateStringtoDouble("1+7+2");
        assertEquals(10.0 , result,0);
    }

    @Test
    public void substTest(){
        var result = Testevaluation.evaluateStringtoDouble("1-7-2");
        assertEquals(-8.0 , result,0);
    }

    @Test
    public void divideTest(){
        var result = Testevaluation.evaluateStringtoDouble("55/11");
        assertEquals(5.0 , result,0);
    }

    @Test
    public void multiplyTest(){
        var result = Testevaluation.evaluateStringtoDouble("2*11*7");
        assertEquals(154.0 , result,0);
    }

    @Test
    public void potentiateTest(){
        var result = Testevaluation.evaluateStringtoDouble("2^10");
        assertEquals(1024.0 , result,0);
    }

    @Test
    public void preferenceTest(){
        var result = Testevaluation.evaluateStringtoDouble("2+8*8-2^5");
        assertEquals(34.0 , result,0);
    }

    @Test
    public void parenthesisTest(){
        var result = Testevaluation.evaluateStringtoDouble("(2+8)*(8+3)");
        assertEquals(110.0 , result,0);
    }

    @Test
    public void negationTest(){
        var result = Testevaluation.evaluateStringtoDouble("-(2*20.4)");
        assertEquals(-40.8 , result, 0);
    }
    @Test
    public void sinusTest(){
        var result = Testevaluation.evaluateStringtoDouble("sin(3)");
        assertEquals(0.14112000806 , (Double) result, 0.001);
    }

    @Test
    public void cosinusTest(){
        var result = Testevaluation.evaluateStringtoDouble("cos(3)");
        assertEquals(-0.9899924966 , (Double) result, 0.001);
    }
}
