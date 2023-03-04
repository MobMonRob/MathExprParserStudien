package org.example.Parsing.Gen;// Generated from java-escape by ANTLR 4.11.1
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
	 * Enter a parse tree produced by the {@code FunctionExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpr(MathExprParser.FunctionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpr(MathExprParser.FunctionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExponentExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExponentExpr(MathExprParser.ExponentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExponentExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExponentExpr(MathExprParser.ExponentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(MathExprParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(MathExprParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(MathExprParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(MathExprParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMatrixExpr(MathExprParser.MatrixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMatrixExpr(MathExprParser.MatrixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(MathExprParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(MathExprParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(MathExprParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(MathExprParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VectorExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVectorExpr(MathExprParser.VectorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VectorExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVectorExpr(MathExprParser.VectorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TransExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTransExpr(MathExprParser.TransExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TransExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTransExpr(MathExprParser.TransExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegationExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegationExpr(MathExprParser.NegationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegationExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegationExpr(MathExprParser.NegationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleLiteral}
	 * labeled alternative in {@link MathExprParser#double}.
	 * @param ctx the parse tree
	 */
	void enterDoubleLiteral(MathExprParser.DoubleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleLiteral}
	 * labeled alternative in {@link MathExprParser#double}.
	 * @param ctx the parse tree
	 */
	void exitDoubleLiteral(MathExprParser.DoubleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VectorLiteral}
	 * labeled alternative in {@link MathExprParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVectorLiteral(MathExprParser.VectorLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VectorLiteral}
	 * labeled alternative in {@link MathExprParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVectorLiteral(MathExprParser.VectorLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathExprParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(MathExprParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathExprParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(MathExprParser.MatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MathExprParser#transposedVector}.
	 * @param ctx the parse tree
	 */
	void enterTransposedVector(MathExprParser.TransposedVectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathExprParser#transposedVector}.
	 * @param ctx the parse tree
	 */
	void exitTransposedVector(MathExprParser.TransposedVectorContext ctx);
}