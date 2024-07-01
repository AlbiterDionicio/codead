/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.codeadbackend.codead.CodeadGrammarLexer;
import com.codeadbackend.codead.CodeadGrammarParser;
import com.codeadbackend.codead.CodeadGrammarParser.BooleanFieldContext;
import com.codeadbackend.codead.CodeadGrammarParser.ByteShortIntLongFieldContext;
import com.codeadbackend.codead.CodeadGrammarParser.ColumnContext;
import com.codeadbackend.codead.CodeadGrammarParser.FieldContext;
import com.codeadbackend.codead.CodeadGrammarParser.FloatDoubleFieldContext;
import com.codeadbackend.codead.CodeadGrammarParser.LocalDateFieldContext;
import com.codeadbackend.codead.CodeadGrammarParser.RelationContext;
import com.codeadbackend.codead.CodeadGrammarParser.StringFieldContext;
import com.codeadbackend.codead.CodeadGrammarParser.LocalDateContext;
import com.codeadbackend.codead.CodeadGrammarParser.StringContext;
import com.codeadbackend.codead.CodeadGrammarParser.MybooleanContext;
import com.codeadbackend.codead.CodeadGrammarParser.FloatDoubleContext;
import com.codeadbackend.codead.CodeadGrammarParser.ByteShortIntLongContext;
import com.codeadbackend.codead.CodeadGrammarParser.RelationDecoratorsContext;
import com.codeadbackend.codead.CodeadGrammarParser.ColumnDecoratorsContext;
import com.codeadbackend.codead.CodeadGrammarParser.NullableDecoratorContext;
import com.codeadbackend.codead.CodeadGrammarParser.UniqueDecoratorContext;
import com.codeadbackend.codead.CodeadGrammarParser.LocalDateDecoratorsContext;
import com.codeadbackend.codead.CodeadGrammarParser.TimeDecoratorContext;
import com.codeadbackend.codead.CodeadGrammarParser.StringDecoratorsContext;
import com.codeadbackend.codead.CodeadGrammarParser.MinDecoratorContext;
import com.codeadbackend.codead.CodeadGrammarParser.MaxDecoratorContext;
import com.codeadbackend.codead.CodeadGrammarParser.NotBlankDecoratorContext;
import com.codeadbackend.codead.CodeadGrammarParser.BooleanDecoratorsContext;
import com.codeadbackend.codead.CodeadGrammarParser.FloatDoubleDecoratorsContext;
import com.codeadbackend.codead.CodeadGrammarParser.IntegerDecoratorContext;
import com.codeadbackend.codead.CodeadGrammarParser.DecimalDecoratorContext;
import com.codeadbackend.codead.CodeadGrammarParser.ByteShortIntLongDecoratorsContext;
import java.util.List;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
@ToString
public class Entity {

    private String name;
    private String content;
    private ArrayList<Property> properties;

    public Entity(String name, String content) {
        this.name = name;
        this.content = content;
        this.properties = new ArrayList();
        this.extractProperties();
    }

    private void extractProperties() {
        ANTLRInputStream input = new ANTLRInputStream(this.content);
        CodeadGrammarLexer lexer = new CodeadGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CodeadGrammarParser parser = new CodeadGrammarParser(tokens);
        CodeadGrammarParser.ProgramContext programAst = parser.program();
        List<ParseTree> programAstChildren = programAst.children;
        for (ParseTree programAstChild : programAstChildren) {
            if (programAstChild instanceof ColumnContext) {
                List<ParseTree> columnAstChildren = ((ColumnContext) programAstChild).children;
                for (ParseTree columnAstChild : columnAstChildren) {
                    this.extractProperty(columnAstChild);
                }
            }
        }
    }

