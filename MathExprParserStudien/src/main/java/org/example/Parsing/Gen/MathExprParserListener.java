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
	 * Enter a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivExpr(MathExprParser.DivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivExpr(MathExprParser.DivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CrossProductExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCrossProductExpr(MathExprParser.CrossProductExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CrossProductExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCrossProductExpr(MathExprParser.CrossProductExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DifExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDifExpr(MathExprParser.DifExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DifExpr}
	 * labeled alternative in {@link MathExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDifExpr(MathExprParser.DifExprContext ctx);
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
	 * Enter a parse tree produced by {@link MathExprParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(MathExprParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathExprParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(MathExprParser.VectorContext ctx);
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