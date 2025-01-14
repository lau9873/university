module MIPS where
import IR
import qualified Data.Set as Set
import Data.Maybe (fromMaybe)

binOpToStr :: BinOp -> String
binOpToStr Add  = "add"
binOpToStr Sub  = "sub"
binOpToStr Mul  = "mul"
binOpToStr Div  = "div"
binOpToStr And  = "and"
binOpToStr Or   = "or"
binOpToStr EqEq = "beq"
binOpToStr Neq  = "bne"
binOpToStr Lt   = "blt"
binOpToStr Lteq = "ble"
binOpToStr Gt   = "bgt"
binOpToStr Gteq = "bge"

generateMIPS :: [Instr] -> String
generateMIPS = concatMap genMIPS

genMIPS :: Instr -> String
genMIPS (LABEL l)          = l ++ ":\n"
genMIPS (MOVE x y)         = "move " ++ x ++ ", " ++ y ++ "\n"
genMIPS (MOVEI x k)        = "li " ++ x ++ ", " ++ show k ++ "\n"
genMIPS (MOVEF x k)        = "l.s " ++ x ++ ", " ++ show k ++ "\n" -- floats
genMIPS (MOVE_BOOL x val)  = "li " ++ x ++ ", " ++ (if val then "1" else "0") ++ "\n"-- booleans
genMIPS (OP op x y z)      = binOpToStr op ++ " " ++ x ++ ", " ++ y ++ ", " ++ z ++ "\n"
--genMIPS (OPI op x y k)     = binOpToStr op ++ " " ++ x ++ ", " ++ y ++ ", " ++ show k ++ "\n" --nao defini no codegen
genMIPS (JUMP label)       = "j " ++ label ++ "\n"
genMIPS (COND x op y l1 l2) = "b" ++ binOpToStr op ++ " " ++ x ++ ", " ++ y ++ ", " ++ l1 ++ "\n" ++ "j " ++ l2 ++ "\n" -- so salta para a label se for verdade, senao continua para o jump seguinte
genMIPS (PRINT x)          = "li $v0, 1\nmove $a0, " ++ x ++ "\nsyscall" ++ "\n"-- print v0 tem de ser 1 para print

ssh -i id_ed25519 isilva@khompanhia.dcc.fc.up.pt -oProxyCommand="ssh -i id_ed25519 ihaveakey@jump.dcc.fc.up.pt  -W %h:%p"