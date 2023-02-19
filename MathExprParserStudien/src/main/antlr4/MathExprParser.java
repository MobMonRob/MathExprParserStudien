// Generated from java-escape by ANTLR 4.11.1
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
		PLUS_SIGN=1, HYPHEN_MINUS=2, ASTERISK=3, SOLIDUS=4, CIRCUMFLEX_ACCENT=5, 
		LPARENT=6, RPARENT=7, NUM=8, WS=9, NEWLINE=10, ANY=11;
	public static final int
		RULE_program = 0, RULE_expr = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'^'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS_SIGN", "HYPHEN_MINUS", "ASTERISK", "SOLIDUS", "CIRCUMFLEX_ACCENT", 
			"LPARENT", "RPARENT", "NUM", "WS", "NEWLINE", "ANY"
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
		public TerminalNode NEWLINE() { return getToken(MathExprParser.NEWLINE, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			expr(0);
			setState(5);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class InfixExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CIRCUMFLEX_ACCENT() { return getToken(MathExprParser.CIRCUMFLEX_ACCENT, 0); }
		public TerminalNode ASTERISK() { return getToken(MathExprParser.ASTERISK, 0); }
		public TerminalNode SOLIDUS() { return getToken(MathExprParser.SOLIDUS, 0); }
		public TerminalNode PLUS_SIGN() { return getToken(MathExprParser.PLUS_SIGN, 0); }
		public TerminalNode HYPHEN_MINUS() { return getToken(MathExprParser.HYPHEN_MINUS, 0); }
		public InfixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterInfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitInfixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitInfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensExprContext extends ExprContext {
		public TerminalNode LPARENT() { return getToken(MathExprParser.LPARENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPARENT() { return getToken(MathExprParser.RPARENT, 0); }
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathExprParserListener ) ((MathExprParserListener)listener).exitParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathExprParserVisitor ) return ((MathExprParserVisitor<? extends T>)visitor).visitParensExpr(this);
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
			{
			_localctx = new ParensExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(8);
			match(LPARENT);
			setState(9);
			expr(0);
			setState(10);
			match(RPARENT);
			}
			_ctx.stop = _input.LT(-1);
			setState(22);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(20);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(12);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(13);
						match(CIRCUMFLEX_ACCENT);
						setState(14);
						expr(4);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(15);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(16);
						_la = _input.LA(1);
						if ( !(_la==ASTERISK || _la==SOLIDUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(17);
						expr(3);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(18);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(19);
						_la = _input.LA(1);
						if ( !(_la==PLUS_SIGN || _la==HYPHEN_MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(24);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000b\u001a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u0015\b\u0001"+
		"\n\u0001\f\u0001\u0018\t\u0001\u0001\u0001\u0000\u0001\u0002\u0002\u0000"+
		"\u0002\u0000\u0003\u0001\u0001\n\n\u0001\u0000\u0003\u0004\u0001\u0000"+
		"\u0001\u0002\u001a\u0000\u0004\u0001\u0000\u0000\u0000\u0002\u0007\u0001"+
		"\u0000\u0000\u0000\u0004\u0005\u0003\u0002\u0001\u0000\u0005\u0006\u0007"+
		"\u0000\u0000\u0000\u0006\u0001\u0001\u0000\u0000\u0000\u0007\b\u0006\u0001"+
		"\uffff\uffff\u0000\b\t\u0005\u0006\u0000\u0000\t\n\u0003\u0002\u0001\u0000"+
		"\n\u000b\u0005\u0007\u0000\u0000\u000b\u0016\u0001\u0000\u0000\u0000\f"+
		"\r\n\u0003\u0000\u0000\r\u000e\u0005\u0005\u0000\u0000\u000e\u0015\u0003"+
		"\u0002\u0001\u0004\u000f\u0010\n\u0002\u0000\u0000\u0010\u0011\u0007\u0001"+
		"\u0000\u0000\u0011\u0015\u0003\u0002\u0001\u0003\u0012\u0013\n\u0001\u0000"+
		"\u0000\u0013\u0015\u0007\u0002\u0000\u0000\u0014\f\u0001\u0000\u0000\u0000"+
		"\u0014\u000f\u0001\u0000\u0000\u0000\u0014\u0012\u0001\u0000\u0000\u0000"+
		"\u0015\u0018\u0001\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000\u0000"+
		"\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0003\u0001\u0000\u0000\u0000"+
		"\u0018\u0016\u0001\u0000\u0000\u0000\u0002\u0014\u0016";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}