module Test where -- o nome do modulo tem de ser o nome do ficheiro

import Interpreter


-- alguns programas sequênciais para testes

-- a = 5+3; b = a-2;
example1 :: Stm
example1 =
  CompoundStm
  (AssignStm "a"
    (OpExp (NumExp 5) Plus (NumExp 3))
  )
  (AssignStm "b"
    (OpExp (IdExp "a") Minus (NumExp 2))
  )

  
-- a = 5+3; a++; b = a*2;
example2 :: Stm
example2 =
  CompoundStm
  (AssignStm "a" (OpExp (NumExp 5) Plus (NumExp 3)))
  (CompoundStm
   (IncrStm "a")
   (AssignStm "b" (OpExp (IdExp "a") Times (NumExp 2)))
  )

-- a = 2; a++; b = a+1; c = b+1;
example3 :: Stm
example3 =
  CompoundStm
  (AssignStm "a" (NumExp 2))
  (CompoundStm
   (IncrStm "a")
   (CompoundStm
    (AssignStm "b" (OpExp (IdExp "a") Plus (NumExp 1)))
    (AssignStm "c" (OpExp (IdExp "b") Plus (NumExp 1)))))





