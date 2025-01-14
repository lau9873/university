{
module Parser where
import Lexer
import AST
}
%name parse
%tokentype { Token }
%error { parseError }

%token
  PLUS     { PLUS }
  MINUS    { MINUS }
  MULT     { MULT }
  DIV      { DIV }
  LPAREN   { LPAREN }
  RPAREN   { RPAREN }
  NUM      { NUM int}

%right UMINUS
%left PLUS MINUS
%left MULT DIV
%%

-- Starter Token for the grammar
Exp : Exp PLUS Exp    { Add $1 $3 }
    | Exp MINUS Exp   { Sub $1 $3 }
    | Exp MULT Exp    { Mul $1 $3 }
    | Exp DIV Exp     { Div $1 $3 }
    | MINUS Exp %prec UMINUS  { Neg $2 }
    | LPAREN Exp RPAREN { $2 }
    | NUM            { case $1 of NUM n -> Num n } 

-- Função de erro para o parser
{parseError :: [Token] -> a
parseError toks = error $ "Parse error: " ++ show toks}
