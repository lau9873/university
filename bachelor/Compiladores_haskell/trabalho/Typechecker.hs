module TypeChecker where

import AST
import qualified Data.Map as Map
import Data.Map (Map)

data Type
    = TyInt       
    | TyDouble    
    | TyString    
    | TyBool      
    | TyUnit      
    deriving (Show, Eq)

type TypeEnv = Map String (Type, Bool)  -- Variáveis mutáveis (True = var, False = val)


checkExpr :: TypeEnv -> Expr -> Type
checkExpr env (Num _) = TyInt
checkExpr env (Real _) = TyDouble
checkExpr env (Frase _) = TyString
checkExpr env (Bool _) = TyBool
checkExpr env (Id var) =
    case Map.lookup var env of
        Just (ty, _) -> ty
        Nothing -> error $ "Variable not declared: " ++ var -- não posso usar variáveis que não declarei
checkExpr env (Add e1 e2) = checkBinOp env e1 e2 [TyInt, TyDouble]
checkExpr env (Sub e1 e2) = checkBinOp env e1 e2 [TyInt, TyDouble]
checkExpr env (Mul e1 e2) = checkBinOp env e1 e2 [TyInt, TyDouble]
checkExpr env (Div e1 e2) = checkBinOp env e1 e2 [TyInt, TyDouble]
checkExpr env (And e1 e2) = checkBinOp env e1 e2 [TyBool]
checkExpr env (Or e1 e2) = checkBinOp env e1 e2 [TyBool]
checkExpr env (Eq e1 e2) = checkEquality env e1 e2
checkExpr env (EqEq e1 e2) = checkEquality env e1 e2
checkExpr env (Neq e1 e2) = checkEquality env e1 e2
checkExpr env (Gt e1 e2) = checkComparison env e1 e2
checkExpr env (Lt e1 e2) = checkComparison env e1 e2
checkExpr env (Gteq e1 e2) = checkComparison env e1 e2
checkExpr env (Lteq e1 e2) = checkComparison env e1 e2
checkExpr env (Not e) =
    let t = checkExpr env e
    in if t == TyBool then TyBool else error "Type error in 'Not'"


checkBinOp :: TypeEnv -> Expr -> Expr -> [Type] -> Type
checkBinOp env e1 e2 allowedTypes =
    let t1 = checkExpr env e1
        t2 = checkExpr env e2
    in if t1 == t2 && t1 `elem` allowedTypes
       then t1
       else if t1 `elem` [TyInt, TyDouble] && t2 `elem` [TyInt, TyDouble]
            then TyDouble
            else error "Type error in binary operation"

checkEquality :: TypeEnv -> Expr -> Expr -> Type
checkEquality env e1 e2 =
    let t1 = checkExpr env e1
        t2 = checkExpr env e2
    in if t1 == t2 || (t1 `elem` [TyInt, TyDouble] && t2 `elem` [TyInt, TyDouble])
       then TyBool
       else error "Type error in equality comparison"
       
checkComparison :: TypeEnv -> Expr -> Expr -> Type
checkComparison env e1 e2 =
    let t1 = checkExpr env e1
        t2 = checkExpr env e2
    in if t1 `elem` [TyInt, TyDouble] && t2 `elem` [TyInt, TyDouble]
       then TyBool
       else error "Type error in comparison"

checkStmt :: TypeEnv -> Stmt -> TypeEnv
checkStmt env (Print expr) =
    checkExpr env expr `seq` env
checkStmt env (ValDecl var expr) =
    let typ = checkExpr env expr
    in if Map.member var env
       then error $ "Variable already declared: " ++ var
       else Map.insert var (typ, False) env  -- False indica que é imutável (val)
checkStmt env (VarDecl var expr) =
    let typ = checkExpr env expr
    in Map.insert var (typ, True) env  -- True indica que é mutável (var)

checkStmt env (Assign var expr) =
    case Map.lookup var env of -- verifica se posso dar assign,ou seja, se ela ja foi declarada, se é var e se estou a dar assign com o mesmo type
        Just (tyVar, isMutable) ->
            let tyExpr = checkExpr env expr
            in if not isMutable
               then error $ "Cannot reassign to val: " ++ var
               else if tyVar == tyExpr
                    then env 
                    else if tyVar == TyInt && tyExpr == TyDouble
                         then Map.insert var (TyDouble, isMutable) env  -- posso TyInt -> TyDouble mas não o contrário
                         else error $ "Type mismatch in assignment for variable: " ++ var
        Nothing -> error $ "Variable not declared: " ++ var

checkStmt env (If cond thenStmt) =
    let condType = checkExpr env cond
    in if condType == TyBool
       then checkStmt env thenStmt
       else error "Condition in 'if' must be boolean"
checkStmt env (IfElse cond thenStmt elseStmt) =
    let condType = checkExpr env cond
    in if condType == TyBool
       then checkStmt (checkStmt env thenStmt) elseStmt
       else error "Condition in 'if-else' must be boolean"
checkStmt env (While cond body) =
    let condType = checkExpr env cond
    in if condType == TyBool
       then checkStmt env body
       else error "Condition in 'while' must be boolean"


checkProgram :: [Stmt] -> TypeEnv
checkProgram = foldl checkStmt Map.empty 
