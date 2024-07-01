
grammar CodeadGrammar;

program: column+ EOF;

column
    : relation
    | field;
relation
    : relationDecorators* ID_PASCAL_CASE ID_CAMEL_CASE;
relationDecorators
    : columnDecorators;
field
    : localDateField
    | stringField
    | booleanField
    | floatDoubleField
    | byteShortIntLongField;
localDateField
    : localDateDecorators* localDate ID_CAMEL_CASE;
localDate
    : LOCAL_DATE_KEY;
localDateDecorators
    : columnDecorators
    | timeDecorator;
stringField
    : stringDecorators* string ID_CAMEL_CASE;
string
    : STRING_KEY;
stringDecorators
    : columnDecorators
    | minDecorator
    | maxDecorator
    | notBlankDecorator;
booleanField
    : booleanDecorators* myboolean ID_CAMEL_CASE;
myboolean
    : BOOLEAN_KEY;
booleanDecorators
    : columnDecorators;
floatDoubleField
    : floatDoubleDecorators* floatDouble ID_CAMEL_CASE;
floatDouble
    : FLOAT_KEY
    | DOUBLE_KEY;
floatDoubleDecorators
    : columnDecorators
    | minDecorator
    | maxDecorator
    | integerDecorator
    | decimalDecorator;
byteShortIntLongField
    : byteShortIntLongDecorators* byteShortIntLong ID_CAMEL_CASE;
byteShortIntLong
    : BYTE_KEY 
    | SHORT_KEY 
    | INT_KEY 
    | LONG_KEY;
byteShortIntLongDecorators
    : columnDecorators
    | minDecorator
    | maxDecorator;
columnDecorators
    : nullableDecorator
    | uniqueDecorator;
notBlankDecorator
    : NOT_BLANK_DECORATOR
    | NOT_BLANK_DECORATOR_OPEN BOOLEAN DECORATOR_CLOSE;
NOT_BLANK_DECORATOR_OPEN
    : NOT_BLANK_DECORATOR SPACE '(';
NOT_BLANK_DECORATOR:
    '@NotBlank';
timeDecorator
    : TIME_DECORATOR
    | TIME_DECORATOR_OPEN TIME DECORATOR_CLOSE;
TIME_DECORATOR_OPEN
    : TIME_DECORATOR SPACE '(';
TIME_DECORATOR:
    '@Time';
decimalDecorator
    : DECIMAL_DECORATOR
    | DECIMAL_DECORATOR_OPEN NATURAL_NUMBER DECORATOR_CLOSE;
DECIMAL_DECORATOR_OPEN
    : DECIMAL_DECORATOR SPACE '(';
DECIMAL_DECORATOR:
    '@Decimal';
integerDecorator
    : INTEGER_DECORATOR
    | INTEGER_DECORATOR_OPEN NATURAL_NUMBER DECORATOR_CLOSE;
INTEGER_DECORATOR_OPEN
    : INTEGER_DECORATOR SPACE '(';
INTEGER_DECORATOR:
    '@Integer';
maxDecorator
    : MAX_DECORATOR
    | MAX_DECORATOR_OPEN (NATURAL_NUMBER | INTEGER_NUMBER | DECIMAL_NUMBER) DECORATOR_CLOSE;
MAX_DECORATOR_OPEN
    : MAX_DECORATOR SPACE '(';
MAX_DECORATOR:
    '@Max';
minDecorator
    : MIN_DECORATOR
    | MIN_DECORATOR_OPEN (NATURAL_NUMBER | INTEGER_NUMBER | DECIMAL_NUMBER) DECORATOR_CLOSE;
MIN_DECORATOR_OPEN
    : MIN_DECORATOR SPACE '(';
MIN_DECORATOR:
    '@Min';
nullableDecorator
    : NULLABLE_DECORATOR
    | NULLABLE_DECORATOR_OPEN BOOLEAN DECORATOR_CLOSE;
NULLABLE_DECORATOR_OPEN
    : NULLABLE_DECORATOR SPACE '(';
NULLABLE_DECORATOR:
    '@Nullable';
uniqueDecorator
    : UNIQUE_DECORATOR
    | UNIQUE_DECORATOR_OPEN BOOLEAN DECORATOR_CLOSE;
UNIQUE_DECORATOR_OPEN
    : UNIQUE_DECORATOR SPACE '(' SPACE;
UNIQUE_DECORATOR
    : '@Unique';
DECORATOR_CLOSE
    : ')';
BOOLEAN
    : 'true'
    | 'false';
TIME
    : 'Future'
    | 'FutureOrNow'
    | 'Past'
    | 'PastOrNow';
BYTE_KEY
    : 'byte';
SHORT_KEY
    : 'short';
INT_KEY
    : 'int';
LONG_KEY
    : 'long';
FLOAT_KEY
    : 'float';
DOUBLE_KEY
    : 'double';
BOOLEAN_KEY
    : 'boolean';
STRING_KEY
    : 'String';
LOCAL_DATE_KEY
    : 'LocalDate';
DECIMAL_NUMBER
    : INTEGER_NUMBER '.' NATURAL_NUMBER
    | '.' NATURAL_NUMBER
    | '-.' NATURAL_NUMBER
    | '+.' NATURAL_NUMBER;
INTEGER_NUMBER
    : '+' NATURAL_NUMBER
    | '-' NATURAL_NUMBER;
NATURAL_NUMBER
    : [0-9]+;
ID_CAMEL_CASE
    : [a-z] [a-zA-Z0-9]*;
ID_PASCAL_CASE
    : [A-Z] [a-zA-Z0-9]*;

fragment SPACE
    : [ \t\r\n]*;
WS: [ \t\r\n]+ -> skip;