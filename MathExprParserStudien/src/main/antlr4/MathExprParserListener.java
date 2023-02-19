// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MathExprParser}.
 */
public interface MathExprParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MathExprParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MathExprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathExprParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MathExprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(MathExprParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(MathExprParser.InfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(MathExprParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(MathExprParser.ParensExprContext ctx);
}