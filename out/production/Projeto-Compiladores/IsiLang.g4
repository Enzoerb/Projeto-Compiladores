grammar IsiLang;

prog : 'programa' ((decl bloco) | bloco)? 'fimprog.';

decl : (declarar)+;

declarar : tipo ID (VIRG ID)* PF;

tipo : 'num' | 'texto';

bloco : (cmd)+;

cmd : cmdLeitura PF | cmdEscrita PF | cmdAttr PF | cmdIf | cmdRepeticaoWhile;

cmdLeitura : 'leia' AP ID FP;

cmdEscrita : 'escreva' AP TEXTO | ID FP;

cmdIf : 'se' AP expr OPREL expr FP 'entao' AC cmd+ FC ('senao' AC cmd+ FC)?;

cmdRepeticaoWhile : 'enquanto' AP expr OPREL expr FP AC (cmd)+ FC;

cmdAttr : ID ATTR expr;

OPREL : MENQ | MAIQ | MENIG | MAIIG | DIF | IGUALC;

OP : MAIS | MENOS | ASTRSC | BARRA;

expr : termo exprl;
exprl : (OP termo)*;

termo : fator termol;
termol : fator ASTRSC termol | fator BARRA termol | fator;

fator : NUM | ID | TEXTO | AP expr FP;

TEXTO : '"' ([0-9] | [a-z] | [A-Z])+ '"';

NUM : [0-9]+ (PF [0-9]+)?;

ID : ([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9])*; 



PF : '.';
VIRG : ',';
AP : '(';
FP : ')';
AC : '{';
FC : '}';
ATTR : ':=';
MENQ : '<';
MAIQ : '>';
MENIG : '<=';
MAIIG : '>=';
DIF : '!=';
IGUALC : '==';
MAIS : '+';
MENOS : '-';
ASTRSC : '*';
BARRA : '/';

WS	: (' ' | '\t' | '\n' | '\r') -> skip;
