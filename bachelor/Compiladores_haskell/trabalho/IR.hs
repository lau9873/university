module IR (Instr(..), BinOp(..), Temp, Label) where

type Temp  = String
type Label = String

data Instr
    = MOVE Temp Temp               -- MOVE t1, t2
    | MOVEI Temp Int               -- MOVEI t1, 5
    | MOVEF Temp Double            -- MOVEF t1, 5.0
    | MOVE_BOOL Temp Bool          -- MOVE_BOOL t1, True/False
    | OP BinOp Temp Temp Temp      -- t1 = t2 OP t3
   -- | OPI BinOp Temp Temp Int      -- t1 = t2 OP 5
    | LABEL Label                  -- Label:
    | JUMP Label                   -- jump Label
    | COND Temp BinOp Temp Label Label -- if t1 OP t2 goto L1 else goto L2
    | PRINT Temp                   -- print t1
    deriving (Eq, Show)

data BinOp = Add | Sub | Mul | Div | And | Or | Eq | EqEq | Neq | Gt | Lt | Gteq | Lteq
    deriving (Eq, Show)

