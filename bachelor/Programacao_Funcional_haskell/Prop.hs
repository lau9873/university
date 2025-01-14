module Prop where

-- tipo para expressões proposicionais
data Prop = Const Bool        -- constantes
          | Var Char          -- variáveis
          | Neg Prop          -- negação
          | Conj Prop Prop    -- conjunção
          | Disj Prop Prop    -- disjunção
          | Impl Prop Prop    -- implicação
            deriving (Eq,Show)
