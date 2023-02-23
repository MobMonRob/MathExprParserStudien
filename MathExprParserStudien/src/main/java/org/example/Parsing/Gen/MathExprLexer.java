package org.example.Parsing.Gen; // Generated from java-escape by ANTLR 4.11.1
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
		PLUS_SIGN=1, HYPHEN_MINUS=2, ASTERISK=3, SOLIDUS=4, CROSS=5, CIRCUMFLEX_ACCENT=6, 
		SEMICOLON=7, LPARENT=8, RPARENT=9, LSQUAREBRACKET=10, RSQUAREBRACKET=11, 
		DOUBLE=12, FORMAT=13, ANY=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PLUS_SIGN", "HYPHEN_MINUS", "ASTERISK", "SOLIDUS", "CROSS", "CIRCUMFLEX_ACCENT", 
			"SEMICOLON", "LPARENT", "RPARENT", "LSQUAREBRACKET", "RSQUAREBRACKET", 
			"DIGIT", "DOUBLE", "FORMAT", "ANY"
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
		"\u0004\u0000\u000eM\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0004\f9\b\f\u000b"+
		"\f\f\f:\u0001\f\u0001\f\u0004\f?\b\f\u000b\f\f\f@\u0003\fC\b\f\u0001\r"+
		"\u0004\rF\b\r\u000b\r\f\rG\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0000"+
		"\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\u0000\u0019\f"+
		"\u001b\r\u001d\u000e\u0001\u0000\u0002\u0001\u000009\u0003\u0000\t\n\f"+
		"\f  O\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0001"+
		"\u001f\u0001\u0000\u0000\u0000\u0003!\u0001\u0000\u0000\u0000\u0005#\u0001"+
		"\u0000\u0000\u0000\u0007%\u0001\u0000\u0000\u0000\t\'\u0001\u0000\u0000"+
		"\u0000\u000b)\u0001\u0000\u0000\u0000\r+\u0001\u0000\u0000\u0000\u000f"+
		"-\u0001\u0000\u0000\u0000\u0011/\u0001\u0000\u0000\u0000\u00131\u0001"+
		"\u0000\u0000\u0000\u00153\u0001\u0000\u0000\u0000\u00175\u0001\u0000\u0000"+
		"\u0000\u00198\u0001\u0000\u0000\u0000\u001bE\u0001\u0000\u0000\u0000\u001d"+
		"K\u0001\u0000\u0000\u0000\u001f \u0005+\u0000\u0000 \u0002\u0001\u0000"+
		"\u0000\u0000!\"\u0005-\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000#$\u0005"+
		"*\u0000\u0000$\u0006\u0001\u0000\u0000\u0000%&\u0005/\u0000\u0000&\b\u0001"+
		"\u0000\u0000\u0000\'(\u0005x\u0000\u0000(\n\u0001\u0000\u0000\u0000)*"+
		"\u0005^\u0000\u0000*\f\u0001\u0000\u0000\u0000+,\u0005;\u0000\u0000,\u000e"+
		"\u0001\u0000\u0000\u0000-.\u0005(\u0000\u0000.\u0010\u0001\u0000\u0000"+
		"\u0000/0\u0005)\u0000\u00000\u0012\u0001\u0000\u0000\u000012\u0005[\u0000"+
		"\u00002\u0014\u0001\u0000\u0000\u000034\u0005]\u0000\u00004\u0016\u0001"+
		"\u0000\u0000\u000056\u0007\u0000\u0000\u00006\u0018\u0001\u0000\u0000"+
		"\u000079\u0003\u0017\u000b\u000087\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;B\u0001"+
		"\u0000\u0000\u0000<>\u0005.\u0000\u0000=?\u0003\u0017\u000b\u0000>=\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B<\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000C\u001a\u0001\u0000\u0000\u0000DF\u0007"+
		"\u0001\u0000\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000IJ\u0006\r\u0000\u0000J\u001c\u0001\u0000\u0000\u0000KL\t\u0000"+
		"\u0000\u0000L\u001e\u0001\u0000\u0000\u0000\u0005\u0000:@BG\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}