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
  NUM      { NUM int }
  REAL     { REAL double }
  TRUE     { TRUE }
  FALSE    { FALSE }
  IF       { IF }
  ELSE     { ELSE }
  WHILE    { WHILE }
  PRINT  { PRINT }
  READLN   { READLN }
  ID       { ID string }
  FRASE {FRASE string}
  VAL      { VAL }
  VAR      { VAR }
  AND      { AND }
  OR       { OR }
--  THEN     { THEN }
  NOT      { NOT }
  LEQ      { LEQ }
  LEQEQ    { LEQEQ }
  LNEQ     { LNEQ }
  LGT      { LGT }   
  LLT      { LLT }   
  LGTEQ    { LGTEQ }
  LLTEQ    { LLTEQ }
  SEMICOLON {SEMICOLON}
  FUN {FUN}
  MAIN {MAIN}
  LBRACE {LBRACE}
  RBRACE {RBRACE}
-- COLON {COLON}
 


%right UMINUS NOT
%left OR AND
%left PLUS MINUS
%left MULT DIV
%left LEQ LEQEQ LNEQ LGT LLT LGTEQ LLTEQ
%%



--Program : StmtList { $1 }
Program : FUN MAIN LPAREN  RPAREN LBRACE StmtList RBRACE  { $6 }


StmtList : Stmt SEMICOLON StmtList { $1 : $3 }
         | { [] }



Exp : Exp PLUS Exp    { Add $1 $3 }
    | Exp MINUS Exp   { Sub $1 $3 }
    | Exp MULT Exp    { Mul $1 $3 }
    | Exp DIV Exp     { Div $1 $3 }
    | MINUS Exp %prec UMINUS  { Neg $2 }
    | LPAREN Exp RPAREN { $2 }
    | ID             { case $1 of ID n -> Id n }
    | FRASE          { case $1 of FRASE n -> Frase n }
    | NUM            { case $1 of NUM n -> Num n }
    | REAL           { case $1 of REAL n -> Real n }
    | TRUE           { Bool True }
    | FALSE          { Bool False }
    | Exp AND Exp    { And $1 $3 }
    | Exp OR Exp     { Or $1 $3 }
    | Exp LEQ Exp    { Eq $1 $3 }
    | Exp LEQEQ Exp  { EqEq $1 $3 }
    | Exp LNEQ Exp   { Neq $1 $3 }
    | Exp LGT Exp    { Gt $1 $3 }
    | Exp LLT Exp    { Lt $1 $3 }
    | Exp LGTEQ Exp  { Gteq $1 $3 }
    | Exp LLTEQ Exp  { Lteq $1 $3 }
    | NOT Exp        { Not $2 }
  


VarDecl : VAL ID LEQ Exp { ValDecl (case $2 of ID s -> s) $4 }
        | VAR ID LEQ Exp { VarDecl (case $2 of ID s -> s) $4 }
        --| VAL ID COLON TYPE LEQ Exp  { ValDecl (case $4 of ID s -> s) (case $2 of ID s -> s) $6 }
        --| VAR ID COLON Assign { VarDecl (case $2 of ID s -> s)  $4 }

Assign : ID LEQ Exp { Assign (case $1 of ID s -> s) $3 }

If : IF Exp Stmt {If $2 $3}
   -- | IF If Stmt {If $2 $3}

IfElse : IF Exp LBRACE Stmt RBRACE ELSE LBRACE Stmt RBRACE { IfElse $2 $4 $8 }
    --    |IF IfElse LBRACE Stmt RBRACE ELSE LBRACE Stmt RBRACE { IfElse $2 $4 $8 }


While : WHILE Exp Stmt { While $2 $3 }

Print : PRINT LPAREN Exp RPAREN { Print $3 }

Stmt : READLN LPAREN RPAREN { ReadLn }
     | VarDecl             { $1 }
     | Assign             { $1 }
     | IfElse            { $1 }
     | If  {$1}
     | While             { $1 }
     | Print    { $1 }

    
{parseError :: [Token] -> a
parseError toks = error $ "Parse error: " ++ show toks}
