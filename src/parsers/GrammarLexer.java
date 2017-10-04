// Generated from D:/программирование/итмо/6 семестр/Методы трансляции/parser_generator/src/parsers\GrammarLexer.g4 by ANTLR 4.5.1
package parsers;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OSB=1, COLON=2, OR=3, SEMICOLON=4, EQUAL=5, OCB=6, SHARP_START=7, LOCALS=8, 
		RETURNS=9, INIT=10, MEMBERS=11, Nonterm=12, Term=13, Regular=14, WS=15, 
		CSB=16, COMMA=17, Word=18, WS2=19, CCB=20, TEXT=21, SHARP_FINISH=22, CODE=23;
	public static final int ENUM = 1;
	public static final int CODE_MODE = 2;
	public static final int MEMBERS_MODE = 3;
	public static String[] modeNames = {
		"DEFAULT_MODE", "ENUM", "CODE_MODE", "MEMBERS_MODE"
	};

	public static final String[] ruleNames = {
		"OSB", "COLON", "OR", "SEMICOLON", "EQUAL", "OCB", "SHARP_START", "LOCALS", 
		"RETURNS", "INIT", "MEMBERS", "Nonterm", "Term", "Regular", "WS", "CSB", 
		"COMMA", "Word", "WS2", "CCB", "TEXT", "SHARP_FINISH", "CODE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "':'", "'|'", "';'", "'='", "'{'", null, "'locals'", "'returns'", 
		"'@init'", "'@members'", null, null, null, null, "']'", "','", null, null, 
		"'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OSB", "COLON", "OR", "SEMICOLON", "EQUAL", "OCB", "SHARP_START", 
		"LOCALS", "RETURNS", "INIT", "MEMBERS", "Nonterm", "Term", "Regular", 
		"WS", "CSB", "COMMA", "Word", "WS2", "CCB", "TEXT", "SHARP_FINISH", "CODE"
	};
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GrammarLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00a9\b\1\b\1"+
		"\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
		"\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30"+
		"\t\30\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\7\ri\n\r\f\r\16\rl\13\r\3\16\3\16\7\16p\n\16\f\16\16\16s\13"+
		"\16\3\17\3\17\6\17w\n\17\r\17\16\17x\3\17\3\17\3\20\6\20~\n\20\r\20\16"+
		"\20\177\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\7\23\u008c\n"+
		"\23\f\23\16\23\u008f\13\23\3\24\6\24\u0092\n\24\r\24\16\24\u0093\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\26\6\26\u009d\n\26\r\26\16\26\u009e\3\27\3"+
		"\27\3\27\3\27\3\30\6\30\u00a6\n\30\r\30\16\30\u00a7\3x\2\31\6\3\b\4\n"+
		"\5\f\6\16\7\20\b\22\t\24\n\26\13\30\f\32\r\34\16\36\17 \20\"\21$\22&\23"+
		"(\24*\25,\26.\27\60\30\62\31\6\2\3\4\5\f\3\2c|\6\2))C\\aac|\3\2C\\\5\2"+
		"\62;C\\c|\3\2$$\5\2\13\f\17\17\"\"\6\2$$&&C\\c|\13\2$$&&--\62;>>@@C\\"+
		"aac|\3\2\177\177\3\2%%\u00ad\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3"+
		"\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2"+
		"\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\""+
		"\3\2\2\2\3$\3\2\2\2\3&\3\2\2\2\3(\3\2\2\2\3*\3\2\2\2\4,\3\2\2\2\4.\3\2"+
		"\2\2\5\60\3\2\2\2\5\62\3\2\2\2\6\64\3\2\2\2\b8\3\2\2\2\n:\3\2\2\2\f<\3"+
		"\2\2\2\16>\3\2\2\2\20@\3\2\2\2\22D\3\2\2\2\24H\3\2\2\2\26O\3\2\2\2\30"+
		"W\3\2\2\2\32]\3\2\2\2\34f\3\2\2\2\36m\3\2\2\2 t\3\2\2\2\"}\3\2\2\2$\u0083"+
		"\3\2\2\2&\u0087\3\2\2\2(\u0089\3\2\2\2*\u0091\3\2\2\2,\u0097\3\2\2\2."+
		"\u009c\3\2\2\2\60\u00a0\3\2\2\2\62\u00a5\3\2\2\2\64\65\7]\2\2\65\66\3"+
		"\2\2\2\66\67\b\2\2\2\67\7\3\2\2\289\7<\2\29\t\3\2\2\2:;\7~\2\2;\13\3\2"+
		"\2\2<=\7=\2\2=\r\3\2\2\2>?\7?\2\2?\17\3\2\2\2@A\7}\2\2AB\3\2\2\2BC\b\7"+
		"\3\2C\21\3\2\2\2DE\7%\2\2EF\3\2\2\2FG\b\b\4\2G\23\3\2\2\2HI\7n\2\2IJ\7"+
		"q\2\2JK\7e\2\2KL\7c\2\2LM\7n\2\2MN\7u\2\2N\25\3\2\2\2OP\7t\2\2PQ\7g\2"+
		"\2QR\7v\2\2RS\7w\2\2ST\7t\2\2TU\7p\2\2UV\7u\2\2V\27\3\2\2\2WX\7B\2\2X"+
		"Y\7k\2\2YZ\7p\2\2Z[\7k\2\2[\\\7v\2\2\\\31\3\2\2\2]^\7B\2\2^_\7o\2\2_`"+
		"\7g\2\2`a\7o\2\2ab\7d\2\2bc\7g\2\2cd\7t\2\2de\7u\2\2e\33\3\2\2\2fj\t\2"+
		"\2\2gi\t\3\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\35\3\2\2\2lj\3"+
		"\2\2\2mq\t\4\2\2np\t\5\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\37"+
		"\3\2\2\2sq\3\2\2\2tv\t\6\2\2uw\13\2\2\2vu\3\2\2\2wx\3\2\2\2xy\3\2\2\2"+
		"xv\3\2\2\2yz\3\2\2\2z{\t\6\2\2{!\3\2\2\2|~\t\7\2\2}|\3\2\2\2~\177\3\2"+
		"\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\b"+
		"\20\5\2\u0082#\3\2\2\2\u0083\u0084\7_\2\2\u0084\u0085\3\2\2\2\u0085\u0086"+
		"\b\21\6\2\u0086%\3\2\2\2\u0087\u0088\7.\2\2\u0088\'\3\2\2\2\u0089\u008d"+
		"\t\b\2\2\u008a\u008c\t\t\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e)\3\2\2\2\u008f\u008d\3\2\2\2"+
		"\u0090\u0092\t\7\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\b\24\5\2"+
		"\u0096+\3\2\2\2\u0097\u0098\7\177\2\2\u0098\u0099\3\2\2\2\u0099\u009a"+
		"\b\25\6\2\u009a-\3\2\2\2\u009b\u009d\n\n\2\2\u009c\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f/\3\2\2\2"+
		"\u00a0\u00a1\7%\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b\27\6\2\u00a3\61"+
		"\3\2\2\2\u00a4\u00a6\n\13\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2"+
		"\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\63\3\2\2\2\16\2\3\4\5j"+
		"qx\177\u008d\u0093\u009e\u00a7\7\7\3\2\7\4\2\7\5\2\b\2\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}