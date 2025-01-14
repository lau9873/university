{-
  Exercícios para a Aula Laboratorial 1

  Escrever um interpretador em Haskell da sintaxe abstrata de
  programas sequenciais.

  Baseado num exercício do livro "Modern Compiler Implementation in
  ML", A. Appel.
-}

module Interpreter where
import Data.Maybe

--
-- sintaxe abstrata de programas sequenciais
--
type Ident = String  -- identificadores (nomes de variaveis)

data BinOp = Plus | Minus | Times | Div -- operações binárias
           deriving (Eq, Show)

data Stm = AssignStm Ident Exp   -- ident = exp
         | IncrStm Ident         -- ident++
         | CompoundStm Stm Stm   -- stm1; stm2
         deriving (Eq, Show)

data Exp = IdExp Ident           -- x, y, z ..
         | NumExp Int            -- 123
         | OpExp Exp BinOp Exp   -- e1+e2, e1*e2, ...
         deriving (Eq, Show)

interpStm1 :: Stm -> Table -> Table
interpStm1 ( AssignStm ident exp ) table = (ident, interpExp1 exp table) : filter (\(i, _) -> i /= ident) table
interpStm1 ( IncrStm ident ) table = (ident, fromMaybe 0 (lookup ident table) + 1) : filter (\(i, _) -> i /= ident) table
interpStm1 ( CompoundStm stm1 stm2 ) table = interpStm1 stm2 (interpStm1 stm1 table)

interpExp1 :: Exp -> Table -> Int
interpExp1 (IdExp ident) table = fromMaybe 0 (lookup ident table)
interpExp1 (NumExp int) table = int
interpExp1 (OpExp exp1 binOp exp2) table  
  | binOp ==  Plus = interpExp1 exp1 table + interpExp1 exp2 table
  | binOp == Minus = interpExp1 exp1 table - interpExp1 exp2 table
  | binOp == Times = interpExp1 exp1 table * interpExp1 exp2 table
  | binOp == Div = interpExp1 exp1 table `div` interpExp1 exp2 table
  

{- Exercício 1.

Escrever duas funções recursivas para listar todos os identificadores
em comandos e expressões.

NOTA: escreva uma equação para cada construtor da sintaxe abstrata
acima. A função idsStm deve chamar idsExpr os comandos contêm sub-expressões.
-}
mynub :: [Ident] -> [Ident]
mynub [] = []
mynub (x:xs) 
  | x `elem` xs = mynub xs
  | otherwise = x:mynub xs

idsStm :: Stm -> [Ident]
idsStm (AssignStm ident exp) = mynub (ident : idsExp exp)
idsStm (IncrStm ident)       =  [ident]
idsStm (CompoundStm stm1 stm2) =  mynub (idsStm stm1 ++ idsStm stm2)


idsExp :: Exp -> [Ident]
idsExp (IdExp ident)       = [ident]
idsExp (NumExp _)          = []
idsExp (OpExp exp1 _ exp2) = mynub (idsExp exp1 ++ idsExp exp2)


-- NB: o que acontece se um identificador ocorrer mais do que uma vez?


{- Exercício 2: um interpretador funcional 

Escreva duas funções mutuamente recursivas para interpretar comandos
e expressões.

Represente tabelas associações de valores (inteiros) aos
identificadores como listas de pares.
Por exemplo, a lista [("x", 2), ("y", 0)] associa x -> 2, y -> 0.

Sugestões: use a função do prelúdio

lookup :: Eq a => a -> [(a,b)] -> Maybe b

para procurar o valor (se existir) associado a um identificador.
-}

type Table = [(Ident, Int)]    

interpStm :: Stm -> Table -> Table
interpStm (AssignStm ident exp) table = 
  let val = interpExp exp table
  in (ident, val) : filter (\(i, _) -> i /= ident) table  -- Atualiza ou adiciona a nova associação
interpStm (IncrStm ident) table =
  let val = interpExp (IdExp ident) table  -- Obtém o valor atual ou 0 se não existir
  in (ident, val + 1) : filter (\(i, _) -> i /= ident) table  -- Incrementa o valor
interpStm (CompoundStm stm1 stm2) table =
  let newTable = interpStm stm1 table  -- Interpreta o primeiro comando
  in interpStm stm2 newTable  -- Interpreta o segundo comando

interpExp :: Exp -> Table -> Int
interpExp (IdExp ident) table = fromMaybe 0 (lookup ident table)  -- Retorna 0 se o identificador não estiver na tabela
interpExp (NumExp n) _ = n  -- Retorna o número diretamente
interpExp (OpExp exp1 op exp2) table =
  let val1 = interpExp exp1 table  -- Avalia a primeira expressão
      val2 = interpExp exp2 table  -- Avalia a segunda expressão
  in case op of
       Plus  -> val1 + val2
       Minus -> val1 - val2
       Times -> val1 * val2
       Div   -> val1 `div` val2  
