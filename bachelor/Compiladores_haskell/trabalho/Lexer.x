{
module Lexer where
}

%wrapper "basic"

$white     = [\ \t\n\r]
$digit     = [0-9]
$alpha     = [A-Za-z]
$alphanum  = [$alpha $digit]

tokens :-
$white+ ("//".*);
$white+ "/*"([^\*]|(\*+[^\*\/]))*"*/";
$white+ ; 

"fun"           { \_ -> FUN }
"main"           { \_ -> MAIN }
"println"       { \_ -> PRINTLN }
"readln"        { \_ -> READLN }
"print"         { \_ -> PRINT }
"read"          { \_ -> READ }
"val"           { \_ -> VAL }
"var"           { \_ -> VAR }
"if"            { \_ -> IF }
"else"          { \_ -> ELSE }
"when"          { \_ -> WHEN }
"then"          { \_ -> THEN }
"for"           { \_ -> FOR }
"while"         { \_ -> WHILE }
"do"            { \_ -> DO }
"return"        { \_ -> RETURN }
"class"         { \_ -> CLASS }
"object"        { \_ -> OBJECT }
"open"          { \_ -> OPEN }
"is"            { \_ -> IS }
"in"            { \_ -> IN }
"null"          { \_ -> NULL }

"+"  { \_ -> PLUS }
"-"  { \_ -> MINUS }
"*"  { \_ -> MULT }
"/"  { \_ -> DIV }
".." { \_ -> RANGETO }
"..<"{ \_ -> RANGEUNTIL }
"="  { \_ -> LEQ }
"==" { \_ -> LEQEQ }
"!=" { \_ -> LNEQ }
">"  { \_ -> LGT }
"<"  { \_ -> LLT }
">=" { \_ -> LGTEQ }
"<=" { \_ -> LLTEQ }
"||" { \_ -> OR }
"&&" { \_ -> AND }
"!"  { \_ -> NOT }
"true" { \_ -> TRUE }
"false" { \_ -> FALSE }
"(" { \_ -> LPAREN }
")" { \_ -> RPAREN }
"{" { \_ -> LBRACE }
"}" { \_ -> RBRACE }
"[" { \_ -> LBRACKET }
"]" { \_ -> RBRACKET }
"," { \_ -> COMMA }
";" { \_ -> SEMICOLON }
":" { \_ -> COLON }

$digit+ { \s -> NUM (read s) } 
$digit+"."$digit+ { \s -> REAL (read s) } 
$alpha($alphanum)*  { \s -> ID s }

\"([^\"]*)\" { \s -> FRASE s }

{

data Token
  = NUM Int
  | PLUS
  | MINUS
  | MULT
  | DIV
  | FUN
  | MAIN
  | PRINTLN
  | READLN
  | PRINT
  | READ
  | VAL
  | VAR
  | IF
  | ELSE
  | WHEN
  | FOR
  | WHILE
  | DO
  | RETURN
  | CLASS
  | OBJECT
  | OPEN
  | IS
  | IN
  | NULL
  | RANGETO
  | THEN
  | RANGEUNTIL
  | LEQ   
  | LEQEQ 
  | LNEQ  
  | LGT   
  | LLT   
  | LGTEQ 
  | LLTEQ 
  | OR
  | AND
  | NOT
  | TRUE
  | FALSE
  | LPAREN
  | RPAREN
  | LBRACE
  | RBRACE
  | LBRACKET
  | RBRACKET
  | COMMA
  | SEMICOLON
  | COLON
  | REAL Double
  | ID String
  | COMMENT 
  | FRASE String 
  deriving (Show, Eq)
}