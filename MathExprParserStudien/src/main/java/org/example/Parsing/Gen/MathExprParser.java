package org.example.Parsing.Gen;// Generated from java-escape by ANTLR 4.11.1

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MathExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS_SIGN=1, HYPHEN_MINUS=2, ASTERISK=3, SOLIDUS=4, CROSS=5, CIRCUMFLEX_ACCENT=6, 
		SEMICOLON=7, LPARENT=8, RPARENT=9, LSQUAREBRACKET=10, RSQUAREBRACKET=11, 
		DOUBLE=12, FORMAT=13, ANY=14;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_vector = 2, RULE_matrix = 3, RULE_transposedVector = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "vector", "matrix", "transposedVector"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'x'", "'^'", "';'", "'('", "')'", 
			"'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS_SIGN", "HYPHEN_MINUS", "ASTERISK", "SOLIDUS", "CROSS", "CIRCUMFLEX_ACCENT", 
			"SEMICOLON", "LPARENT", "RPARENT", "LSQUAREBRACKET", "RSQUAREBRACKET", 
			"DOUBLE", "FORMAT", "ANY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MathExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MathExprParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			expr(0);
			setState(11);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SOLIDUS() { return getToken(MathExprParser.SOLIDUS, 0); }
		public DivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CrossProductExprContext extends ExprContext {
		public List<VectorContext> vector() {
			return getRuleContexts(VectorContext.class);
		}
		public VectorContext vector(int i) {
			return getRuleContext(VectorContext.class,i);
		}
		public TerminalNode CROSS() { return getToken(MathExprParser.CROSS, 0); }
		public CrossProductExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterCrossProductExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitCrossProductExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitCrossProductExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DifExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode HYPHEN_MINUS() { return getToken(MathExprParser.HYPHEN_MINUS, 0); }
		public DifExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterDifExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitDifExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitDifExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExponentExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CIRCUMFLEX_ACCENT() { return getToken(MathExprParser.CIRCUMFLEX_ACCENT, 0); }
		public ExponentExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterExponentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitExponentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitExponentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(MathExprParser.ASTERISK, 0); }
		public MultExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExprContext extends ExprContext {
		public TerminalNode DOUBLE() { return getToken(MathExprParser.DOUBLE, 0); }
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatrixExprContext extends ExprContext {
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public MatrixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterMatrixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitMatrixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitMatrixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS_SIGN() { return getToken(MathExprParser.PLUS_SIGN, 0); }
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPARENT() { return getToken(MathExprParser.LPARENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPARENT() { return getToken(MathExprParser.RPARENT, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorExprContext extends ExprContext {
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public VectorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterVectorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitVectorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitVectorExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(14);
				match(LPARENT);
				setState(15);
				expr(0);
				setState(16);
				match(RPARENT);
				}
				break;
			case 2:
				{
				_localctx = new CrossProductExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				vector();
				setState(19);
				match(CROSS);
				setState(20);
				vector();
				}
				break;
			case 3:
				{
				_localctx = new VectorExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				vector();
				}
				break;
			case 4:
				{
				_localctx = new MatrixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				matrix();
				}
				break;
			case 5:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(DOUBLE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(42);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExponentExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(27);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(28);
						match(CIRCUMFLEX_ACCENT);
						setState(29);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(30);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(31);
						match(ASTERISK);
						setState(32);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(33);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(34);
						match(SOLIDUS);
						setState(35);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(36);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(37);
						match(PLUS_SIGN);
						setState(38);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new DifExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(39);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(40);
						match(HYPHEN_MINUS);
						setState(41);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VectorContext extends ParserRuleContext {
		public TerminalNode LSQUAREBRACKET() { return getToken(MathExprParser.LSQUAREBRACKET, 0); }
		public TerminalNode RSQUAREBRACKET() { return getToken(MathExprParser.RSQUAREBRACKET, 0); }
		public List<TerminalNode> DOUBLE() { return getTokens(MathExprParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(MathExprParser.DOUBLE, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MathExprParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MathExprParser.SEMICOLON, i);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(LSQUAREBRACKET);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLE) {
				{
				{
				setState(48);
				match(DOUBLE);
				setState(49);
				match(SEMICOLON);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(RSQUAREBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatrixContext extends ParserRuleContext {
		public TerminalNode LSQUAREBRACKET() { return getToken(MathExprParser.LSQUAREBRACKET, 0); }
		public TerminalNode RSQUAREBRACKET() { return getToken(MathExprParser.RSQUAREBRACKET, 0); }
		public List<TransposedVectorContext> transposedVector() {
			return getRuleContexts(TransposedVectorContext.class);
		}
		public TransposedVectorContext transposedVector(int i) {
			return getRuleContext(TransposedVectorContext.class,i);
		}
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(LSQUAREBRACKET);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLE) {
				{
				{
				setState(58);
				transposedVector();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(RSQUAREBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TransposedVectorContext extends ParserRuleContext {
		public List<TerminalNode> DOUBLE() { return getTokens(MathExprParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(MathExprParser.DOUBLE, i);
		}
		public TerminalNode SEMICOLON() { return getToken(MathExprParser.SEMICOLON, 0); }
		public TransposedVectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transposedVector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterTransposedVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitTransposedVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitTransposedVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransposedVectorContext transposedVector() throws RecognitionException {
		TransposedVectorContext _localctx = new TransposedVectorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_transposedVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(66);
			match(DOUBLE);
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				match(DOUBLE);
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOUBLE );
			setState(72);
			match(SEMICOLON);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000eK\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001a\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001+\b\u0001\n\u0001\f\u0001.\t\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u00023\b\u0002\n\u0002\f\u00026\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003<\b"+
		"\u0003\n\u0003\f\u0003?\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0004\u0004E\b\u0004\u000b\u0004\f\u0004F\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0000\u0001\u0002\u0005\u0000\u0002\u0004\u0006\b\u0000\u0000"+
		"Q\u0000\n\u0001\u0000\u0000\u0000\u0002\u0019\u0001\u0000\u0000\u0000"+
		"\u0004/\u0001\u0000\u0000\u0000\u00069\u0001\u0000\u0000\u0000\bB\u0001"+
		"\u0000\u0000\u0000\n\u000b\u0003\u0002\u0001\u0000\u000b\f\u0005\u0000"+
		"\u0000\u0001\f\u0001\u0001\u0000\u0000\u0000\r\u000e\u0006\u0001\uffff"+
		"\uffff\u0000\u000e\u000f\u0005\b\u0000\u0000\u000f\u0010\u0003\u0002\u0001"+
		"\u0000\u0010\u0011\u0005\t\u0000\u0000\u0011\u001a\u0001\u0000\u0000\u0000"+
		"\u0012\u0013\u0003\u0004\u0002\u0000\u0013\u0014\u0005\u0005\u0000\u0000"+
		"\u0014\u0015\u0003\u0004\u0002\u0000\u0015\u001a\u0001\u0000\u0000\u0000"+
		"\u0016\u001a\u0003\u0004\u0002\u0000\u0017\u001a\u0003\u0006\u0003\u0000"+
		"\u0018\u001a\u0005\f\u0000\u0000\u0019\r\u0001\u0000\u0000\u0000\u0019"+
		"\u0012\u0001\u0000\u0000\u0000\u0019\u0016\u0001\u0000\u0000\u0000\u0019"+
		"\u0017\u0001\u0000\u0000\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a"+
		",\u0001\u0000\u0000\u0000\u001b\u001c\n\t\u0000\u0000\u001c\u001d\u0005"+
		"\u0006\u0000\u0000\u001d+\u0003\u0002\u0001\n\u001e\u001f\n\b\u0000\u0000"+
		"\u001f \u0005\u0003\u0000\u0000 +\u0003\u0002\u0001\t!\"\n\u0007\u0000"+
		"\u0000\"#\u0005\u0004\u0000\u0000#+\u0003\u0002\u0001\b$%\n\u0006\u0000"+
		"\u0000%&\u0005\u0001\u0000\u0000&+\u0003\u0002\u0001\u0007\'(\n\u0005"+
		"\u0000\u0000()\u0005\u0002\u0000\u0000)+\u0003\u0002\u0001\u0006*\u001b"+
		"\u0001\u0000\u0000\u0000*\u001e\u0001\u0000\u0000\u0000*!\u0001\u0000"+
		"\u0000\u0000*$\u0001\u0000\u0000\u0000*\'\u0001\u0000\u0000\u0000+.\u0001"+
		"\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000"+
		"-\u0003\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/4\u0005\n\u0000"+
		"\u000001\u0005\f\u0000\u000013\u0005\u0007\u0000\u000020\u0001\u0000\u0000"+
		"\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0005"+
		"\u000b\u0000\u00008\u0005\u0001\u0000\u0000\u00009=\u0005\n\u0000\u0000"+
		":<\u0003\b\u0004\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000@A\u0005\u000b\u0000\u0000A\u0007\u0001"+
		"\u0000\u0000\u0000BD\u0005\f\u0000\u0000CE\u0005\f\u0000\u0000DC\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000"+
		"FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0005\u0007\u0000"+
		"\u0000I\t\u0001\u0000\u0000\u0000\u0006\u0019*,4=F";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}