module Main where

import Lexer
import Parser
import TypeChecker
import CodeGen
import qualified Data.Map as Map
import IR
import MIPS

main :: IO ()
main = do
    txt <- readFile "exemplos.txt"
    -- Lexer
    let tokens = alexScanTokens txt
    -- Parser
    let ast = parse tokens
    putStrLn "AST:"
    print ast
    
    -- Table
    let symbolTable = checkProgram ast
    putStrLn "Symbolic table: (Type, Mutable)"
    printSymbolTable symbolTable

    -- Generated IC
    let irCode = generateCode symbolTable ast  
    putStrLn "GIC:"
    print irCode

    -- MIPS
    let mipsCode = generateMIPS irCode
    putStrLn "MIPS Code:"
    putStrLn mipsCode

printSymbolTable :: Map.Map String (Type, Bool) -> IO ()
printSymbolTable symTable =
    mapM_ (\(var, typ) -> putStrLn $ var ++ ": " ++ show typ) (Map.toList symTable)
