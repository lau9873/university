--
-- Um analisador lexical para expressões aritméticas simples
--
{
module Lexer where
}

%wrapper "basic"
$white =  [\ \t\n\r]
$digit =  [0-9]

tokens :-

$white+  ; -- ignorar caracteres brancos

"+"       { \_ -> PLUS }
"-"       { \_ -> MINUS }
"*"       { \_ -> MULT }
"/"       { \_ -> DIV }
"("       { \_ -> LPAREN }
")"       { \_ -> RPAREN }

$digit+   { \x -> NUM (read x) }  -- A conversão de string para número ocorre aqui

-- Operador Unário de Negação
"-"       { \_ -> UMINUS }

{
data Token
  = PLUS
  | MINUS
  | UMINUS
  | MULT
  | DIV
  | LPAREN
  | RPAREN
  | NUM Int  -- Alterado para que NUM contenha um valor numérico inteiro
  deriving (Eq, Show)
}
