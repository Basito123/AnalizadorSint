package principal;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
DD=[0-9]+(\.[0-9]+)?
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}
/* Tipos de datos */
( Gint |Gbyte | Gchar | Glong | Gfloat | Gdouble ) {return new Symbol(sym.T_dato, yychar, yyline, yytext());}

( Gstring ) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {return new Symbol(sym.Op_logico, yychar, yyline, yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {return new Symbol(sym.Op_relacional, yychar, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" | "=" ) {return new Symbol(sym.Op_atribucion, yychar, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.Op_incremento, yychar, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}

( "GMain" ) {return new Symbol(sym.Main, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

/* Salto de linea*/
("\n") {return new Symbol(sym.Terminador, yychar, yyline, yytext());}

/* Tabulador horizontal*/
("\t") {return new Symbol(sym.Tabular, yychar, yyline, yytext());}

/* Palabra reservada If */
( Gif ) {return new Symbol(sym.If, yychar, yyline, yytext());}

/* Palabra reservada Else */
( Gelse ) {return new Symbol(sym.Else, yychar, yyline, yytext());}

/* Palabra reservada Do */
( Gdo ) {return new Symbol(sym.Do, yychar, yyline, yytext());}

/* Palabra reservada While */
( Gwhile ) {return new Symbol(sym.While, yychar, yyline, yytext());}

/* Palabra reservada For */
( Gfor ) {return new Symbol(sym.For, yychar, yyline, yytext());}

/*Palabra reservada Switch*/
( Gswitch ) {return new Symbol(sym.Switch, yychar , yyline, yytext());}

/*Case*/
(Case){return new Symbol(sym.Case, yychar, yyline, yytext());}

/* Punto y coma */
( ";" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}

"g=" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
"//"  {return new Symbol(sym.comentario, yychar, yyline, yytext());}
"g+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
"g-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"g*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"g/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}


("\"") {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

(DD) {return new Symbol(sym.NumeroD, yychar, yyline, yytext());}

("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
