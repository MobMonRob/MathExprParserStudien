package org.example.Parsing.Gen;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MathExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS_SIGN=1, HYPHEN_MINUS=2, APOSTROPHE=3, ASTERISK=4, SOLIDUS=5, CROSS=6, 
		CARET=7, SEMICOLON=8, LPARENTHESIS=9, RPARENTHESIS=10, LSQUAREBRACKET=11, 
		RSQUAREBRACKET=12, IDENTIFIER=13, POSITIVEDOUBLE=14, FORMAT=15, ANY=16;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_double = 2, RULE_vector = 3, RULE_matrix = 4, 
		RULE_transposedVector = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "double", "vector", "matrix", "transposedVector"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'''", "'*'", "'/'", "'x'", "'^'", "';'", "'('", 
			"')'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS_SIGN", "HYPHEN_MINUS", "APOSTROPHE", "ASTERISK", "SOLIDUS", 
			"CROSS", "CARET", "SEMICOLON", "LPARENTHESIS", "RPARENTHESIS", "LSQUAREBRACKET", 
			"RSQUAREBRACKET", "IDENTIFIER", "POSITIVEDOUBLE", "FORMAT", "ANY"
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
			setState(12);
			expr(0);
			setState(13);
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
	public static class FunctionExprContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(MathExprParser.IDENTIFIER, 0); }
		public TerminalNode LPARENTHESIS() { return getToken(MathExprParser.LPARENTHESIS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPARENTHESIS() { return getToken(MathExprParser.RPARENTHESIS, 0); }
		public FunctionExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterFunctionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitFunctionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitFunctionExpr(this);
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
		public TerminalNode CARET() { return getToken(MathExprParser.CARET, 0); }
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
		public TerminalNode SOLIDUS() { return getToken(MathExprParser.SOLIDUS, 0); }
		public TerminalNode CROSS() { return getToken(MathExprParser.CROSS, 0); }
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
		public TerminalNode POSITIVEDOUBLE() { return getToken(MathExprParser.POSITIVEDOUBLE, 0); }
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
		public TerminalNode HYPHEN_MINUS() { return getToken(MathExprParser.HYPHEN_MINUS, 0); }
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
		public TerminalNode LPARENTHESIS() { return getToken(MathExprParser.LPARENTHESIS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPARENTHESIS() { return getToken(MathExprParser.RPARENTHESIS, 0); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class TransExprContext extends ExprContext {
		public TerminalNode APOSTROPHE() { return getToken(MathExprParser.APOSTROPHE, 0); }
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public TransExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterTransExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitTransExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitTransExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegationExprContext extends ExprContext {
		public TerminalNode HYPHEN_MINUS() { return getToken(MathExprParser.HYPHEN_MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegationExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterNegationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitNegationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitNegationExpr(this);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(16);
				match(LPARENTHESIS);
				setState(17);
				expr(0);
				setState(18);
				match(RPARENTHESIS);
				}
				break;
			case 2:
				{
				_localctx = new FunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				match(IDENTIFIER);
				setState(21);
				match(LPARENTHESIS);
				setState(22);
				expr(0);
				setState(23);
				match(RPARENTHESIS);
				}
				break;
			case 3:
				{
				_localctx = new NegationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(HYPHEN_MINUS);
				setState(26);
				expr(7);
				}
				break;
			case 4:
				{
				_localctx = new VectorExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				vector();
				}
				break;
			case 5:
				{
				_localctx = new MatrixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				matrix();
				}
				break;
			case 6:
				{
				_localctx = new TransExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(29);
					vector();
					}
					break;
				case 2:
					{
					setState(30);
					matrix();
					}
					break;
				}
				setState(33);
				match(APOSTROPHE);
				}
				break;
			case 7:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(POSITIVEDOUBLE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(47);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExponentExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(38);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(39);
						match(CARET);
						setState(40);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(41);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(42);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(43);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(44);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(45);
						_la = _input.LA(1);
						if ( !(_la==PLUS_SIGN || _la==HYPHEN_MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(46);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
	public static class DoubleContext extends ParserRuleContext {
		public DoubleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double; }
	 
		public DoubleContext() { }
		public void copyFrom(DoubleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleLiteralContext extends DoubleContext {
		public TerminalNode POSITIVEDOUBLE() { return getToken(MathExprParser.POSITIVEDOUBLE, 0); }
		public TerminalNode HYPHEN_MINUS() { return getToken(MathExprParser.HYPHEN_MINUS, 0); }
		public DoubleLiteralContext(DoubleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterDoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitDoubleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitDoubleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleContext double_() throws RecognitionException {
		DoubleContext _localctx = new DoubleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_double);
		int _la;
		try {
			_localctx = new DoubleLiteralContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HYPHEN_MINUS) {
				{
				setState(52);
				match(HYPHEN_MINUS);
				}
			}

			setState(55);
			match(POSITIVEDOUBLE);
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
	public static class VectorContext extends ParserRuleContext {
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
	 
		public VectorContext() { }
		public void copyFrom(VectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorLiteralContext extends VectorContext {
		public TerminalNode LSQUAREBRACKET() { return getToken(MathExprParser.LSQUAREBRACKET, 0); }
		public TerminalNode RSQUAREBRACKET() { return getToken(MathExprParser.RSQUAREBRACKET, 0); }
		public List<DoubleContext> double_() {
			return getRuleContexts(DoubleContext.class);
		}
		public DoubleContext double_(int i) {
			return getRuleContext(DoubleContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MathExprParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MathExprParser.SEMICOLON, i);
		}
		public VectorLiteralContext(VectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterVectorLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitVectorLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitVectorLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vector);
		int _la;
		try {
			_localctx = new VectorLiteralContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(LSQUAREBRACKET);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN_MINUS || _la==POSITIVEDOUBLE) {
				{
				{
				setState(58);
				double_();
				setState(59);
				match(SEMICOLON);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
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
		enterRule(_localctx, 8, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(LSQUAREBRACKET);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HYPHEN_MINUS || _la==POSITIVEDOUBLE) {
				{
				{
				setState(69);
				transposedVector();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
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
		public TerminalNode SEMICOLON() { return getToken(MathExprParser.SEMICOLON, 0); }
		public List<DoubleContext> double_() {
			return getRuleContexts(DoubleContext.class);
		}
		public DoubleContext double_(int i) {
			return getRuleContext(DoubleContext.class,i);
		}
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
		enterRule(_localctx, 10, RULE_transposedVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				double_();
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HYPHEN_MINUS || _la==POSITIVEDOUBLE );
			setState(82);
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
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0010U\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001%\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u00010\b\u0001\n\u0001\f\u00013\t\u0001\u0001\u0002\u0003"+
		"\u00026\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003>\b\u0003\n\u0003\f\u0003A\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004G\b\u0004\n\u0004"+
		"\f\u0004J\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005O\b\u0005"+
		"\u000b\u0005\f\u0005P\u0001\u0005\u0001\u0005\u0001\u0005\u0000\u0001"+
		"\u0002\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0002\u0001\u0000\u0004"+
		"\u0006\u0001\u0000\u0001\u0002\\\u0000\f\u0001\u0000\u0000\u0000\u0002"+
		"$\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u00069\u0001"+
		"\u0000\u0000\u0000\bD\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000\u0000"+
		"\f\r\u0003\u0002\u0001\u0000\r\u000e\u0005\u0000\u0000\u0001\u000e\u0001"+
		"\u0001\u0000\u0000\u0000\u000f\u0010\u0006\u0001\uffff\uffff\u0000\u0010"+
		"\u0011\u0005\t\u0000\u0000\u0011\u0012\u0003\u0002\u0001\u0000\u0012\u0013"+
		"\u0005\n\u0000\u0000\u0013%\u0001\u0000\u0000\u0000\u0014\u0015\u0005"+
		"\r\u0000\u0000\u0015\u0016\u0005\t\u0000\u0000\u0016\u0017\u0003\u0002"+
		"\u0001\u0000\u0017\u0018\u0005\n\u0000\u0000\u0018%\u0001\u0000\u0000"+
		"\u0000\u0019\u001a\u0005\u0002\u0000\u0000\u001a%\u0003\u0002\u0001\u0007"+
		"\u001b%\u0003\u0006\u0003\u0000\u001c%\u0003\b\u0004\u0000\u001d \u0003"+
		"\u0006\u0003\u0000\u001e \u0003\b\u0004\u0000\u001f\u001d\u0001\u0000"+
		"\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000"+
		"!\"\u0005\u0003\u0000\u0000\"%\u0001\u0000\u0000\u0000#%\u0005\u000e\u0000"+
		"\u0000$\u000f\u0001\u0000\u0000\u0000$\u0014\u0001\u0000\u0000\u0000$"+
		"\u0019\u0001\u0000\u0000\u0000$\u001b\u0001\u0000\u0000\u0000$\u001c\u0001"+
		"\u0000\u0000\u0000$\u001f\u0001\u0000\u0000\u0000$#\u0001\u0000\u0000"+
		"\u0000%1\u0001\u0000\u0000\u0000&\'\n\b\u0000\u0000\'(\u0005\u0007\u0000"+
		"\u0000(0\u0003\u0002\u0001\t)*\n\u0006\u0000\u0000*+\u0007\u0000\u0000"+
		"\u0000+0\u0003\u0002\u0001\u0007,-\n\u0005\u0000\u0000-.\u0007\u0001\u0000"+
		"\u0000.0\u0003\u0002\u0001\u0006/&\u0001\u0000\u0000\u0000/)\u0001\u0000"+
		"\u0000\u0000/,\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0003\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000046\u0005\u0002\u0000\u000054\u0001\u0000"+
		"\u0000\u000056\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000078\u0005"+
		"\u000e\u0000\u00008\u0005\u0001\u0000\u0000\u00009?\u0005\u000b\u0000"+
		"\u0000:;\u0003\u0004\u0002\u0000;<\u0005\b\u0000\u0000<>\u0001\u0000\u0000"+
		"\u0000=:\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000BC\u0005\f\u0000\u0000C\u0007\u0001\u0000\u0000\u0000"+
		"DH\u0005\u000b\u0000\u0000EG\u0003\n\u0005\u0000FE\u0001\u0000\u0000\u0000"+
		"GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0005\f\u0000"+
		"\u0000L\t\u0001\u0000\u0000\u0000MO\u0003\u0004\u0002\u0000NM\u0001\u0000"+
		"\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0005\b\u0000\u0000S\u000b"+
		"\u0001\u0000\u0000\u0000\b\u001f$/15?HP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}