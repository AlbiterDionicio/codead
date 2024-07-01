// Generated from com\codeadbackend\codead\CodeadGrammar.g4 by ANTLR 4.7.1
package com.codeadbackend.codead;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CodeadGrammarParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_column = 1, RULE_relation = 2, RULE_relationDecorators = 3, 
		RULE_field = 4, RULE_localDateField = 5, RULE_localDate = 6, RULE_localDateDecorators = 7, 
		RULE_stringField = 8, RULE_string = 9, RULE_stringDecorators = 10, RULE_booleanField = 11, 
		RULE_myboolean = 12, RULE_booleanDecorators = 13, RULE_floatDoubleField = 14, 
		RULE_floatDouble = 15, RULE_floatDoubleDecorators = 16, RULE_byteShortIntLongField = 17, 
		RULE_byteShortIntLong = 18, RULE_byteShortIntLongDecorators = 19, RULE_columnDecorators = 20, 
		RULE_notBlankDecorator = 21, RULE_timeDecorator = 22, RULE_decimalDecorator = 23, 
		RULE_integerDecorator = 24, RULE_maxDecorator = 25, RULE_minDecorator = 26, 
		RULE_nullableDecorator = 27, RULE_uniqueDecorator = 28;
	public static final String[] ruleNames = {
		"program", "column", "relation", "relationDecorators", "field", "localDateField", 
		"localDate", "localDateDecorators", "stringField", "string", "stringDecorators", 
		"booleanField", "myboolean", "booleanDecorators", "floatDoubleField", 
		"floatDouble", "floatDoubleDecorators", "byteShortIntLongField", "byteShortIntLong", 
		"byteShortIntLongDecorators", "columnDecorators", "notBlankDecorator", 
		"timeDecorator", "decimalDecorator", "integerDecorator", "maxDecorator", 
		"minDecorator", "nullableDecorator", "uniqueDecorator"
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

	@Override
	public String getGrammarFileName() { return "CodeadGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CodeadGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CodeadGrammarParser.EOF, 0); }
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				column();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT_BLANK_DECORATOR_OPEN) | (1L << NOT_BLANK_DECORATOR) | (1L << TIME_DECORATOR_OPEN) | (1L << TIME_DECORATOR) | (1L << DECIMAL_DECORATOR_OPEN) | (1L << DECIMAL_DECORATOR) | (1L << INTEGER_DECORATOR_OPEN) | (1L << INTEGER_DECORATOR) | (1L << MAX_DECORATOR_OPEN) | (1L << MAX_DECORATOR) | (1L << MIN_DECORATOR_OPEN) | (1L << MIN_DECORATOR) | (1L << NULLABLE_DECORATOR_OPEN) | (1L << NULLABLE_DECORATOR) | (1L << UNIQUE_DECORATOR_OPEN) | (1L << UNIQUE_DECORATOR) | (1L << BYTE_KEY) | (1L << SHORT_KEY) | (1L << INT_KEY) | (1L << LONG_KEY) | (1L << FLOAT_KEY) | (1L << DOUBLE_KEY) | (1L << BOOLEAN_KEY) | (1L << STRING_KEY) | (1L << LOCAL_DATE_KEY) | (1L << ID_PASCAL_CASE))) != 0) );
			setState(63);
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

	public static class ColumnContext extends ParserRuleContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitColumn(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_column);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				relation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				field();
				}
				break;
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

	public static class RelationContext extends ParserRuleContext {
		public TerminalNode ID_PASCAL_CASE() { return getToken(CodeadGrammarParser.ID_PASCAL_CASE, 0); }
		public TerminalNode ID_CAMEL_CASE() { return getToken(CodeadGrammarParser.ID_CAMEL_CASE, 0); }
		public List<RelationDecoratorsContext> relationDecorators() {
			return getRuleContexts(RelationDecoratorsContext.class);
		}
		public RelationDecoratorsContext relationDecorators(int i) {
			return getRuleContext(RelationDecoratorsContext.class,i);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitRelation(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULLABLE_DECORATOR_OPEN) | (1L << NULLABLE_DECORATOR) | (1L << UNIQUE_DECORATOR_OPEN) | (1L << UNIQUE_DECORATOR))) != 0)) {
				{
				{
				setState(69);
				relationDecorators();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(ID_PASCAL_CASE);
			setState(76);
			match(ID_CAMEL_CASE);
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

	public static class RelationDecoratorsContext extends ParserRuleContext {
		public ColumnDecoratorsContext columnDecorators() {
			return getRuleContext(ColumnDecoratorsContext.class,0);
		}
		public RelationDecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationDecorators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterRelationDecorators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitRelationDecorators(this);
		}
	}

	public final RelationDecoratorsContext relationDecorators() throws RecognitionException {
		RelationDecoratorsContext _localctx = new RelationDecoratorsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_relationDecorators);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			columnDecorators();
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

	public static class FieldContext extends ParserRuleContext {
		public LocalDateFieldContext localDateField() {
			return getRuleContext(LocalDateFieldContext.class,0);
		}
		public StringFieldContext stringField() {
			return getRuleContext(StringFieldContext.class,0);
		}
		public BooleanFieldContext booleanField() {
			return getRuleContext(BooleanFieldContext.class,0);
		}
		public FloatDoubleFieldContext floatDoubleField() {
			return getRuleContext(FloatDoubleFieldContext.class,0);
		}
		public ByteShortIntLongFieldContext byteShortIntLongField() {
			return getRuleContext(ByteShortIntLongFieldContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_field);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				localDateField();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				stringField();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				booleanField();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				floatDoubleField();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				byteShortIntLongField();
				}
				break;
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

	public static class LocalDateFieldContext extends ParserRuleContext {
		public LocalDateContext localDate() {
			return getRuleContext(LocalDateContext.class,0);
		}
		public TerminalNode ID_CAMEL_CASE() { return getToken(CodeadGrammarParser.ID_CAMEL_CASE, 0); }
		public List<LocalDateDecoratorsContext> localDateDecorators() {
			return getRuleContexts(LocalDateDecoratorsContext.class);
		}
		public LocalDateDecoratorsContext localDateDecorators(int i) {
			return getRuleContext(LocalDateDecoratorsContext.class,i);
		}
		public LocalDateFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDateField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterLocalDateField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitLocalDateField(this);
		}
	}

	public final LocalDateFieldContext localDateField() throws RecognitionException {
		LocalDateFieldContext _localctx = new LocalDateFieldContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_localDateField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIME_DECORATOR_OPEN) | (1L << TIME_DECORATOR) | (1L << NULLABLE_DECORATOR_OPEN) | (1L << NULLABLE_DECORATOR) | (1L << UNIQUE_DECORATOR_OPEN) | (1L << UNIQUE_DECORATOR))) != 0)) {
				{
				{
				setState(87);
				localDateDecorators();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			localDate();
			setState(94);
			match(ID_CAMEL_CASE);
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

	public static class LocalDateContext extends ParserRuleContext {
		public TerminalNode LOCAL_DATE_KEY() { return getToken(CodeadGrammarParser.LOCAL_DATE_KEY, 0); }
		public LocalDateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterLocalDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitLocalDate(this);
		}
	}

	public final LocalDateContext localDate() throws RecognitionException {
		LocalDateContext _localctx = new LocalDateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_localDate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(LOCAL_DATE_KEY);
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

	public static class LocalDateDecoratorsContext extends ParserRuleContext {
		public ColumnDecoratorsContext columnDecorators() {
			return getRuleContext(ColumnDecoratorsContext.class,0);
		}
		public TimeDecoratorContext timeDecorator() {
			return getRuleContext(TimeDecoratorContext.class,0);
		}
		public LocalDateDecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDateDecorators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterLocalDateDecorators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitLocalDateDecorators(this);
		}
	}

	public final LocalDateDecoratorsContext localDateDecorators() throws RecognitionException {
		LocalDateDecoratorsContext _localctx = new LocalDateDecoratorsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_localDateDecorators);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULLABLE_DECORATOR_OPEN:
			case NULLABLE_DECORATOR:
			case UNIQUE_DECORATOR_OPEN:
			case UNIQUE_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				columnDecorators();
				}
				break;
			case TIME_DECORATOR_OPEN:
			case TIME_DECORATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				timeDecorator();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StringFieldContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode ID_CAMEL_CASE() { return getToken(CodeadGrammarParser.ID_CAMEL_CASE, 0); }
		public List<StringDecoratorsContext> stringDecorators() {
			return getRuleContexts(StringDecoratorsContext.class);
		}
		public StringDecoratorsContext stringDecorators(int i) {
			return getRuleContext(StringDecoratorsContext.class,i);
		}
		public StringFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterStringField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitStringField(this);
		}
	}

	public final StringFieldContext stringField() throws RecognitionException {
		StringFieldContext _localctx = new StringFieldContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stringField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT_BLANK_DECORATOR_OPEN) | (1L << NOT_BLANK_DECORATOR) | (1L << MAX_DECORATOR_OPEN) | (1L << MAX_DECORATOR) | (1L << MIN_DECORATOR_OPEN) | (1L << MIN_DECORATOR) | (1L << NULLABLE_DECORATOR_OPEN) | (1L << NULLABLE_DECORATOR) | (1L << UNIQUE_DECORATOR_OPEN) | (1L << UNIQUE_DECORATOR))) != 0)) {
				{
				{
				setState(102);
				stringDecorators();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			string();
			setState(109);
			match(ID_CAMEL_CASE);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING_KEY() { return getToken(CodeadGrammarParser.STRING_KEY, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(STRING_KEY);
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

	public static class StringDecoratorsContext extends ParserRuleContext {
		public ColumnDecoratorsContext columnDecorators() {
			return getRuleContext(ColumnDecoratorsContext.class,0);
		}
		public MinDecoratorContext minDecorator() {
			return getRuleContext(MinDecoratorContext.class,0);
		}
		public MaxDecoratorContext maxDecorator() {
			return getRuleContext(MaxDecoratorContext.class,0);
		}
		public NotBlankDecoratorContext notBlankDecorator() {
			return getRuleContext(NotBlankDecoratorContext.class,0);
		}
		public StringDecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringDecorators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterStringDecorators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitStringDecorators(this);
		}
	}

	public final StringDecoratorsContext stringDecorators() throws RecognitionException {
		StringDecoratorsContext _localctx = new StringDecoratorsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stringDecorators);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULLABLE_DECORATOR_OPEN:
			case NULLABLE_DECORATOR:
			case UNIQUE_DECORATOR_OPEN:
			case UNIQUE_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				columnDecorators();
				}
				break;
			case MIN_DECORATOR_OPEN:
			case MIN_DECORATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				minDecorator();
				}
				break;
			case MAX_DECORATOR_OPEN:
			case MAX_DECORATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				maxDecorator();
				}
				break;
			case NOT_BLANK_DECORATOR_OPEN:
			case NOT_BLANK_DECORATOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(116);
				notBlankDecorator();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BooleanFieldContext extends ParserRuleContext {
		public MybooleanContext myboolean() {
			return getRuleContext(MybooleanContext.class,0);
		}
		public TerminalNode ID_CAMEL_CASE() { return getToken(CodeadGrammarParser.ID_CAMEL_CASE, 0); }
		public List<BooleanDecoratorsContext> booleanDecorators() {
			return getRuleContexts(BooleanDecoratorsContext.class);
		}
		public BooleanDecoratorsContext booleanDecorators(int i) {
			return getRuleContext(BooleanDecoratorsContext.class,i);
		}
		public BooleanFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterBooleanField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitBooleanField(this);
		}
	}

	public final BooleanFieldContext booleanField() throws RecognitionException {
		BooleanFieldContext _localctx = new BooleanFieldContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_booleanField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULLABLE_DECORATOR_OPEN) | (1L << NULLABLE_DECORATOR) | (1L << UNIQUE_DECORATOR_OPEN) | (1L << UNIQUE_DECORATOR))) != 0)) {
				{
				{
				setState(119);
				booleanDecorators();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			myboolean();
			setState(126);
			match(ID_CAMEL_CASE);
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

	public static class MybooleanContext extends ParserRuleContext {
		public TerminalNode BOOLEAN_KEY() { return getToken(CodeadGrammarParser.BOOLEAN_KEY, 0); }
		public MybooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myboolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterMyboolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitMyboolean(this);
		}
	}

	public final MybooleanContext myboolean() throws RecognitionException {
		MybooleanContext _localctx = new MybooleanContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_myboolean);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(BOOLEAN_KEY);
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

	public static class BooleanDecoratorsContext extends ParserRuleContext {
		public ColumnDecoratorsContext columnDecorators() {
			return getRuleContext(ColumnDecoratorsContext.class,0);
		}
		public BooleanDecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanDecorators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterBooleanDecorators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitBooleanDecorators(this);
		}
	}

	public final BooleanDecoratorsContext booleanDecorators() throws RecognitionException {
		BooleanDecoratorsContext _localctx = new BooleanDecoratorsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_booleanDecorators);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			columnDecorators();
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

	public static class FloatDoubleFieldContext extends ParserRuleContext {
		public FloatDoubleContext floatDouble() {
			return getRuleContext(FloatDoubleContext.class,0);
		}
		public TerminalNode ID_CAMEL_CASE() { return getToken(CodeadGrammarParser.ID_CAMEL_CASE, 0); }
		public List<FloatDoubleDecoratorsContext> floatDoubleDecorators() {
			return getRuleContexts(FloatDoubleDecoratorsContext.class);
		}
		public FloatDoubleDecoratorsContext floatDoubleDecorators(int i) {
			return getRuleContext(FloatDoubleDecoratorsContext.class,i);
		}
		public FloatDoubleFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatDoubleField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterFloatDoubleField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitFloatDoubleField(this);
		}
	}

	public final FloatDoubleFieldContext floatDoubleField() throws RecognitionException {
		FloatDoubleFieldContext _localctx = new FloatDoubleFieldContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_floatDoubleField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECIMAL_DECORATOR_OPEN) | (1L << DECIMAL_DECORATOR) | (1L << INTEGER_DECORATOR_OPEN) | (1L << INTEGER_DECORATOR) | (1L << MAX_DECORATOR_OPEN) | (1L << MAX_DECORATOR) | (1L << MIN_DECORATOR_OPEN) | (1L << MIN_DECORATOR) | (1L << NULLABLE_DECORATOR_OPEN) | (1L << NULLABLE_DECORATOR) | (1L << UNIQUE_DECORATOR_OPEN) | (1L << UNIQUE_DECORATOR))) != 0)) {
				{
				{
				setState(132);
				floatDoubleDecorators();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138);
			floatDouble();
			setState(139);
			match(ID_CAMEL_CASE);
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

	public static class FloatDoubleContext extends ParserRuleContext {
		public TerminalNode FLOAT_KEY() { return getToken(CodeadGrammarParser.FLOAT_KEY, 0); }
		public TerminalNode DOUBLE_KEY() { return getToken(CodeadGrammarParser.DOUBLE_KEY, 0); }
		public FloatDoubleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatDouble; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterFloatDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitFloatDouble(this);
		}
	}

	public final FloatDoubleContext floatDouble() throws RecognitionException {
		FloatDoubleContext _localctx = new FloatDoubleContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_floatDouble);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_la = _input.LA(1);
			if ( !(_la==FLOAT_KEY || _la==DOUBLE_KEY) ) {
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

	public static class FloatDoubleDecoratorsContext extends ParserRuleContext {
		public ColumnDecoratorsContext columnDecorators() {
			return getRuleContext(ColumnDecoratorsContext.class,0);
		}
		public MinDecoratorContext minDecorator() {
			return getRuleContext(MinDecoratorContext.class,0);
		}
		public MaxDecoratorContext maxDecorator() {
			return getRuleContext(MaxDecoratorContext.class,0);
		}
		public IntegerDecoratorContext integerDecorator() {
			return getRuleContext(IntegerDecoratorContext.class,0);
		}
		public DecimalDecoratorContext decimalDecorator() {
			return getRuleContext(DecimalDecoratorContext.class,0);
		}
		public FloatDoubleDecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatDoubleDecorators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterFloatDoubleDecorators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitFloatDoubleDecorators(this);
		}
	}

	public final FloatDoubleDecoratorsContext floatDoubleDecorators() throws RecognitionException {
		FloatDoubleDecoratorsContext _localctx = new FloatDoubleDecoratorsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_floatDoubleDecorators);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULLABLE_DECORATOR_OPEN:
			case NULLABLE_DECORATOR:
			case UNIQUE_DECORATOR_OPEN:
			case UNIQUE_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				columnDecorators();
				}
				break;
			case MIN_DECORATOR_OPEN:
			case MIN_DECORATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				minDecorator();
				}
				break;
			case MAX_DECORATOR_OPEN:
			case MAX_DECORATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				maxDecorator();
				}
				break;
			case INTEGER_DECORATOR_OPEN:
			case INTEGER_DECORATOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				integerDecorator();
				}
				break;
			case DECIMAL_DECORATOR_OPEN:
			case DECIMAL_DECORATOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				decimalDecorator();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ByteShortIntLongFieldContext extends ParserRuleContext {
		public ByteShortIntLongContext byteShortIntLong() {
			return getRuleContext(ByteShortIntLongContext.class,0);
		}
		public TerminalNode ID_CAMEL_CASE() { return getToken(CodeadGrammarParser.ID_CAMEL_CASE, 0); }
		public List<ByteShortIntLongDecoratorsContext> byteShortIntLongDecorators() {
			return getRuleContexts(ByteShortIntLongDecoratorsContext.class);
		}
		public ByteShortIntLongDecoratorsContext byteShortIntLongDecorators(int i) {
			return getRuleContext(ByteShortIntLongDecoratorsContext.class,i);
		}
		public ByteShortIntLongFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_byteShortIntLongField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterByteShortIntLongField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitByteShortIntLongField(this);
		}
	}

	public final ByteShortIntLongFieldContext byteShortIntLongField() throws RecognitionException {
		ByteShortIntLongFieldContext _localctx = new ByteShortIntLongFieldContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_byteShortIntLongField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MAX_DECORATOR_OPEN) | (1L << MAX_DECORATOR) | (1L << MIN_DECORATOR_OPEN) | (1L << MIN_DECORATOR) | (1L << NULLABLE_DECORATOR_OPEN) | (1L << NULLABLE_DECORATOR) | (1L << UNIQUE_DECORATOR_OPEN) | (1L << UNIQUE_DECORATOR))) != 0)) {
				{
				{
				setState(150);
				byteShortIntLongDecorators();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			byteShortIntLong();
			setState(157);
			match(ID_CAMEL_CASE);
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

	public static class ByteShortIntLongContext extends ParserRuleContext {
		public TerminalNode BYTE_KEY() { return getToken(CodeadGrammarParser.BYTE_KEY, 0); }
		public TerminalNode SHORT_KEY() { return getToken(CodeadGrammarParser.SHORT_KEY, 0); }
		public TerminalNode INT_KEY() { return getToken(CodeadGrammarParser.INT_KEY, 0); }
		public TerminalNode LONG_KEY() { return getToken(CodeadGrammarParser.LONG_KEY, 0); }
		public ByteShortIntLongContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_byteShortIntLong; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterByteShortIntLong(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitByteShortIntLong(this);
		}
	}

	public final ByteShortIntLongContext byteShortIntLong() throws RecognitionException {
		ByteShortIntLongContext _localctx = new ByteShortIntLongContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_byteShortIntLong);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYTE_KEY) | (1L << SHORT_KEY) | (1L << INT_KEY) | (1L << LONG_KEY))) != 0)) ) {
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

	public static class ByteShortIntLongDecoratorsContext extends ParserRuleContext {
		public ColumnDecoratorsContext columnDecorators() {
			return getRuleContext(ColumnDecoratorsContext.class,0);
		}
		public MinDecoratorContext minDecorator() {
			return getRuleContext(MinDecoratorContext.class,0);
		}
		public MaxDecoratorContext maxDecorator() {
			return getRuleContext(MaxDecoratorContext.class,0);
		}
		public ByteShortIntLongDecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_byteShortIntLongDecorators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterByteShortIntLongDecorators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitByteShortIntLongDecorators(this);
		}
	}

	public final ByteShortIntLongDecoratorsContext byteShortIntLongDecorators() throws RecognitionException {
		ByteShortIntLongDecoratorsContext _localctx = new ByteShortIntLongDecoratorsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_byteShortIntLongDecorators);
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULLABLE_DECORATOR_OPEN:
			case NULLABLE_DECORATOR:
			case UNIQUE_DECORATOR_OPEN:
			case UNIQUE_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				columnDecorators();
				}
				break;
			case MIN_DECORATOR_OPEN:
			case MIN_DECORATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				minDecorator();
				}
				break;
			case MAX_DECORATOR_OPEN:
			case MAX_DECORATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				maxDecorator();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ColumnDecoratorsContext extends ParserRuleContext {
		public NullableDecoratorContext nullableDecorator() {
			return getRuleContext(NullableDecoratorContext.class,0);
		}
		public UniqueDecoratorContext uniqueDecorator() {
			return getRuleContext(UniqueDecoratorContext.class,0);
		}
		public ColumnDecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDecorators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterColumnDecorators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitColumnDecorators(this);
		}
	}

	public final ColumnDecoratorsContext columnDecorators() throws RecognitionException {
		ColumnDecoratorsContext _localctx = new ColumnDecoratorsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_columnDecorators);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULLABLE_DECORATOR_OPEN:
			case NULLABLE_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				nullableDecorator();
				}
				break;
			case UNIQUE_DECORATOR_OPEN:
			case UNIQUE_DECORATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				uniqueDecorator();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class NotBlankDecoratorContext extends ParserRuleContext {
		public TerminalNode NOT_BLANK_DECORATOR() { return getToken(CodeadGrammarParser.NOT_BLANK_DECORATOR, 0); }
		public TerminalNode NOT_BLANK_DECORATOR_OPEN() { return getToken(CodeadGrammarParser.NOT_BLANK_DECORATOR_OPEN, 0); }
		public TerminalNode BOOLEAN() { return getToken(CodeadGrammarParser.BOOLEAN, 0); }
		public TerminalNode DECORATOR_CLOSE() { return getToken(CodeadGrammarParser.DECORATOR_CLOSE, 0); }
		public NotBlankDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notBlankDecorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterNotBlankDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitNotBlankDecorator(this);
		}
	}

	public final NotBlankDecoratorContext notBlankDecorator() throws RecognitionException {
		NotBlankDecoratorContext _localctx = new NotBlankDecoratorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_notBlankDecorator);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT_BLANK_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(NOT_BLANK_DECORATOR);
				}
				break;
			case NOT_BLANK_DECORATOR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(NOT_BLANK_DECORATOR_OPEN);
				setState(172);
				match(BOOLEAN);
				setState(173);
				match(DECORATOR_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TimeDecoratorContext extends ParserRuleContext {
		public TerminalNode TIME_DECORATOR() { return getToken(CodeadGrammarParser.TIME_DECORATOR, 0); }
		public TerminalNode TIME_DECORATOR_OPEN() { return getToken(CodeadGrammarParser.TIME_DECORATOR_OPEN, 0); }
		public TerminalNode TIME() { return getToken(CodeadGrammarParser.TIME, 0); }
		public TerminalNode DECORATOR_CLOSE() { return getToken(CodeadGrammarParser.DECORATOR_CLOSE, 0); }
		public TimeDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeDecorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterTimeDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitTimeDecorator(this);
		}
	}

	public final TimeDecoratorContext timeDecorator() throws RecognitionException {
		TimeDecoratorContext _localctx = new TimeDecoratorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_timeDecorator);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIME_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(TIME_DECORATOR);
				}
				break;
			case TIME_DECORATOR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(TIME_DECORATOR_OPEN);
				setState(178);
				match(TIME);
				setState(179);
				match(DECORATOR_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DecimalDecoratorContext extends ParserRuleContext {
		public TerminalNode DECIMAL_DECORATOR() { return getToken(CodeadGrammarParser.DECIMAL_DECORATOR, 0); }
		public TerminalNode DECIMAL_DECORATOR_OPEN() { return getToken(CodeadGrammarParser.DECIMAL_DECORATOR_OPEN, 0); }
		public TerminalNode NATURAL_NUMBER() { return getToken(CodeadGrammarParser.NATURAL_NUMBER, 0); }
		public TerminalNode DECORATOR_CLOSE() { return getToken(CodeadGrammarParser.DECORATOR_CLOSE, 0); }
		public DecimalDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalDecorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterDecimalDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitDecimalDecorator(this);
		}
	}

	public final DecimalDecoratorContext decimalDecorator() throws RecognitionException {
		DecimalDecoratorContext _localctx = new DecimalDecoratorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_decimalDecorator);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(DECIMAL_DECORATOR);
				}
				break;
			case DECIMAL_DECORATOR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(DECIMAL_DECORATOR_OPEN);
				setState(184);
				match(NATURAL_NUMBER);
				setState(185);
				match(DECORATOR_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class IntegerDecoratorContext extends ParserRuleContext {
		public TerminalNode INTEGER_DECORATOR() { return getToken(CodeadGrammarParser.INTEGER_DECORATOR, 0); }
		public TerminalNode INTEGER_DECORATOR_OPEN() { return getToken(CodeadGrammarParser.INTEGER_DECORATOR_OPEN, 0); }
		public TerminalNode NATURAL_NUMBER() { return getToken(CodeadGrammarParser.NATURAL_NUMBER, 0); }
		public TerminalNode DECORATOR_CLOSE() { return getToken(CodeadGrammarParser.DECORATOR_CLOSE, 0); }
		public IntegerDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerDecorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterIntegerDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitIntegerDecorator(this);
		}
	}

	public final IntegerDecoratorContext integerDecorator() throws RecognitionException {
		IntegerDecoratorContext _localctx = new IntegerDecoratorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_integerDecorator);
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(INTEGER_DECORATOR);
				}
				break;
			case INTEGER_DECORATOR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(INTEGER_DECORATOR_OPEN);
				setState(190);
				match(NATURAL_NUMBER);
				setState(191);
				match(DECORATOR_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class MaxDecoratorContext extends ParserRuleContext {
		public TerminalNode MAX_DECORATOR() { return getToken(CodeadGrammarParser.MAX_DECORATOR, 0); }
		public TerminalNode MAX_DECORATOR_OPEN() { return getToken(CodeadGrammarParser.MAX_DECORATOR_OPEN, 0); }
		public TerminalNode DECORATOR_CLOSE() { return getToken(CodeadGrammarParser.DECORATOR_CLOSE, 0); }
		public TerminalNode NATURAL_NUMBER() { return getToken(CodeadGrammarParser.NATURAL_NUMBER, 0); }
		public TerminalNode INTEGER_NUMBER() { return getToken(CodeadGrammarParser.INTEGER_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(CodeadGrammarParser.DECIMAL_NUMBER, 0); }
		public MaxDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxDecorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterMaxDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitMaxDecorator(this);
		}
	}

	public final MaxDecoratorContext maxDecorator() throws RecognitionException {
		MaxDecoratorContext _localctx = new MaxDecoratorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_maxDecorator);
		int _la;
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAX_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(MAX_DECORATOR);
				}
				break;
			case MAX_DECORATOR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(MAX_DECORATOR_OPEN);
				setState(196);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECIMAL_NUMBER) | (1L << INTEGER_NUMBER) | (1L << NATURAL_NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(197);
				match(DECORATOR_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class MinDecoratorContext extends ParserRuleContext {
		public TerminalNode MIN_DECORATOR() { return getToken(CodeadGrammarParser.MIN_DECORATOR, 0); }
		public TerminalNode MIN_DECORATOR_OPEN() { return getToken(CodeadGrammarParser.MIN_DECORATOR_OPEN, 0); }
		public TerminalNode DECORATOR_CLOSE() { return getToken(CodeadGrammarParser.DECORATOR_CLOSE, 0); }
		public TerminalNode NATURAL_NUMBER() { return getToken(CodeadGrammarParser.NATURAL_NUMBER, 0); }
		public TerminalNode INTEGER_NUMBER() { return getToken(CodeadGrammarParser.INTEGER_NUMBER, 0); }
		public TerminalNode DECIMAL_NUMBER() { return getToken(CodeadGrammarParser.DECIMAL_NUMBER, 0); }
		public MinDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minDecorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterMinDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitMinDecorator(this);
		}
	}

	public final MinDecoratorContext minDecorator() throws RecognitionException {
		MinDecoratorContext _localctx = new MinDecoratorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_minDecorator);
		int _la;
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MIN_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(MIN_DECORATOR);
				}
				break;
			case MIN_DECORATOR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(MIN_DECORATOR_OPEN);
				setState(202);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECIMAL_NUMBER) | (1L << INTEGER_NUMBER) | (1L << NATURAL_NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(203);
				match(DECORATOR_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class NullableDecoratorContext extends ParserRuleContext {
		public TerminalNode NULLABLE_DECORATOR() { return getToken(CodeadGrammarParser.NULLABLE_DECORATOR, 0); }
		public TerminalNode NULLABLE_DECORATOR_OPEN() { return getToken(CodeadGrammarParser.NULLABLE_DECORATOR_OPEN, 0); }
		public TerminalNode BOOLEAN() { return getToken(CodeadGrammarParser.BOOLEAN, 0); }
		public TerminalNode DECORATOR_CLOSE() { return getToken(CodeadGrammarParser.DECORATOR_CLOSE, 0); }
		public NullableDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullableDecorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterNullableDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitNullableDecorator(this);
		}
	}

	public final NullableDecoratorContext nullableDecorator() throws RecognitionException {
		NullableDecoratorContext _localctx = new NullableDecoratorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_nullableDecorator);
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULLABLE_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				match(NULLABLE_DECORATOR);
				}
				break;
			case NULLABLE_DECORATOR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(NULLABLE_DECORATOR_OPEN);
				setState(208);
				match(BOOLEAN);
				setState(209);
				match(DECORATOR_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class UniqueDecoratorContext extends ParserRuleContext {
		public TerminalNode UNIQUE_DECORATOR() { return getToken(CodeadGrammarParser.UNIQUE_DECORATOR, 0); }
		public TerminalNode UNIQUE_DECORATOR_OPEN() { return getToken(CodeadGrammarParser.UNIQUE_DECORATOR_OPEN, 0); }
		public TerminalNode BOOLEAN() { return getToken(CodeadGrammarParser.BOOLEAN, 0); }
		public TerminalNode DECORATOR_CLOSE() { return getToken(CodeadGrammarParser.DECORATOR_CLOSE, 0); }
		public UniqueDecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniqueDecorator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).enterUniqueDecorator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodeadGrammarListener ) ((CodeadGrammarListener)listener).exitUniqueDecorator(this);
		}
	}

	public final UniqueDecoratorContext uniqueDecorator() throws RecognitionException {
		UniqueDecoratorContext _localctx = new UniqueDecoratorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_uniqueDecorator);
		try {
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNIQUE_DECORATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(UNIQUE_DECORATOR);
				}
				break;
			case UNIQUE_DECORATOR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(UNIQUE_DECORATOR_OPEN);
				setState(214);
				match(BOOLEAN);
				setState(215);
				match(DECORATOR_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00dd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\6\2>\n\2\r\2\16"+
		"\2?\3\2\3\2\3\3\3\3\5\3F\n\3\3\4\7\4I\n\4\f\4\16\4L\13\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6X\n\6\3\7\7\7[\n\7\f\7\16\7^\13\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\5\tg\n\t\3\n\7\nj\n\n\f\n\16\nm\13\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\f\3\f\5\fx\n\f\3\r\7\r{\n\r\f\r\16\r~\13\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\7\20\u0088\n\20\f\20\16\20\u008b\13"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u0097\n\22"+
		"\3\23\7\23\u009a\n\23\f\23\16\23\u009d\13\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\5\25\u00a7\n\25\3\26\3\26\5\26\u00ab\n\26\3\27\3\27\3"+
		"\27\3\27\5\27\u00b1\n\27\3\30\3\30\3\30\3\30\5\30\u00b7\n\30\3\31\3\31"+
		"\3\31\3\31\5\31\u00bd\n\31\3\32\3\32\3\32\3\32\5\32\u00c3\n\32\3\33\3"+
		"\33\3\33\3\33\5\33\u00c9\n\33\3\34\3\34\3\34\3\34\5\34\u00cf\n\34\3\35"+
		"\3\35\3\35\3\35\5\35\u00d5\n\35\3\36\3\36\3\36\3\36\5\36\u00db\n\36\3"+
		"\36\2\2\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:\2\5\3\2\32\33\3\2\26\31\3\2\37!\2\u00de\2=\3\2\2\2\4E\3\2\2\2\6J\3"+
		"\2\2\2\bP\3\2\2\2\nW\3\2\2\2\f\\\3\2\2\2\16b\3\2\2\2\20f\3\2\2\2\22k\3"+
		"\2\2\2\24q\3\2\2\2\26w\3\2\2\2\30|\3\2\2\2\32\u0082\3\2\2\2\34\u0084\3"+
		"\2\2\2\36\u0089\3\2\2\2 \u008f\3\2\2\2\"\u0096\3\2\2\2$\u009b\3\2\2\2"+
		"&\u00a1\3\2\2\2(\u00a6\3\2\2\2*\u00aa\3\2\2\2,\u00b0\3\2\2\2.\u00b6\3"+
		"\2\2\2\60\u00bc\3\2\2\2\62\u00c2\3\2\2\2\64\u00c8\3\2\2\2\66\u00ce\3\2"+
		"\2\28\u00d4\3\2\2\2:\u00da\3\2\2\2<>\5\4\3\2=<\3\2\2\2>?\3\2\2\2?=\3\2"+
		"\2\2?@\3\2\2\2@A\3\2\2\2AB\7\2\2\3B\3\3\2\2\2CF\5\6\4\2DF\5\n\6\2EC\3"+
		"\2\2\2ED\3\2\2\2F\5\3\2\2\2GI\5\b\5\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK"+
		"\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7#\2\2NO\7\"\2\2O\7\3\2\2\2PQ\5*\26\2Q"+
		"\t\3\2\2\2RX\5\f\7\2SX\5\22\n\2TX\5\30\r\2UX\5\36\20\2VX\5$\23\2WR\3\2"+
		"\2\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\13\3\2\2\2Y[\5\20\t\2ZY"+
		"\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\5\16\b"+
		"\2`a\7\"\2\2a\r\3\2\2\2bc\7\36\2\2c\17\3\2\2\2dg\5*\26\2eg\5.\30\2fd\3"+
		"\2\2\2fe\3\2\2\2g\21\3\2\2\2hj\5\26\f\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2"+
		"kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\5\24\13\2op\7\"\2\2p\23\3\2\2\2qr\7\35"+
		"\2\2r\25\3\2\2\2sx\5*\26\2tx\5\66\34\2ux\5\64\33\2vx\5,\27\2ws\3\2\2\2"+
		"wt\3\2\2\2wu\3\2\2\2wv\3\2\2\2x\27\3\2\2\2y{\5\34\17\2zy\3\2\2\2{~\3\2"+
		"\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\5\32\16\2\u0080"+
		"\u0081\7\"\2\2\u0081\31\3\2\2\2\u0082\u0083\7\34\2\2\u0083\33\3\2\2\2"+
		"\u0084\u0085\5*\26\2\u0085\35\3\2\2\2\u0086\u0088\5\"\22\2\u0087\u0086"+
		"\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\5 \21\2\u008d\u008e\7\""+
		"\2\2\u008e\37\3\2\2\2\u008f\u0090\t\2\2\2\u0090!\3\2\2\2\u0091\u0097\5"+
		"*\26\2\u0092\u0097\5\66\34\2\u0093\u0097\5\64\33\2\u0094\u0097\5\62\32"+
		"\2\u0095\u0097\5\60\31\2\u0096\u0091\3\2\2\2\u0096\u0092\3\2\2\2\u0096"+
		"\u0093\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097#\3\2\2\2"+
		"\u0098\u009a\5(\25\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u009f\5&\24\2\u009f\u00a0\7\"\2\2\u00a0%\3\2\2\2\u00a1\u00a2\t\3\2\2"+
		"\u00a2\'\3\2\2\2\u00a3\u00a7\5*\26\2\u00a4\u00a7\5\66\34\2\u00a5\u00a7"+
		"\5\64\33\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2"+
		"\u00a7)\3\2\2\2\u00a8\u00ab\58\35\2\u00a9\u00ab\5:\36\2\u00aa\u00a8\3"+
		"\2\2\2\u00aa\u00a9\3\2\2\2\u00ab+\3\2\2\2\u00ac\u00b1\7\4\2\2\u00ad\u00ae"+
		"\7\3\2\2\u00ae\u00af\7\24\2\2\u00af\u00b1\7\23\2\2\u00b0\u00ac\3\2\2\2"+
		"\u00b0\u00ad\3\2\2\2\u00b1-\3\2\2\2\u00b2\u00b7\7\6\2\2\u00b3\u00b4\7"+
		"\5\2\2\u00b4\u00b5\7\25\2\2\u00b5\u00b7\7\23\2\2\u00b6\u00b2\3\2\2\2\u00b6"+
		"\u00b3\3\2\2\2\u00b7/\3\2\2\2\u00b8\u00bd\7\b\2\2\u00b9\u00ba\7\7\2\2"+
		"\u00ba\u00bb\7!\2\2\u00bb\u00bd\7\23\2\2\u00bc\u00b8\3\2\2\2\u00bc\u00b9"+
		"\3\2\2\2\u00bd\61\3\2\2\2\u00be\u00c3\7\n\2\2\u00bf\u00c0\7\t\2\2\u00c0"+
		"\u00c1\7!\2\2\u00c1\u00c3\7\23\2\2\u00c2\u00be\3\2\2\2\u00c2\u00bf\3\2"+
		"\2\2\u00c3\63\3\2\2\2\u00c4\u00c9\7\f\2\2\u00c5\u00c6\7\13\2\2\u00c6\u00c7"+
		"\t\4\2\2\u00c7\u00c9\7\23\2\2\u00c8\u00c4\3\2\2\2\u00c8\u00c5\3\2\2\2"+
		"\u00c9\65\3\2\2\2\u00ca\u00cf\7\16\2\2\u00cb\u00cc\7\r\2\2\u00cc\u00cd"+
		"\t\4\2\2\u00cd\u00cf\7\23\2\2\u00ce\u00ca\3\2\2\2\u00ce\u00cb\3\2\2\2"+
		"\u00cf\67\3\2\2\2\u00d0\u00d5\7\20\2\2\u00d1\u00d2\7\17\2\2\u00d2\u00d3"+
		"\7\24\2\2\u00d3\u00d5\7\23\2\2\u00d4\u00d0\3\2\2\2\u00d4\u00d1\3\2\2\2"+
		"\u00d59\3\2\2\2\u00d6\u00db\7\22\2\2\u00d7\u00d8\7\21\2\2\u00d8\u00d9"+
		"\7\24\2\2\u00d9\u00db\7\23\2\2\u00da\u00d6\3\2\2\2\u00da\u00d7\3\2\2\2"+
		"\u00db;\3\2\2\2\30?EJW\\fkw|\u0089\u0096\u009b\u00a6\u00aa\u00b0\u00b6"+
		"\u00bc\u00c2\u00c8\u00ce\u00d4\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}