package de.dhbw.karlsruhe.dsl.Parsing.Gen;// Generated from java-escape by ANTLR 4.11.1
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
	 * Visit a parse tree produced by the {@code FunctionExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpr(MathExprParser.FunctionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExponentExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentExpr(MathExprParser.ExponentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(MathExprParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(MathExprParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MatrixExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixExpr(MathExprParser.MatrixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(MathExprParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(MathExprParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VectorExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorExpr(MathExprParser.VectorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TransExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransExpr(MathExprParser.TransExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegationExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationExpr(MathExprParser.NegationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleLiteral}
	 * labeled alternative in {@link MathExprParser#double}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleLiteral(MathExprParser.DoubleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VectorLiteral}
	 * labeled alternative in {@link MathExprParser#vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorLiteral(MathExprParser.VectorLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathExprParser#matrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrix(MathExprParser.MatrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MathExprParser#transposedVector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransposedVector(MathExprParser.TransposedVectorContext ctx);
}