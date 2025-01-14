module AST where


data Expr
    = Add Expr Expr      
    | Sub Expr Expr      
    | Mul Expr Expr      
    | Div Expr Expr      
    | Neg Expr           
    | Num Int            
    | Id String
    | Frase String
    | Real Double           
    | Bool Bool          
    | And Expr Expr      
    | Or Expr Expr       
    | Eq Expr Expr     
    | EqEq Expr Expr    
    | Neq Expr Expr      
    | Gt Expr Expr      
    | Lt Expr Expr       
    | Gteq Expr Expr     
    | Lteq Expr Expr     
    | Not Expr            
    deriving (Show, Eq)

data Stmt
    = Print Expr       
    | ReadLn             
    | ValDecl String Expr 
    | VarDecl String Expr 
    | Assign String Expr  
    | IfElse Expr Stmt Stmt 
    | If Expr Stmt
    | While Expr Stmt     
    deriving (Show, Eq)