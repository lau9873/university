module CodeGen where

import AST
import IR
import TypeChecker
import Data.Map (Map)
import qualified Data.Map as Map
import Control.Monad.State

type Count = (Int, Int)

generateCode :: TypeEnv -> [Stmt] -> [Instr]
generateCode tabl stmts = evalState (transStmts tabl stmts) (0, 0)

transStmts :: TypeEnv -> [Stmt] -> State Count [Instr]
transStmts tabl stmts = concat <$> mapM (transStmt tabl) stmts

transStmt :: TypeEnv -> Stmt -> State Count [Instr]
transStmt tabl (AST.Print expr) = do
    temp <- newTemp
    code <- transExpr tabl expr temp
    return $ code ++ [PRINT temp]

transStmt tabl (ValDecl var expr) = do
    temp <- newTemp
    code <- transExpr tabl expr temp
    case Map.lookup var tabl of
        Just (_, False) -> return $ code ++ [MOVE temp (getTemp var tabl)]
        _ -> error $ "Variable " ++ var ++ " cannot be declared as 'val' or not defined"

transStmt tabl (VarDecl var expr) = do
    temp <- newTemp
    code <- transExpr tabl expr temp
    case Map.lookup var tabl of
        Just (_ , True) -> return $ code ++ [MOVE temp (getTemp var tabl)]
        _ -> error $ "Variable " ++ var ++ " cannot be declared as 'var' or not defined"

transStmt tabl (Assign var expr) = do
    temp <- newTemp
    code <- transExpr tabl expr temp
    case Map.lookup var tabl of
        Just (_, True) -> return $ code ++ [MOVE (getTemp var tabl) temp]
        _ -> error $ "Variable " ++ var ++ " is not mutable or not defined"

transStmt tabl (If cond stmt) = do
    ltrue <- newLabel
    lfalse <- newLabel
    codeCond <- transCond tabl cond ltrue lfalse
    codeStmt <- transStmt tabl stmt
    return $ codeCond ++ [LABEL ltrue] ++ codeStmt ++ [LABEL lfalse]

transStmt tabl (IfElse cond stmt1 stmt2) = do
    ltrue <- newLabel
    lfalse <- newLabel
    lend <- newLabel
    codeCond <- transCond tabl cond ltrue lfalse
    codeThen <- transStmt tabl stmt1
    codeElse <- transStmt tabl stmt2
    return $ codeCond ++ [LABEL ltrue] ++ codeThen ++ [JUMP lend, LABEL lfalse] ++ codeElse ++ [LABEL lend]

transStmt tabl (While cond stmt) = do
    lcond <- newLabel
    lbody <- newLabel
    lend <- newLabel
    codeCond <- transCond tabl cond lbody lend
    codeBody <- transStmt tabl stmt
    return $ [LABEL lcond] ++ codeCond ++ [LABEL lbody] ++ codeBody ++ [JUMP lcond, LABEL lend]

transExpr :: TypeEnv -> Expr -> Temp -> State Count [Instr] -- meter variaveis em temporarios, por ser tac
transExpr tabl (Num n) dest = return [MOVEI dest n]
transExpr tabl (Real r) dest = return [MOVEF dest r]
transExpr tabl (Bool b) dest = return [MOVE_BOOL dest b]
transExpr tabl (Id var) dest = do
    case Map.lookup var tabl of
        Just (_, False) -> return [MOVE dest (getTemp var tabl)]
        Just (_, True)  -> return [MOVE dest (getTemp var tabl)]
        Nothing         -> error $ "Variable " ++ var ++ " not defined"
transExpr tabl (AST.Add e1 e2) dest = transBinOp tabl IR.Add e1 e2 dest
transExpr tabl (AST.Sub e1 e2) dest = transBinOp tabl IR.Sub e1 e2 dest
transExpr tabl (AST.Mul e1 e2) dest = transBinOp tabl IR.Mul e1 e2 dest
transExpr tabl (AST.Div e1 e2) dest = transBinOp tabl IR.Div e1 e2 dest
transExpr tabl (AST.And e1 e2) dest = transBinOp tabl IR.And e1 e2 dest 
transExpr tabl (AST.Or e1 e2) dest = transBinOp tabl IR.Or e1 e2 dest
transExpr _ _ _  = error "Unhandled case in transExpr"

transBinOp :: TypeEnv -> BinOp -> Expr -> Expr -> Temp -> State Count [Instr]
transBinOp tabl op e1 e2 dest = do
    temp1 <- newTemp
    temp2 <- newTemp
    code1 <- transExpr tabl e1 temp1
    code2 <- transExpr tabl e2 temp2
    return $ code1 ++ code2 ++ [OP op dest temp1 temp2] -- como estou a usar tac, temos de dar assign das expressoes a temporarios e depois fazer as operações

transCond :: TypeEnv -> Expr -> Label -> Label -> State Count [Instr]
transCond tabl (AST.Eq e1 e2) ltrue lfalse = transCondOp tabl IR.Eq e1 e2 ltrue lfalse
transCond tabl (AST.Gt e1 e2) ltrue lfalse = transCondOp tabl IR.Gt e1 e2 ltrue lfalse
transCond tabl (AST.Lt e1 e2) ltrue lfalse = transCondOp tabl IR.Lt e1 e2 ltrue lfalse
transCond tabl (AST.Gteq e1 e2) ltrue lfalse = transCondOp tabl IR.Gteq e1 e2 ltrue lfalse
transCond tabl (AST.Lteq e1 e2) ltrue lfalse = transCondOp tabl IR.Lteq e1 e2 ltrue lfalse
transCond tabl (AST.EqEq e1 e2) ltrue lfalse = transCondOp tabl IR.EqEq e1 e2 ltrue lfalse
transCond tabl (AST.Neq e1 e2) ltrue lfalse = transCondOp tabl IR.Neq e1 e2 ltrue lfalse
transCond tabl (AST.Not e) ltrue lfalse = do
    transCond tabl e lfalse ltrue
transCond _ _ _ _ = error "Unhandled case in transCond"

transCondOp :: TypeEnv -> BinOp -> Expr -> Expr -> Label -> Label -> State Count [Instr]
transCondOp tabl op e1 e2 ltrue lfalse = do
    temp1 <- newTemp
    temp2 <- newTemp
    code1 <- transExpr tabl e1 temp1
    code2 <- transExpr tabl e2 temp2
    return $ code1 ++ code2 ++ [COND temp1 op temp2 ltrue lfalse] -- como estou a usar tac, temos de dar assign das expressoes a temporarios e depois comparar os temporarios

newTemp :: State Count Temp -- para ter as variaveis temporarias ex: t1, t2 ...
newTemp = do
    (t, l) <- get
    put (t + 1, l)
    return $ "t" ++ show t

newLabel :: State Count Label -- para ter as labels ordenadas ex: l1, l2 ...
newLabel = do
    (t, l) <- get
    put (t, l + 1)
    return $ "L" ++ show l

getTemp :: String -> TypeEnv -> Temp -- para ir buscar as variavel que usei anteriomente e fazer assign por exemplo ou comparar
getTemp var tabl =
    case Map.lookup var tabl of
        Just (_, _) -> var
        Nothing -> error $ "Variable " ++ var ++ " not declared"
