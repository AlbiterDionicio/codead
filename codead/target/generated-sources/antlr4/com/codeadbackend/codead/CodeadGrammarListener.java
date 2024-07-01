// Generated from com\codeadbackend\codead\CodeadGrammar.g4 by ANTLR 4.7.1
package com.codeadbackend.codead;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CodeadGrammarParser}.
 */
public interface CodeadGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CodeadGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CodeadGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(CodeadGrammarParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(CodeadGrammarParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(CodeadGrammarParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(CodeadGrammarParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#relationDecorators}.
	 * @param ctx the parse tree
	 */
	void enterRelationDecorators(CodeadGrammarParser.RelationDecoratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#relationDecorators}.
	 * @param ctx the parse tree
	 */
	void exitRelationDecorators(CodeadGrammarParser.RelationDecoratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(CodeadGrammarParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(CodeadGrammarParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#localDateField}.
	 * @param ctx the parse tree
	 */
	void enterLocalDateField(CodeadGrammarParser.LocalDateFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#localDateField}.
	 * @param ctx the parse tree
	 */
	void exitLocalDateField(CodeadGrammarParser.LocalDateFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#localDate}.
	 * @param ctx the parse tree
	 */
	void enterLocalDate(CodeadGrammarParser.LocalDateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#localDate}.
	 * @param ctx the parse tree
	 */
	void exitLocalDate(CodeadGrammarParser.LocalDateContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#localDateDecorators}.
	 * @param ctx the parse tree
	 */
	void enterLocalDateDecorators(CodeadGrammarParser.LocalDateDecoratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#localDateDecorators}.
	 * @param ctx the parse tree
	 */
	void exitLocalDateDecorators(CodeadGrammarParser.LocalDateDecoratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#stringField}.
	 * @param ctx the parse tree
	 */
	void enterStringField(CodeadGrammarParser.StringFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#stringField}.
	 * @param ctx the parse tree
	 */
	void exitStringField(CodeadGrammarParser.StringFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(CodeadGrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(CodeadGrammarParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#stringDecorators}.
	 * @param ctx the parse tree
	 */
	void enterStringDecorators(CodeadGrammarParser.StringDecoratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#stringDecorators}.
	 * @param ctx the parse tree
	 */
	void exitStringDecorators(CodeadGrammarParser.StringDecoratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#booleanField}.
	 * @param ctx the parse tree
	 */
	void enterBooleanField(CodeadGrammarParser.BooleanFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#booleanField}.
	 * @param ctx the parse tree
	 */
	void exitBooleanField(CodeadGrammarParser.BooleanFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#myboolean}.
	 * @param ctx the parse tree
	 */
	void enterMyboolean(CodeadGrammarParser.MybooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#myboolean}.
	 * @param ctx the parse tree
	 */
	void exitMyboolean(CodeadGrammarParser.MybooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#booleanDecorators}.
	 * @param ctx the parse tree
	 */
	void enterBooleanDecorators(CodeadGrammarParser.BooleanDecoratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#booleanDecorators}.
	 * @param ctx the parse tree
	 */
	void exitBooleanDecorators(CodeadGrammarParser.BooleanDecoratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#floatDoubleField}.
	 * @param ctx the parse tree
	 */
	void enterFloatDoubleField(CodeadGrammarParser.FloatDoubleFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#floatDoubleField}.
	 * @param ctx the parse tree
	 */
	void exitFloatDoubleField(CodeadGrammarParser.FloatDoubleFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#floatDouble}.
	 * @param ctx the parse tree
	 */
	void enterFloatDouble(CodeadGrammarParser.FloatDoubleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#floatDouble}.
	 * @param ctx the parse tree
	 */
	void exitFloatDouble(CodeadGrammarParser.FloatDoubleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#floatDoubleDecorators}.
	 * @param ctx the parse tree
	 */
	void enterFloatDoubleDecorators(CodeadGrammarParser.FloatDoubleDecoratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#floatDoubleDecorators}.
	 * @param ctx the parse tree
	 */
	void exitFloatDoubleDecorators(CodeadGrammarParser.FloatDoubleDecoratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#byteShortIntLongField}.
	 * @param ctx the parse tree
	 */
	void enterByteShortIntLongField(CodeadGrammarParser.ByteShortIntLongFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#byteShortIntLongField}.
	 * @param ctx the parse tree
	 */
	void exitByteShortIntLongField(CodeadGrammarParser.ByteShortIntLongFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#byteShortIntLong}.
	 * @param ctx the parse tree
	 */
	void enterByteShortIntLong(CodeadGrammarParser.ByteShortIntLongContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#byteShortIntLong}.
	 * @param ctx the parse tree
	 */
	void exitByteShortIntLong(CodeadGrammarParser.ByteShortIntLongContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#byteShortIntLongDecorators}.
	 * @param ctx the parse tree
	 */
	void enterByteShortIntLongDecorators(CodeadGrammarParser.ByteShortIntLongDecoratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#byteShortIntLongDecorators}.
	 * @param ctx the parse tree
	 */
	void exitByteShortIntLongDecorators(CodeadGrammarParser.ByteShortIntLongDecoratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#columnDecorators}.
	 * @param ctx the parse tree
	 */
	void enterColumnDecorators(CodeadGrammarParser.ColumnDecoratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#columnDecorators}.
	 * @param ctx the parse tree
	 */
	void exitColumnDecorators(CodeadGrammarParser.ColumnDecoratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#notBlankDecorator}.
	 * @param ctx the parse tree
	 */
	void enterNotBlankDecorator(CodeadGrammarParser.NotBlankDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#notBlankDecorator}.
	 * @param ctx the parse tree
	 */
	void exitNotBlankDecorator(CodeadGrammarParser.NotBlankDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#timeDecorator}.
	 * @param ctx the parse tree
	 */
	void enterTimeDecorator(CodeadGrammarParser.TimeDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#timeDecorator}.
	 * @param ctx the parse tree
	 */
	void exitTimeDecorator(CodeadGrammarParser.TimeDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#decimalDecorator}.
	 * @param ctx the parse tree
	 */
	void enterDecimalDecorator(CodeadGrammarParser.DecimalDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#decimalDecorator}.
	 * @param ctx the parse tree
	 */
	void exitDecimalDecorator(CodeadGrammarParser.DecimalDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#integerDecorator}.
	 * @param ctx the parse tree
	 */
	void enterIntegerDecorator(CodeadGrammarParser.IntegerDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#integerDecorator}.
	 * @param ctx the parse tree
	 */
	void exitIntegerDecorator(CodeadGrammarParser.IntegerDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#maxDecorator}.
	 * @param ctx the parse tree
	 */
	void enterMaxDecorator(CodeadGrammarParser.MaxDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#maxDecorator}.
	 * @param ctx the parse tree
	 */
	void exitMaxDecorator(CodeadGrammarParser.MaxDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#minDecorator}.
	 * @param ctx the parse tree
	 */
	void enterMinDecorator(CodeadGrammarParser.MinDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#minDecorator}.
	 * @param ctx the parse tree
	 */
	void exitMinDecorator(CodeadGrammarParser.MinDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#nullableDecorator}.
	 * @param ctx the parse tree
	 */
	void enterNullableDecorator(CodeadGrammarParser.NullableDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#nullableDecorator}.
	 * @param ctx the parse tree
	 */
	void exitNullableDecorator(CodeadGrammarParser.NullableDecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeadGrammarParser#uniqueDecorator}.
	 * @param ctx the parse tree
	 */
	void enterUniqueDecorator(CodeadGrammarParser.UniqueDecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeadGrammarParser#uniqueDecorator}.
	 * @param ctx the parse tree
	 */
	void exitUniqueDecorator(CodeadGrammarParser.UniqueDecoratorContext ctx);
}