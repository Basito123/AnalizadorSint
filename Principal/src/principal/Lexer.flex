package principal;
import static principal.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
DD=[0-9]+(\.[0-9]+)?
Espacio=[ ,\t,\r]+
string = "\""[^\"\n]*"\""
%{
    public String lexeme;
%}
%%

{Espacio} {/*Ignore*/}

"//".* {/*Ignore*/}


( "GMain" ) {lexeme=yytext(); return Main;}


/* Tipos de datos */
( Gbyte | Gint | Gchar | Glong | Gfloat | Gdouble ) {lexeme=yytext(); return T_dato;}

/* Palabra reservada If */
( Gif ) {lexeme=yytext(); return If;}

/* Palabra reservada Else */
( Gelse ) {lexeme=yytext(); return Else;}

/* Palabra reservada Do */
( Gdo ) {lexeme=yytext(); return Do;}

/* Palabra reservada While */
( Gwhile ) {lexeme=yytext(); return While;}

( "main" ) {lexeme=yytext(); return Main;}
/* Palabra reservada For */
( Gfor ) {lexeme=yytext(); return For;}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {lexeme=yytext(); return Op_logico;}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {lexeme = yytext(); return Op_relacional;}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return Op_atribucion;}

/* Operadores Incremento y decremento */
( "++" | "--" ) {lexeme = yytext(); return Op_incremento;}

/* Parentesis de apertura */
( "(" ) {lexeme=yytext(); return Parentesis_a;}

/* Parentesis de cierre */
( ")" ) {lexeme=yytext(); return Parentesis_c;}

/* Llave de apertura */
( "{" ) {lexeme=yytext(); return Llave_a;}

/* Llave de cierre */
( "}" ) {lexeme=yytext(); return Llave_c;}

/* Marcador de inicio de algoritmo */
( "main" ) {lexeme=yytext(); return Main;}

/* Punto y coma */
( ";" ) {lexeme=yytext(); return P_coma;}

/* Salto de linea*/
("\n") {return Terminador;}

/* Tabulador horizontal*/
("\t") {return Tabular;}

"g=" {return Igual;}
"//" {return comentario;}
"g+" {return Suma;}
"g-" {return Resta;}
"g*" {return Multiplicacion;}
"g/" {return Division;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

(Gstring) {lexeme=yytext(); return Cadena;}
("\"") {lexeme=yytext(); return Comillas;}

{DD} {lexeme=yytext(); return NumeroD;}

("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
