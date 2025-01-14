module AST where

-- Definindo o tipo para expressões
data Expr
    = Add Expr Expr      -- Para soma
    | Sub Expr Expr      -- Para subtração
    | Mul Expr Expr      -- Para multiplicação
    | Div Expr Expr      -- Para divisão
    | Neg Expr           -- Para negação (unária)
    | Num Int            -- Para números inteiros
    deriving (Eq, Show)
