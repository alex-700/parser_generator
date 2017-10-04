lexer grammar GrammarLexer;

OSB: '[' -> pushMode(ENUM);
COLON: ':';
OR: '|';
SEMICOLON: ';';
EQUAL: '=';
OCB: '{' -> pushMode(CODE_MODE);
SHARP_START: '#' -> pushMode(MEMBERS_MODE);

LOCALS: 'locals';
RETURNS: 'returns';
INIT: '@init';
MEMBERS: '@members';

Nonterm: [a-z][_a-zA-Z']*;
Term: [A-Z][a-zA-Z0-9]*;
Regular: ["](.)+?["];

WS: [ \t\r\n]+ -> skip;

mode ENUM;

CSB: ']' -> popMode;
COMMA: ',';
Word: [a-zA-Z"$][a-zA-Z0-9<>_"$+]*;
WS2: [ \t\r\n]+ -> skip;

mode CODE_MODE;
CCB: '}' -> popMode;
TEXT: ~('}')+;

mode MEMBERS_MODE;
SHARP_FINISH: '#' -> popMode;
CODE: ~('#')+;