    private void extractProperty(ParseTree columnAstChild) {
        if (columnAstChild instanceof RelationContext) {
            String type = Property.TYPE_RELATION;
            List<ParseTree> relationAstChildren = ((RelationContext) columnAstChild).children;
            String dataType = this.extractedRelationIdentifier(relationAstChildren);
            String identifier = this.extractedRelationDataType(relationAstChildren);
            ArrayList<Constraint> constraints = this.extractedConstraints(relationAstChildren);
            Property property = new Property(type, dataType, identifier, constraints);
            this.properties.add(property);
        }
        if (columnAstChild instanceof FieldContext) {
            String type = Property.TYPE_FIELD;
            List<ParseTree> fieldAstChildren = ((FieldContext) columnAstChild).children;
            for (ParseTree fieldAstChild : fieldAstChildren) {
                List<ParseTree> specificFieldAstChildren = new ArrayList();
                if (fieldAstChild instanceof LocalDateFieldContext) {
                    specificFieldAstChildren = ((LocalDateFieldContext) fieldAstChild).children;
                }
                if (fieldAstChild instanceof StringFieldContext) {
                    specificFieldAstChildren = ((StringFieldContext) fieldAstChild).children;
                }
                if (fieldAstChild instanceof BooleanFieldContext) {
                    specificFieldAstChildren = ((BooleanFieldContext) fieldAstChild).children;
                }
                if (fieldAstChild instanceof FloatDoubleFieldContext) {
                    specificFieldAstChildren = ((FloatDoubleFieldContext) fieldAstChild).children;
                }
                if (fieldAstChild instanceof ByteShortIntLongFieldContext) {
                    specificFieldAstChildren = ((ByteShortIntLongFieldContext) fieldAstChild).children;
                }
                if (this.isValidField(fieldAstChild)) {
                    String dataType = this.extractedFieldDataType(specificFieldAstChildren, fieldAstChild);
                    String identifier = this.extractedFieldIdentifier(specificFieldAstChildren);
                    ArrayList<Constraint> constraints = this.extractedConstraints(specificFieldAstChildren);
                    Property property = new Property(type, dataType, identifier, constraints);
                    this.properties.add(property);
                }
            }
        }
    }

    private String extractedRelationIdentifier(List<ParseTree> relationAstChildren) {
        String identifier = "";
        for(ParseTree relationAstChild : relationAstChildren){
            if(relationAstChild instanceof TerminalNode){
                TerminalNode terminalNode = (TerminalNode) relationAstChild;
                Integer type = terminalNode.getSymbol().getType();
                if (type == CodeadGrammarLexer.ID_PASCAL_CASE) {
                    identifier = terminalNode.getText();
                }
            }
        }
        return identifier;
    }

    private String extractedRelationDataType(List<ParseTree> relationAstChildren) {
        String dataType = "";
        for(ParseTree relationAstChild : relationAstChildren){
            if(relationAstChild instanceof TerminalNode){
                TerminalNode terminalNode = (TerminalNode) relationAstChild;
                Integer type = terminalNode.getSymbol().getType();
                if (type == CodeadGrammarLexer.ID_CAMEL_CASE) {
                    dataType = terminalNode.getText();
                }
            }
        }
        return dataType;
    }

