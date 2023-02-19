// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MathExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MathExprParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MathExprParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MathExprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixExpr(MathExprParser.InfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(MathExprParser.ParensExprContext ctx);
}