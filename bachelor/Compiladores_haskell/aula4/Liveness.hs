module Liveness where

import           IR

import           Data.Set (Set)
import qualified Data.Set as Set

import           Data.Map (Map, (!))
import qualified Data.Map as Map

import           Data.List (nub)


type Index = Int         -- index for instructions

type Gen  = Map Index (Set Temp)  -- generated temporaries
type Kill = Map Index (Set Temp)  -- killed temporaries
type Succ = Map Index [Index]     -- sucessors of each instruction

type In = Map Index (Set Temp)    -- in and out mappings
type Out = Map Index (Set Temp)


gen :: Instr -> Set Temp
gen (LABEL _)        = Set.empty
gen (MOVE x y)       = Set.singleton y  -- gerado temporário é o valor que é atribuído
gen (MOVEI x k)      = Set.empty         -- não gera temporários, apenas atribui valor imediato
gen (OP _ x y z)     = Set.fromList [y, z]  -- gera temporários para os operandos
gen (OPI _ x y k)    = Set.singleton y  -- gera temporário apenas para o operando y
gen (JUMP _)         = Set.empty         -- não gera temporários
gen (COND x _ y _ _) = Set.fromList [x, y]  -- gera temporários para as expressões condicionais
gen (CALL x f args)  = Set.fromList (x : args)  -- gera temporários para o resultado da chamada e para os argumentos
gen (RETURN (Just x)) = Set.singleton x  -- gera temporário para o valor de retorno
gen (RETURN Nothing)  = Set.empty         -- não gera temporário se não houver retorno
gen (MOVEF _ _)       = Set.empty         -- MOVEF não gera temporários
gen (MOVE_BOOL _ _)   = Set.empty         -- MOVE_BOOL não gera temporários
gen _ = Set.empty  -- Adicionando um padrão genérico para outros casos

kill :: Instr -> Set Temp
kill (LABEL _)        = Set.empty
kill (MOVE x y)       = Set.singleton x  -- mata o temporário x
kill (MOVEI x k)      = Set.singleton x  -- mata o temporário x
kill (OP _ x y z)     = Set.singleton x  -- mata o temporário x
kill (OPI _ x y k)    = Set.singleton x  -- mata o temporário x
kill (JUMP _)         = Set.empty
kill (COND x _ y _ _) = Set.empty         -- não mata temporários diretamente
kill (CALL x f args)  = Set.singleton x  -- mata o temporário x
kill (RETURN (Just x)) = Set.singleton x  -- mata o temporário x
kill (RETURN Nothing)  = Set.empty         -- não mata temporários
kill (MOVEF _ _)       = Set.empty         -- MOVEF não mata temporários
kill (MOVE_BOOL _ _)   = Set.empty         -- MOVE_BOOL não mata temporários
kill _ = Set.empty

generated :: [Instr] -> Gen
generated code
  = Map.fromList $ zip [1..] (map gen code)

killed :: [Instr] -> Kill
killed code
  = Map.fromList $ zip [1..] (map kill code)


successors :: [Instr] -> Succ
successors code = Map.fromList $ zip [1..] $ zipWith next [1..] code
  where
    labels = Map.fromList [ (l,i) | (LABEL l, i) <- zip code [1..] ]
   
    next i (JUMP l) = case Map.lookup l labels of
                         Just idx -> [idx]
                         Nothing  -> error $ "Rótulo não encontrado para JUMP: " ++ show l
    next i (COND x op y l1 l2) = case (Map.lookup l1 labels, Map.lookup l2 labels) of
                                    (Just idx1, Just idx2) -> [idx1, idx2]
                                    _ -> error $ "Rótulos não encontrados para COND: " ++ show (l1, l2)
    next i (RETURN x) =  []
    next i _ =  [i+1]


                

-- liveness analysis; main entry point
-- results is number of iterations plus in-out mappings
liveness :: [Instr] -> (Int, (In, Out))
liveness code = fixpointIters (iteration succ gen kill) (inp0, out0)
  where
    n = length code
    inp0 = Map.fromList $ zip [1..n] (repeat Set.empty)
    out0 = inp0
    gen = generated code
    kill = killed code
    succ = successors code


iteration :: Succ -> Gen -> Kill -> (In, Out) -> (In, Out)
iteration succ gen kill (inp, out) = iterationAux (Map.keys inp) inp out
  where
    -- Função auxiliar que itera sobre as instruções
    iterationAux [] inp out = (inp, out)
    iterationAux (i:ixs) inp out =
      let
        -- Calculando o novo conjunto de variáveis "out" para a instrução i
        out_i = Set.unions [Map.findWithDefault Set.empty j inp | j <- Map.findWithDefault [] i succ]
        
        -- Calculando o novo conjunto de variáveis "in" para a instrução i
        in_i = Set.union (Map.findWithDefault Set.empty i gen) 
                          (Set.difference out_i (Map.findWithDefault Set.empty i kill))
        
        -- Atualizando os mapas "inp" e "out"
        out'  = Map.insert i out_i out
        inp'  = Map.insert i in_i inp
      in
        -- Recursão com os mapas atualizados
        iterationAux ixs inp' out'



fixpoint :: Eq a => (a -> a) -> a -> a
fixpoint next initial = go initial 1
   where go x !k = let y = next x
                    in if x == y then x
                       else if k > 1000 then error "Limite de iterações atingido em fixpoint"
                       else go y (k + 1)

-- same as above but also returns the number of iterations performed
fixpointIters :: Eq a => (a -> a) -> a -> (Int, a)
fixpointIters next initial = go initial 1
   where go x !k = let y = next x
                    in if x==y then (k, x) else go y (k+1)


interference :: [Instr] -> Set (Temp, Temp)
interference code
  = Set.fromList [ (x,y)
                 | (i, instr) <- zip [1..] code
                 , x <- Set.toList (kill!i)
                 , y <- Set.toList (out!i)
                 , x /= y, instr /= MOVE x y
                 , case Map.lookup i out of
                       Just _  -> True
                       Nothing -> error $ "Valor de 'out' não encontrado para instrução " ++ show i
                 ]
   where
     (_, (_, out)) = liveness code
     kill = killed code
