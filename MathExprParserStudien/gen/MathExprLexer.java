// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MathExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS_SIGN=1, HYPHEN_MINUS=2, ASTERISK=3, SOLIDUS=4, CROSS=5, CARET=6, 
		SEMICOLON=7, LPARENTHESIS=8, RPARENTHESIS=9, LSQUAREBRACKET=10, RSQUAREBRACKET=11, 
		IDENTIFIER=12, DOUBLE=13, FORMAT=14, ANY=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PLUS_SIGN", "HYPHEN_MINUS", "ASTERISK", "SOLIDUS", "CROSS", "CARET", 
			"SEMICOLON", "LPARENTHESIS", "RPARENTHESIS", "LSQUAREBRACKET", "RSQUAREBRACKET", 
			"DIGIT", "LETTER", "IDENTIFIER", "DOUBLE", "FORMAT", "ANY"
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
			null, "PLUS_SIGN", "HYPHEN_MINUS", "ASTERISK", "SOLIDUS", "CROSS", "CARET", 
			"SEMICOLON", "LPARENTHESIS", "RPARENTHESIS", "LSQUAREBRACKET", "RSQUAREBRACKET", 
			"IDENTIFIER", "DOUBLE", "FORMAT", "ANY"
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


	public MathExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MathExprLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000fX\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0004\r?\b\r\u000b\r\f\r@\u0001"+
		"\u000e\u0004\u000eD\b\u000e\u000b\u000e\f\u000eE\u0001\u000e\u0001\u000e"+
		"\u0004\u000eJ\b\u000e\u000b\u000e\f\u000eK\u0003\u000eN\b\u000e\u0001"+
		"\u000f\u0004\u000fQ\b\u000f\u000b\u000f\f\u000fR\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0000\u0000\u0011\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\u0000\u0019\u0000\u001b\f\u001d\r\u001f\u000e!\u000f"+
		"\u0001\u0000\u0003\u0001\u000009\u0003\u0000,,AZaz\u0003\u0000\t\n\f\f"+
		"  Z\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0003%\u0001"+
		"\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000\u0007)\u0001\u0000"+
		"\u0000\u0000\t+\u0001\u0000\u0000\u0000\u000b-\u0001\u0000\u0000\u0000"+
		"\r/\u0001\u0000\u0000\u0000\u000f1\u0001\u0000\u0000\u0000\u00113\u0001"+
		"\u0000\u0000\u0000\u00135\u0001\u0000\u0000\u0000\u00157\u0001\u0000\u0000"+
		"\u0000\u00179\u0001\u0000\u0000\u0000\u0019;\u0001\u0000\u0000\u0000\u001b"+
		">\u0001\u0000\u0000\u0000\u001dC\u0001\u0000\u0000\u0000\u001fP\u0001"+
		"\u0000\u0000\u0000!V\u0001\u0000\u0000\u0000#$\u0005+\u0000\u0000$\u0002"+
		"\u0001\u0000\u0000\u0000%&\u0005-\u0000\u0000&\u0004\u0001\u0000\u0000"+
		"\u0000\'(\u0005*\u0000\u0000(\u0006\u0001\u0000\u0000\u0000)*\u0005/\u0000"+
		"\u0000*\b\u0001\u0000\u0000\u0000+,\u0005x\u0000\u0000,\n\u0001\u0000"+
		"\u0000\u0000-.\u0005^\u0000\u0000.\f\u0001\u0000\u0000\u0000/0\u0005;"+
		"\u0000\u00000\u000e\u0001\u0000\u0000\u000012\u0005(\u0000\u00002\u0010"+
		"\u0001\u0000\u0000\u000034\u0005)\u0000\u00004\u0012\u0001\u0000\u0000"+
		"\u000056\u0005[\u0000\u00006\u0014\u0001\u0000\u0000\u000078\u0005]\u0000"+
		"\u00008\u0016\u0001\u0000\u0000\u00009:\u0007\u0000\u0000\u0000:\u0018"+
		"\u0001\u0000\u0000\u0000;<\u0007\u0001\u0000\u0000<\u001a\u0001\u0000"+
		"\u0000\u0000=?\u0003\u0019\f\u0000>=\u0001\u0000\u0000\u0000?@\u0001\u0000"+
		"\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A\u001c"+
		"\u0001\u0000\u0000\u0000BD\u0003\u0017\u000b\u0000CB\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FM\u0001\u0000\u0000\u0000GI\u0005.\u0000\u0000HJ\u0003\u0017"+
		"\u000b\u0000IH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000"+
		"MG\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u001e\u0001\u0000"+
		"\u0000\u0000OQ\u0007\u0002\u0000\u0000PO\u0001\u0000\u0000\u0000QR\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000TU\u0006\u000f\u0000\u0000U \u0001\u0000\u0000"+
		"\u0000VW\t\u0000\u0000\u0000W\"\u0001\u0000\u0000\u0000\u0006\u0000@E"+
		"KMR\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}