    private ArrayList<Constraint> extractedConstraints(List<ParseTree> specificFieldAstChildren) {
        List<List<ParseTree>> specificConstraintAstChildren = new ArrayList();
        for (ParseTree specificFieldAstChild : specificFieldAstChildren) {
            if (specificFieldAstChild instanceof RelationDecoratorsContext) {
                List<ParseTree> relationDecoratorAstChildren = ((RelationDecoratorsContext) specificFieldAstChild).children;
                for (ParseTree relationDecoratorAstChild : relationDecoratorAstChildren) {
                    // column decorators
                    if (relationDecoratorAstChild instanceof ColumnDecoratorsContext) {
                        List<ParseTree> columnDecoratorAstChildren = ((ColumnDecoratorsContext) relationDecoratorAstChild).children;
                        for (ParseTree columnDecoratorAstChild : columnDecoratorAstChildren) {
                            if (columnDecoratorAstChild instanceof NullableDecoratorContext) {
                                List<ParseTree> nullableDecoratorAstChildren = ((NullableDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(nullableDecoratorAstChildren);
                            }
                            if (columnDecoratorAstChild instanceof UniqueDecoratorContext) {
                                List<ParseTree> uniqueDecoratorAstChildren = ((UniqueDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(uniqueDecoratorAstChildren);
                            }
                        }
                    }
                }
            }
            if (specificFieldAstChild instanceof LocalDateDecoratorsContext) {
                List<ParseTree> localDateDecoratorAstChildren = ((LocalDateDecoratorsContext) specificFieldAstChild).children;
                for (ParseTree localDateDecoratorChild : localDateDecoratorAstChildren) {
                    // column decorators
                    if (localDateDecoratorChild instanceof ColumnDecoratorsContext) {
                        List<ParseTree> columnDecoratorAstChildren = ((ColumnDecoratorsContext) localDateDecoratorChild).children;
                        for (ParseTree columnDecoratorAstChild : columnDecoratorAstChildren) {
                            if (columnDecoratorAstChild instanceof NullableDecoratorContext) {
                                List<ParseTree> nullableDecoratorAstChildren = ((NullableDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(nullableDecoratorAstChildren);
                            }
                            if (columnDecoratorAstChild instanceof UniqueDecoratorContext) {
                                List<ParseTree> uniqueDecoratorAstChildren = ((UniqueDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(uniqueDecoratorAstChildren);
                            }
                        }
                    }

                    // time decorators
                    if (localDateDecoratorChild instanceof TimeDecoratorContext) {
                        List<ParseTree> timeDecoratorAstCChildren = ((TimeDecoratorContext) localDateDecoratorChild).children;
                        specificConstraintAstChildren.add(timeDecoratorAstCChildren);
                    }
                }
            }
            if (specificFieldAstChild instanceof StringDecoratorsContext) {
                List<ParseTree> stringDecoratorAstChildren = ((StringDecoratorsContext) specificFieldAstChild).children;
                for(ParseTree stringDecoratorAstChild : stringDecoratorAstChildren){
                    // column decorators
                    if(stringDecoratorAstChild instanceof ColumnDecoratorsContext){
                        List<ParseTree> columnDecoratorAstChildren = ((ColumnDecoratorsContext) stringDecoratorAstChild).children;
                        for (ParseTree columnDecoratorAstChild : columnDecoratorAstChildren) {
                            if (columnDecoratorAstChild instanceof NullableDecoratorContext) {
                                List<ParseTree> nullableDecoratorAstChildren = ((NullableDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(nullableDecoratorAstChildren);
                            }
                            if (columnDecoratorAstChild instanceof UniqueDecoratorContext) {
                                List<ParseTree> uniqueDecoratorAstChildren = ((UniqueDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(uniqueDecoratorAstChildren);
                            }
                        }
                    }
                    
                    // min decorator
                    if(stringDecoratorAstChild instanceof MinDecoratorContext){
                        List<ParseTree> minDecoratorAstChildren = ((MinDecoratorContext) stringDecoratorAstChild).children;
                        specificConstraintAstChildren.add(minDecoratorAstChildren);
                    }
                    
                    // max decorator
                    if(stringDecoratorAstChild instanceof MaxDecoratorContext){
                        List<ParseTree> maxDecoratorAstChildren = ((MaxDecoratorContext) stringDecoratorAstChild).children;
                        specificConstraintAstChildren.add(maxDecoratorAstChildren);
                    }
                    
                    // notblank decorator
                    if(stringDecoratorAstChild instanceof NotBlankDecoratorContext){
                        List<ParseTree> notBlankDecoratorAstChildren = ((NotBlankDecoratorContext) stringDecoratorAstChild).children;
                        specificConstraintAstChildren.add(notBlankDecoratorAstChildren);
                    }
                }
            }
            if (specificFieldAstChild instanceof BooleanDecoratorsContext) {
                List<ParseTree> booleanDecoratorAstChildren = ((BooleanDecoratorsContext) specificFieldAstChild).children;
                for(ParseTree booleanDecoratorAstChild : booleanDecoratorAstChildren){
                    // column decorators
                    if(booleanDecoratorAstChild instanceof ColumnDecoratorsContext){
                        List<ParseTree> columnDecoratorAstChildren = ((ColumnDecoratorsContext) booleanDecoratorAstChild).children;
                        for (ParseTree columnDecoratorAstChild : columnDecoratorAstChildren) {
                            if (columnDecoratorAstChild instanceof NullableDecoratorContext) {
                                List<ParseTree> nullableDecoratorAstChildren = ((NullableDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(nullableDecoratorAstChildren);
                            }
                            if (columnDecoratorAstChild instanceof UniqueDecoratorContext) {
                                List<ParseTree> uniqueDecoratorAstChildren = ((UniqueDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(uniqueDecoratorAstChildren);
                            }
                        }
                    }
                }
            }
            if (specificFieldAstChild instanceof ByteShortIntLongDecoratorsContext) {
                List<ParseTree> byteShortIntDecoratorAstChildren = ((ByteShortIntLongDecoratorsContext) specificFieldAstChild).children;
                for(ParseTree byteShortIntDecoratorAstChild : byteShortIntDecoratorAstChildren){
                    // column decorators
                    if(byteShortIntDecoratorAstChild instanceof ColumnDecoratorsContext){
                        List<ParseTree> columnDecoratorAstChildren = ((ColumnDecoratorsContext) byteShortIntDecoratorAstChild).children;
                        for (ParseTree columnDecoratorAstChild : columnDecoratorAstChildren) {
                            if (columnDecoratorAstChild instanceof NullableDecoratorContext) {
                                List<ParseTree> nullableDecoratorAstChildren = ((NullableDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(nullableDecoratorAstChildren);
                            }
                            if (columnDecoratorAstChild instanceof UniqueDecoratorContext) {
                                List<ParseTree> uniqueDecoratorAstChildren = ((UniqueDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(uniqueDecoratorAstChildren);
                            }
                        }
                    }
                    
                    // min decorator
                    if(byteShortIntDecoratorAstChild instanceof MinDecoratorContext){
                        List<ParseTree> minDecoratorAstChildren = ((MinDecoratorContext) byteShortIntDecoratorAstChild).children;
                        specificConstraintAstChildren.add(minDecoratorAstChildren);
                    }
                    
                    // max decorator
                    if(byteShortIntDecoratorAstChild instanceof MaxDecoratorContext){
                        List<ParseTree> maxDecoratorAstChildren = ((MaxDecoratorContext) byteShortIntDecoratorAstChild).children;
                        specificConstraintAstChildren.add(maxDecoratorAstChildren);
                    }
                }
            }
            if (specificFieldAstChild instanceof FloatDoubleDecoratorsContext) {
                List<ParseTree> floatDoubleDecoratorAstChildren = ((FloatDoubleDecoratorsContext) specificFieldAstChild).children;
                for(ParseTree floatDoubleDecoratorAstChild : floatDoubleDecoratorAstChildren){
                    // column decorators
                    if(floatDoubleDecoratorAstChild instanceof ColumnDecoratorsContext){
                        List<ParseTree> columnDecoratorAstChildren = ((ColumnDecoratorsContext) floatDoubleDecoratorAstChild).children;
                        for (ParseTree columnDecoratorAstChild : columnDecoratorAstChildren) {
                            if (columnDecoratorAstChild instanceof NullableDecoratorContext) {
                                List<ParseTree> nullableDecoratorAstChildren = ((NullableDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(nullableDecoratorAstChildren);
                            }
                            if (columnDecoratorAstChild instanceof UniqueDecoratorContext) {
                                List<ParseTree> uniqueDecoratorAstChildren = ((UniqueDecoratorContext) columnDecoratorAstChild).children;
                                specificConstraintAstChildren.add(uniqueDecoratorAstChildren);
                            }
                        }
                    }
                    
                    // min decorator
                    if(floatDoubleDecoratorAstChild instanceof MinDecoratorContext){
                        List<ParseTree> minDecoratorAstChildren = ((MinDecoratorContext) floatDoubleDecoratorAstChild).children;
                        specificConstraintAstChildren.add(minDecoratorAstChildren);
                    }
                    
                    // max decorator
                    if(floatDoubleDecoratorAstChild instanceof MaxDecoratorContext){
                        List<ParseTree> maxDecoratorAstChildren = ((MaxDecoratorContext) floatDoubleDecoratorAstChild).children;
                        specificConstraintAstChildren.add(maxDecoratorAstChildren);
                    }
                    
                    // integer decorator
                    if(floatDoubleDecoratorAstChild instanceof IntegerDecoratorContext){
                        List<ParseTree> integerDecoratorAstChildren = ((IntegerDecoratorContext) floatDoubleDecoratorAstChild).children;
                        specificConstraintAstChildren.add(integerDecoratorAstChildren);
                    }
                    
                    // decimal decorator
                    if(floatDoubleDecoratorAstChild instanceof DecimalDecoratorContext){
                        List<ParseTree> decimalDecoratorAstChildren = ((DecimalDecoratorContext) floatDoubleDecoratorAstChild).children;
                        specificConstraintAstChildren.add(decimalDecoratorAstChildren);
                    }
                }
            }
        }

        ArrayList<Constraint> constraints = new ArrayList();
        for (List<ParseTree> specificCosntraintAstChild : specificConstraintAstChildren) {
            Constraint constraint = this.extractedConstraint(specificCosntraintAstChild);
            constraints.add(constraint);
        }
        return constraints;
    }

    private Constraint extractedConstraint(List<ParseTree> specificConstraintAstChildren) {
        ArrayList<TerminalNode> terminalNodes = new ArrayList();
        for (ParseTree specificConstraintChild : specificConstraintAstChildren) {
            if (specificConstraintChild instanceof TerminalNode) {
                TerminalNode terminalNode = (TerminalNode) specificConstraintChild;
                terminalNodes.add(terminalNode);
            }
        }
        Constraint constraint = new Constraint();
        for (TerminalNode terminalNode : terminalNodes) {
            Integer type = terminalNode.getSymbol().getType();
            if (type == CodeadGrammarLexer.NOT_BLANK_DECORATOR || type == CodeadGrammarLexer.NOT_BLANK_DECORATOR_OPEN) {
                constraint.setName(Constraint.NOT_BLANK);
            }
            if (type == CodeadGrammarLexer.TIME_DECORATOR || type == CodeadGrammarLexer.TIME_DECORATOR_OPEN) {
                constraint.setName(Constraint.TIME);
            }
            if (type == CodeadGrammarLexer.DECIMAL_DECORATOR || type == CodeadGrammarLexer.DECIMAL_DECORATOR_OPEN) {
                constraint.setName(Constraint.DECIMAL);
            }
            if (type == CodeadGrammarLexer.INTEGER_DECORATOR || type == CodeadGrammarLexer.INTEGER_DECORATOR_OPEN) {
                constraint.setName(Constraint.INTEGER);
            }
            if (type == CodeadGrammarLexer.MAX_DECORATOR || type == CodeadGrammarLexer.MAX_DECORATOR_OPEN) {
                constraint.setName(Constraint.MAX);
            }
            if (type == CodeadGrammarLexer.MIN_DECORATOR || type == CodeadGrammarLexer.MIN_DECORATOR_OPEN) {
                constraint.setName(Constraint.MIN);
            }
            if (type == CodeadGrammarLexer.NULLABLE_DECORATOR || type == CodeadGrammarLexer.NULLABLE_DECORATOR_OPEN) {
                constraint.setName(Constraint.NULLABLE);
            }
            if (type == CodeadGrammarLexer.UNIQUE_DECORATOR || type == CodeadGrammarLexer.UNIQUE_DECORATOR_OPEN) {
                constraint.setName(Constraint.UNIQUE);
            }
            if (type == CodeadGrammarLexer.BOOLEAN || type == CodeadGrammarLexer.TIME || type == CodeadGrammarLexer.NATURAL_NUMBER || type == CodeadGrammarLexer.INTEGER_NUMBER || type == CodeadGrammarLexer.DECIMAL_NUMBER) {
                String value = terminalNode.getText();
                constraint.setValue(value);
            }
        }
        return constraint;
    }
    
    private boolean isValidField(ParseTree fieldAstChild) {
        return fieldAstChild instanceof LocalDateFieldContext
                || fieldAstChild instanceof StringFieldContext
                || fieldAstChild instanceof BooleanFieldContext
                || fieldAstChild instanceof FloatDoubleFieldContext
                || fieldAstChild instanceof ByteShortIntLongFieldContext;
    }

    private String extractedFieldDataType(List<ParseTree> specificFieldAstChildren, ParseTree fieldAstChild) {
        if (fieldAstChild instanceof LocalDateFieldContext) {
            for (ParseTree specificFieldAstChild : specificFieldAstChildren) {
                if (specificFieldAstChild instanceof LocalDateContext) {
                    List<ParseTree> localDateAstChildren = ((LocalDateContext) specificFieldAstChild).children;
                    for (ParseTree localDateAstChild : localDateAstChildren) {
                        if (localDateAstChild instanceof TerminalNode) {
                            return localDateAstChild.getText();
                        }
                    }
                }
            }
        }
        if (fieldAstChild instanceof StringFieldContext) {
            for (ParseTree specificFieldAstChild : specificFieldAstChildren) {
                if (specificFieldAstChild instanceof StringContext) {
                    List<ParseTree> stringAstChildren = ((StringContext) specificFieldAstChild).children;
                    for (ParseTree stringAstChild : stringAstChildren) {
                        if (stringAstChild instanceof TerminalNode) {
                            return stringAstChild.getText();
                        }
                    }
                }
            }
        }
        if (fieldAstChild instanceof BooleanFieldContext) {
            for (ParseTree specificFieldAstChild : specificFieldAstChildren) {
                if (specificFieldAstChild instanceof MybooleanContext) {
                    List<ParseTree> booleanAstChildren = ((MybooleanContext) specificFieldAstChild).children;
                    for (ParseTree booleanAstChild : booleanAstChildren) {
                        if (booleanAstChild instanceof TerminalNode) {
                            return booleanAstChild.getText();
                        }
                    }
                }
            }
        }
        if (fieldAstChild instanceof FloatDoubleFieldContext) {
            for (ParseTree specificFieldAstChild : specificFieldAstChildren) {
                if (specificFieldAstChild instanceof FloatDoubleContext) {
                    List<ParseTree> floatDoubleAstChildren = ((FloatDoubleContext) specificFieldAstChild).children;
                    for (ParseTree floatDoubleAstChild : floatDoubleAstChildren) {
                        if (floatDoubleAstChild instanceof TerminalNode) {
                            return floatDoubleAstChild.getText();
                        }
                    }
                }
            }
        }
        if (fieldAstChild instanceof ByteShortIntLongFieldContext) {
            for (ParseTree specificFieldAstChild : specificFieldAstChildren) {
                if (specificFieldAstChild instanceof ByteShortIntLongContext) {
                    List<ParseTree> byteShortIntAstChildren = ((ByteShortIntLongContext) specificFieldAstChild).children;
                    for (ParseTree byteShortIntAstChild : byteShortIntAstChildren) {
                        if (byteShortIntAstChild instanceof TerminalNode) {
                            return byteShortIntAstChild.getText();
                        }
                    }
                }
            }
        }
        return "";
    }

    private String extractedFieldIdentifier(List<ParseTree> specificFieldAstChildren) {
        for (ParseTree specificFieldAstChild : specificFieldAstChildren) {
            if (specificFieldAstChild instanceof TerminalNode) {
                return specificFieldAstChild.getText();
            }
        }
        return "";
    }

    public void generate() {

    }
}
