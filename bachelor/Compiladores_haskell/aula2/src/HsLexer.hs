{-
  Um analisador lexical simples em Haskell
-}
module Main where

import Data.Char (isDigit, isSpace, isAlpha, isAlphaNum)

-- Tipo algébrico para tokens;
-- alguns dos casos ainda não estão implementados
data Token = ID String       -- e.g. xy123
           | NUM Int         -- e.g. 123
           | REAL Float      -- e.g. 123.45
           | LPAREN          -- (
           | RPAREN          -- )
           | LBRACE          -- {
           | RBRACE          -- }
           | COMMA           -- ,
           | SEMICOLON       -- ;
           | IF              -- if
           | WHILE           -- while
           | FOR             -- for
           | INT             -- int
           | FLOAT           -- float
           deriving (Eq,Show)

--
-- transformar lista de carateres numa lista de tokens
--
lexer :: [Char] -> [Token]
lexer [] = []
lexer (',':xs) = COMMA : lexer xs
lexer (';':xs) = SEMICOLON : lexer xs
lexer ('(':xs) = LPAREN : lexer xs
lexer (')':xs) = RPAREN  : lexer xs
lexer ('{':xs) = LBRACE : lexer xs
lexer ('}':xs) = RBRACE  : lexer xs
lexer (x:xs)
  | isSpace x = lexer xs        -- consumir carateres brancos
lexer (x:xs)        
  | isDigit x = lexerNumb (x:xs') : lexer xs''
  where xs' = takeWhile (\i -> isAlphaNum i ||  i=='.') xs 
        xs''= dropWhile (\i -> isAlphaNum i ||  i=='.') xs
lexer (x:xs)        
  | isAlpha x = lexerText (x:xs') : lexer xs''
  | x == '_' = lexerText (x:xs') : lexer xs''
  where xs' = takeWhile (\i -> isAlphaNum i ||  i=='_') xs 
        xs''= dropWhile (\i -> isAlphaNum i ||  i=='_') xs
lexer ('/':y:xs)
  | y=='/' = lexer xs'
  | y=='*' = lexer xs''
  where xs'= dropWhile (/= '\n') xs
        xs'' = ignore xs
lexer (x:_)       -- outros carateres: erro
  = error ("invalid character: " ++ show x)

ignore :: [Char] -> [Char]
ignore ('*':'/':xs) = xs
ignore (x:xs) = ignore xs


-- função auxiliar para distinguir palavras reservadas de identificadores
lexerText :: String -> Token
lexerText "if" = IF
lexerText "while" = WHILE
lexerText "for" = FOR
lexerText "int" = INT
lexerText "float" = FLOAT        
lexerText xs   = ID xs

lexerNumb :: String -> Token
lexerNumb x  
  | '.' `elem` x = REAL (read x) -- o read é para transformar num digito
  | otherwise = NUM (read x)

-- ler toda a entrada e imprimir a lista de tokens
main :: IO ()
main = do
  txt <- getContents
  print (lexer txt)

  
