grammar MyLanguage;

program: statementList;

statementList: main | functionDeclaration statementList;

main: 'main' LPAREN RPAREN LBRACE statement statementListTail RBRACE;

statementListTail: statement statementListTail | ;

statement: variableDeclarationEmpty | variableAssigment | ifStatement | whileStatement | functionCall | inputStatement | outputStatement;

variableDeclarationEmpty: TYPE ID variableDeclarationValue SEMICOLON;

variableAssigment: ID ASSIGN (variable | functionCallExpr) SEMICOLON;

variableDeclarationValue: ASSIGN (variable | functionCallExpr) | ;

functionCallExpr: ID LPAREN argumentList RPAREN;

argumentList: (variable) (COMMA variable)* | ;

functionVariableDeclaration: TYPE ID;

variable: STRING | BOOL | figure | FLOAT | ID aritmetica;

figure: DIGITO aritmetica;

aritmetica: operator (DIGITO | ID) aritmetica | ;

whichCondition: BOOL | condition;

condition: numbersCondition expression1 | STRING expression3 | ID expression2;

numbersCondition: DIGITO | FLOAT;

expression1: COMPARISON_OP numbersCondition expression1 | ;

expression2: COMPARISON_OP variable expression2 | relationOperator2 variable expression2 | ;

expression3: relationOperator2 STRING expression3 | ;

relationOperator2: EQUALS | NOT_EQUALS;

ifStatement: IF LPAREN whichCondition RPAREN LBRACE statementListTail RBRACE elsePart;

elsePart: ELSE LBRACE statementListTail RBRACE | ELSE ifStatement |;

whileStatement: WHILE LPAREN whichCondition RPAREN LBRACE statementListTail RBRACE;

functionCall: ID LPAREN parameterList RPAREN SEMICOLON;

functionDeclaration: TYPE FUNCTION ID LPAREN parameterList RPAREN LBRACE statementListTail RETURN variable SEMICOLON RBRACE;

parameterList: functionVariableDeclaration parameterListTail | ;

parameterListTail: COMMA functionVariableDeclaration parameterListTail | ;

inputStatement: READ LPAREN ID RPAREN SEMICOLON;

outputStatement: WRITE LPAREN (STRING | ID ) RPAREN SEMICOLON;

operator: PLUS | MINUS | MULT | DIV | PERCENT |;

TYPE: 'int' | 'float' | 'string' | 'bool';
BOOL: 'true' | 'false';
FUNCTION: 'function' | 'Function';
IF: 'if' | 'If';
ELSE: 'else' | 'Else';
WHILE: 'while' | 'While';
READ: 'read' | 'Read';
WRITE: 'write' | 'Write';
RETURN: 'return';
STRING: '"' (~["\r\n])* '"';
CHARACTER: '\'' (~['\r\n]) '\'';

ID: [a-zA-Z][a-zA-Z0-9]*;
FLOAT: [0-9]+ '.' [0-9] [0-9]? [0-9]? [0-9]?;
DIGITO: [0-9]+;
COMPARISON_OP: LESS_THAN | GREATER_THAN | LESS_EQUALS | GREATER_EQUALS | EQUALS | NOT_EQUALS;

EQUALS: '==';
NOT_EQUALS: '!=';
LESS_EQUALS: '<=';
GREATER_EQUALS: '>=';
LESS_THAN: '<';
GREATER_THAN: '>';

SYMBOL: [!@#$%^&_?:|];

PLUS: '+';
PERCENT: 'mod';
MINUS: '-';
MULT: '*';
DIV: '/';
ASSIGN: '=';
LPAREN: '(';
RPAREN: ')';
COMMA: ',';
SEMICOLON: ';';
LBRACE: '{';
RBRACE: '}';

WS: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
MULTILINE_COMMENT: '/*' .*? '*/' -> skip;

MULTI_CHARACTER_ERROR: '\'' (.)+? '\'';