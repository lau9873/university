{
module Lexer where
}
%wrapper "basic"
$alpha = [_a-zA-Z]
$digit = [0-9]
tokens :-
$white+ ; -- ignorar carateres brancos 
if { \_ -> IF } 
$alpha($alpha|$digit)* { \s -> ID s }
$digit+ { \s -> NUM (read s) } 
$digit+"."$digit+ { \s -> REAL (read s) }
{
data Token = IF | ID String | NUM Int | REAL Double
}