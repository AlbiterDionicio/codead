// Generated from com\codeadbackend\codead\CodeadGrammar.g4 by ANTLR 4.7.1
package com.codeadbackend.codead;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CodeadGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NOT_BLANK_DECORATOR_OPEN=1, NOT_BLANK_DECORATOR=2, TIME_DECORATOR_OPEN=3, 
		TIME_DECORATOR=4, DECIMAL_DECORATOR_OPEN=5, DECIMAL_DECORATOR=6, INTEGER_DECORATOR_OPEN=7, 
		INTEGER_DECORATOR=8, MAX_DECORATOR_OPEN=9, MAX_DECORATOR=10, MIN_DECORATOR_OPEN=11, 
		MIN_DECORATOR=12, NULLABLE_DECORATOR_OPEN=13, NULLABLE_DECORATOR=14, UNIQUE_DECORATOR_OPEN=15, 
		UNIQUE_DECORATOR=16, DECORATOR_CLOSE=17, BOOLEAN=18, TIME=19, BYTE_KEY=20, 
		SHORT_KEY=21, INT_KEY=22, LONG_KEY=23, FLOAT_KEY=24, DOUBLE_KEY=25, BOOLEAN_KEY=26, 
		STRING_KEY=27, LOCAL_DATE_KEY=28, DECIMAL_NUMBER=29, INTEGER_NUMBER=30, 
		NATURAL_NUMBER=31, ID_CAMEL_CASE=32, ID_PASCAL_CASE=33, WS=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NOT_BLANK_DECORATOR_OPEN", "NOT_BLANK_DECORATOR", "TIME_DECORATOR_OPEN", 
		"TIME_DECORATOR", "DECIMAL_DECORATOR_OPEN", "DECIMAL_DECORATOR", "INTEGER_DECORATOR_OPEN", 
		"INTEGER_DECORATOR", "MAX_DECORATOR_OPEN", "MAX_DECORATOR", "MIN_DECORATOR_OPEN", 
		"MIN_DECORATOR", "NULLABLE_DECORATOR_OPEN", "NULLABLE_DECORATOR", "UNIQUE_DECORATOR_OPEN", 
		"UNIQUE_DECORATOR", "DECORATOR_CLOSE", "BOOLEAN", "TIME", "BYTE_KEY", 
		"SHORT_KEY", "INT_KEY", "LONG_KEY", "FLOAT_KEY", "DOUBLE_KEY", "BOOLEAN_KEY", 
		"STRING_KEY", "LOCAL_DATE_KEY", "DECIMAL_NUMBER", "INTEGER_NUMBER", "NATURAL_NUMBER", 
		"ID_CAMEL_CASE", "ID_PASCAL_CASE", "SPACE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'@NotBlank'", null, "'@Time'", null, "'@Decimal'", null, 
		"'@Integer'", null, "'@Max'", null, "'@Min'", null, "'@Nullable'", null, 
		"'@Unique'", "')'", null, null, "'byte'", "'short'", "'int'", "'long'", 
		"'float'", "'double'", "'boolean'", "'String'", "'LocalDate'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NOT_BLANK_DECORATOR_OPEN", "NOT_BLANK_DECORATOR", "TIME_DECORATOR_OPEN", 
		"TIME_DECORATOR", "DECIMAL_DECORATOR_OPEN", "DECIMAL_DECORATOR", "INTEGER_DECORATOR_OPEN", 
		"INTEGER_DECORATOR", "MAX_DECORATOR_OPEN", "MAX_DECORATOR", "MIN_DECORATOR_OPEN", 
		"MIN_DECORATOR", "NULLABLE_DECORATOR_OPEN", "NULLABLE_DECORATOR", "UNIQUE_DECORATOR_OPEN", 
		"UNIQUE_DECORATOR", "DECORATOR_CLOSE", "BOOLEAN", "TIME", "BYTE_KEY", 
		"SHORT_KEY", "INT_KEY", "LONG_KEY", "FLOAT_KEY", "DOUBLE_KEY", "BOOLEAN_KEY", 
		"STRING_KEY", "LOCAL_DATE_KEY", "DECIMAL_NUMBER", "INTEGER_NUMBER", "NATURAL_NUMBER", 
		"ID_CAMEL_CASE", "ID_PASCAL_CASE", "WS"
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


	public CodeadGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CodeadGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u0145\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\5\23\u00b4\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00d4\n\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u011e\n\36"+
		"\3\37\3\37\3\37\3\37\5\37\u0124\n\37\3 \6 \u0127\n \r \16 \u0128\3!\3"+
		"!\7!\u012d\n!\f!\16!\u0130\13!\3\"\3\"\7\"\u0134\n\"\f\"\16\"\u0137\13"+
		"\"\3#\7#\u013a\n#\f#\16#\u013d\13#\3$\6$\u0140\n$\r$\16$\u0141\3$\3$\2"+
		"\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E\2G$\3\2\7\3\2\62;\3\2c|\5\2\62;C\\c|\3\2C\\\5\2\13\f\17"+
		"\17\"\"\2\u0150\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2G\3"+
		"\2\2\2\3I\3\2\2\2\5M\3\2\2\2\7W\3\2\2\2\t[\3\2\2\2\13a\3\2\2\2\re\3\2"+
		"\2\2\17n\3\2\2\2\21r\3\2\2\2\23{\3\2\2\2\25\177\3\2\2\2\27\u0084\3\2\2"+
		"\2\31\u0088\3\2\2\2\33\u008d\3\2\2\2\35\u0091\3\2\2\2\37\u009b\3\2\2\2"+
		"!\u00a0\3\2\2\2#\u00a8\3\2\2\2%\u00b3\3\2\2\2\'\u00d3\3\2\2\2)\u00d5\3"+
		"\2\2\2+\u00da\3\2\2\2-\u00e0\3\2\2\2/\u00e4\3\2\2\2\61\u00e9\3\2\2\2\63"+
		"\u00ef\3\2\2\2\65\u00f6\3\2\2\2\67\u00fe\3\2\2\29\u0105\3\2\2\2;\u011d"+
		"\3\2\2\2=\u0123\3\2\2\2?\u0126\3\2\2\2A\u012a\3\2\2\2C\u0131\3\2\2\2E"+
		"\u013b\3\2\2\2G\u013f\3\2\2\2IJ\5\5\3\2JK\5E#\2KL\7*\2\2L\4\3\2\2\2MN"+
		"\7B\2\2NO\7P\2\2OP\7q\2\2PQ\7v\2\2QR\7D\2\2RS\7n\2\2ST\7c\2\2TU\7p\2\2"+
		"UV\7m\2\2V\6\3\2\2\2WX\5\t\5\2XY\5E#\2YZ\7*\2\2Z\b\3\2\2\2[\\\7B\2\2\\"+
		"]\7V\2\2]^\7k\2\2^_\7o\2\2_`\7g\2\2`\n\3\2\2\2ab\5\r\7\2bc\5E#\2cd\7*"+
		"\2\2d\f\3\2\2\2ef\7B\2\2fg\7F\2\2gh\7g\2\2hi\7e\2\2ij\7k\2\2jk\7o\2\2"+
		"kl\7c\2\2lm\7n\2\2m\16\3\2\2\2no\5\21\t\2op\5E#\2pq\7*\2\2q\20\3\2\2\2"+
		"rs\7B\2\2st\7K\2\2tu\7p\2\2uv\7v\2\2vw\7g\2\2wx\7i\2\2xy\7g\2\2yz\7t\2"+
		"\2z\22\3\2\2\2{|\5\25\13\2|}\5E#\2}~\7*\2\2~\24\3\2\2\2\177\u0080\7B\2"+
		"\2\u0080\u0081\7O\2\2\u0081\u0082\7c\2\2\u0082\u0083\7z\2\2\u0083\26\3"+
		"\2\2\2\u0084\u0085\5\31\r\2\u0085\u0086\5E#\2\u0086\u0087\7*\2\2\u0087"+
		"\30\3\2\2\2\u0088\u0089\7B\2\2\u0089\u008a\7O\2\2\u008a\u008b\7k\2\2\u008b"+
		"\u008c\7p\2\2\u008c\32\3\2\2\2\u008d\u008e\5\35\17\2\u008e\u008f\5E#\2"+
		"\u008f\u0090\7*\2\2\u0090\34\3\2\2\2\u0091\u0092\7B\2\2\u0092\u0093\7"+
		"P\2\2\u0093\u0094\7w\2\2\u0094\u0095\7n\2\2\u0095\u0096\7n\2\2\u0096\u0097"+
		"\7c\2\2\u0097\u0098\7d\2\2\u0098\u0099\7n\2\2\u0099\u009a\7g\2\2\u009a"+
		"\36\3\2\2\2\u009b\u009c\5!\21\2\u009c\u009d\5E#\2\u009d\u009e\7*\2\2\u009e"+
		"\u009f\5E#\2\u009f \3\2\2\2\u00a0\u00a1\7B\2\2\u00a1\u00a2\7W\2\2\u00a2"+
		"\u00a3\7p\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7s\2\2\u00a5\u00a6\7w\2\2"+
		"\u00a6\u00a7\7g\2\2\u00a7\"\3\2\2\2\u00a8\u00a9\7+\2\2\u00a9$\3\2\2\2"+
		"\u00aa\u00ab\7v\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad\7w\2\2\u00ad\u00b4"+
		"\7g\2\2\u00ae\u00af\7h\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7n\2\2\u00b1"+
		"\u00b2\7u\2\2\u00b2\u00b4\7g\2\2\u00b3\u00aa\3\2\2\2\u00b3\u00ae\3\2\2"+
		"\2\u00b4&\3\2\2\2\u00b5\u00b6\7H\2\2\u00b6\u00b7\7w\2\2\u00b7\u00b8\7"+
		"v\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7t\2\2\u00ba\u00d4\7g\2\2\u00bb\u00bc"+
		"\7H\2\2\u00bc\u00bd\7w\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7w\2\2\u00bf"+
		"\u00c0\7t\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7Q\2\2\u00c2\u00c3\7t\2\2"+
		"\u00c3\u00c4\7P\2\2\u00c4\u00c5\7q\2\2\u00c5\u00d4\7y\2\2\u00c6\u00c7"+
		"\7R\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7u\2\2\u00c9\u00d4\7v\2\2\u00ca"+
		"\u00cb\7R\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7v\2\2"+
		"\u00ce\u00cf\7Q\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7P\2\2\u00d1\u00d2"+
		"\7q\2\2\u00d2\u00d4\7y\2\2\u00d3\u00b5\3\2\2\2\u00d3\u00bb\3\2\2\2\u00d3"+
		"\u00c6\3\2\2\2\u00d3\u00ca\3\2\2\2\u00d4(\3\2\2\2\u00d5\u00d6\7d\2\2\u00d6"+
		"\u00d7\7{\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7g\2\2\u00d9*\3\2\2\2\u00da"+
		"\u00db\7u\2\2\u00db\u00dc\7j\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7t\2\2"+
		"\u00de\u00df\7v\2\2\u00df,\3\2\2\2\u00e0\u00e1\7k\2\2\u00e1\u00e2\7p\2"+
		"\2\u00e2\u00e3\7v\2\2\u00e3.\3\2\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7"+
		"q\2\2\u00e6\u00e7\7p\2\2\u00e7\u00e8\7i\2\2\u00e8\60\3\2\2\2\u00e9\u00ea"+
		"\7h\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7q\2\2\u00ec\u00ed\7c\2\2\u00ed"+
		"\u00ee\7v\2\2\u00ee\62\3\2\2\2\u00ef\u00f0\7f\2\2\u00f0\u00f1\7q\2\2\u00f1"+
		"\u00f2\7w\2\2\u00f2\u00f3\7d\2\2\u00f3\u00f4\7n\2\2\u00f4\u00f5\7g\2\2"+
		"\u00f5\64\3\2\2\2\u00f6\u00f7\7d\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7"+
		"q\2\2\u00f9\u00fa\7n\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7c\2\2\u00fc\u00fd"+
		"\7p\2\2\u00fd\66\3\2\2\2\u00fe\u00ff\7U\2\2\u00ff\u0100\7v\2\2\u0100\u0101"+
		"\7t\2\2\u0101\u0102\7k\2\2\u0102\u0103\7p\2\2\u0103\u0104\7i\2\2\u0104"+
		"8\3\2\2\2\u0105\u0106\7N\2\2\u0106\u0107\7q\2\2\u0107\u0108\7e\2\2\u0108"+
		"\u0109\7c\2\2\u0109\u010a\7n\2\2\u010a\u010b\7F\2\2\u010b\u010c\7c\2\2"+
		"\u010c\u010d\7v\2\2\u010d\u010e\7g\2\2\u010e:\3\2\2\2\u010f\u0110\5=\37"+
		"\2\u0110\u0111\7\60\2\2\u0111\u0112\5? \2\u0112\u011e\3\2\2\2\u0113\u0114"+
		"\7\60\2\2\u0114\u011e\5? \2\u0115\u0116\7/\2\2\u0116\u0117\7\60\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u011e\5? \2\u0119\u011a\7-\2\2\u011a\u011b\7\60\2"+
		"\2\u011b\u011c\3\2\2\2\u011c\u011e\5? \2\u011d\u010f\3\2\2\2\u011d\u0113"+
		"\3\2\2\2\u011d\u0115\3\2\2\2\u011d\u0119\3\2\2\2\u011e<\3\2\2\2\u011f"+
		"\u0120\7-\2\2\u0120\u0124\5? \2\u0121\u0122\7/\2\2\u0122\u0124\5? \2\u0123"+
		"\u011f\3\2\2\2\u0123\u0121\3\2\2\2\u0124>\3\2\2\2\u0125\u0127\t\2\2\2"+
		"\u0126\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129"+
		"\3\2\2\2\u0129@\3\2\2\2\u012a\u012e\t\3\2\2\u012b\u012d\t\4\2\2\u012c"+
		"\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2"+
		"\2\2\u012fB\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0135\t\5\2\2\u0132\u0134"+
		"\t\4\2\2\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136D\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013a\t\6\2\2"+
		"\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c"+
		"\3\2\2\2\u013cF\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u0140\t\6\2\2\u013f"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u0143\3\2\2\2\u0143\u0144\b$\2\2\u0144H\3\2\2\2\f\2\u00b3\u00d3"+
		"\u011d\u0123\u0128\u012e\u0135\u013b\u0141\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}