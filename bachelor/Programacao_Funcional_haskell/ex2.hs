
digs :: Integral a => a -> [a]
digs 0 = []
digs x = digs (x `div` 10) ++ [x `mod` 10]

listaPar :: [Integer] -> [Integer] 
listaPar [] = []
listaPar [x] = [x]    
listaPar (x:y:xs) = digs (x*2) ++ [y] ++ listaPar xs
listaImpar :: [Integer] -> [Integer] 
listaImpar [] = []
listaImpar [x] = [x]    
listaImpar (x:y:xs) = [x] ++ digs (y*2) ++ listaImpar xs


validar :: Integer -> Bool
validar y 
    | sum (if even (length (digs y))  then listaPar(digs y) else listaImpar (digs y) ) `mod` 10 == 0 = True
    | otherwise = False
    
