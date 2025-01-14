import Text.XHtml (base)
import Data.Char
--import Prelude hiding ((++))
--import Prelude hiding (reverse)
import Prelude hiding (zipWith) 
import Distribution.Simple.Utils (xargs)
import Text.Read.Lex (Number)

------------------------------------------------------------------------
--Folha 1
------------------------------------------------------------------------
-----------ex 2--------------
testaTriangulo :: Float -> Float -> Float -> Bool
testaTriangulo a b c = a<b+c && b<a+c && c<a+b
--main = print(testaTriangulo 1 2 2)

-----------ex 3--------------
areaTriangulo :: Float -> Float -> Float -> Float
areaTriangulo a b c = sqrt(s*(s-a)*(s-b)*(s-c))
    where s = ((a+b+c)/2)
--main = print(areaTriangulo 3.0 4.0 5.0)

-----------ex 6--------------
fact :: Integer -> Integer
fact 0 = 1
fact n = n * fact (n-1)
binom :: Integer -> Integer -> Integer
binom a b = fromIntegral(product[a-b+1..a]) `div` fromIntegral(fact b)

------------------------------------------------------------------------
--Folha 2
------------------------------------------------------------------------
-----------ex 2--------------
imc :: Float -> Float -> Float
imc peso altura = peso/(altura^2)
classifica :: Float -> Float -> String
classifica peso altura 
    | imcr < 18.5 = "baixo peso"
    | imcr < 25 = "peso normal"
    | imcr < 30 = "excesso de peso"
    | otherwise = "obesidade"
    where imcr = imc peso altura

-----------ex 3--------------
--import Text.XHtml (base)
max3 :: Int -> Int -> Int -> Int
max3 a b c
    | a>=b && a>=c = a
    | b>=a && b>=c = b
    | otherwise = c

-----------ex 4--------------
xor :: Bool -> Bool -> Bool
xor a b 
    | a == b = False
    | a /= b = True   

-----------ex 7--------------
mediana :: Int -> Int -> Int -> Int
mediana a b c 
    | (a >= b && a <=c) || (a >= c && a <=b) = a
    | (b >= a && b <=c) || (b >= c && b <=a) = b
    | otherwise = c

------------------------------------------------------------------------
--Folha 3
------------------------------------------------------------------------
-----------ex 1--------------
divprop :: Integer -> [Integer]
divprop x = [y | y <-[1..x-1], mod x y == 0]

-----------ex 5--------------
linha :: Integer -> [Integer]
linha n = [binom n z | z <- [0..n]]
pascal :: Integer -> [[Integer]]
pascal n = [linha y | y <- [0..n]]

-----------ex 6--------------
type Rel = ([Int], [(Int,Int)])
reflexiva :: Rel -> Bool
reflexiva (v,r) = and [(a,a) `elem` r | a <- v]
simetrica :: Rel -> Bool
simetrica (v,r) = and [(b,a) `elem` r | (a,b) <- r]
transitiva :: Rel -> Bool
transitiva (v,r) = and [(a,c) `elem` r | (a,b) <- r, (b_,c) <- r,b==b_ ]

-----------ex 7--------------
myand :: [Bool] -> Bool
myand [] = True
myand (x:xs) = x && myand xs

myor :: [Bool] -> Bool
myor [] = False
myor (x:xs) = x || myor xs

-----------ex 9--------------
--import Data.Char
forte :: String -> Bool
forte a = length a >= 8 && myor [isUpper x | x <- a, isLetter x] && myor [isLower x | x <- a, isLetter x] && myor [isNumber x | x <- a] 
        

-----------ex 12-------------
intersperse :: a -> [a] -> [a]
intersperse a [] = []
intersperse a [x] = [x]
intersperse a (x:xs) = x:a:intersperse a xs

------------------------------------------------------------------------
--Folha 4
------------------------------------------------------------------------
-----------ex 1--------------
algarismos :: Int -> [Int]
algarismos 0 = []
algarismos x =  algarismos (x `div` 10) ++ [x `mod` 10]

-----------ex 2--------------
toBits :: Int -> [Int]
toBits 0 = []
toBits x = toBits (x`div`2) ++ [x`mod`2]

-----------ex 3--------------
reverseList :: [Int] -> [Int]
reverseList [] = []
reverseList (x:xs) = reverseList xs ++ [x]

fromBitsReverse :: [Int] -> Int
fromBitsReverse [] = 0
fromBitsReverse (x:xs) = x + fromBitsReverse(map (*2) xs)

fromBits :: [Int] -> Int
fromBits x =  fromBitsReverse (reverseList x) 

-----------ex 5a-------------
insert :: (Ord a => a -> [a] -> [a])
insert x [] = [x]
insert x [y] 
    | x<=y = x:[y]
    | otherwise = y:[x]
insert x (y:z:xs) 
    | x <= y = x:y:z:xs
    | y<=x && x<=z = y:x:z:xs
    | otherwise = y:insert x (z:xs)

-----------ex 5b-------------
sort :: Ord a => [a] -> [a]
sort [] = []
sort [x] = [x]
sort (x:xs) = insert x (sort xs)

-----------ex 7a-------------
merge :: Ord a => [a] -> [a] -> [a]
merge [] [] = []
merge x [] = x
merge [] x = x
merge (x:xs) (y:ys) 
    |x<=y = x: merge xs (y:ys)
    | otherwise = y: merge ys (x:xs)

------------------------------------------------------------------------
--Folha 5
------------------------------------------------------------------------
-----------ex 2--------------
primo :: Integer -> Bool
primo x
    | x<=1 = False
    | otherwise =  all (\n->x`mod`n/=0) [2 .. floor (sqrt (fromIntegral x))]


-----------ex 3a-------------
--import Prelude hiding ((++))

-- completar esta definição
(+++) :: [a] -> [a] -> [a]
xs +++ ys = foldr f z lista
    where f     = (:)
          z     = ys
          lista = xs
-----------ex 3c-------------
-- esconder a definição do prelúdio 
--import Prelude hiding (reverse)

-- completar esta definição
reversee :: [a] -> [a]
reversee xs = foldr f z xs
    where f elem acc = acc ++ [elem]
          z     = []

-----------ex 5--------------
--import Prelude hiding (zipWith) 
-- esconder a definição do prelúdio

zipWith :: (a -> b -> c) -> [a] -> [b] -> [c]
zipWith f [] x = []
zipWith f x [] = []
zipWith f (x:xs) (y:ys) =  f x y : zipWith f xs ys 

-----------ex 7--------------
palavras :: String -> [String]
palavras "" = []
palavras x 
    |  resto == "" = []
    | otherwise = takeWhile (/= ' ') resto: palavras (dropWhile (/= ' ') resto)
    where resto = dropWhile (==' ') x

-----------ex 9--------------
combine1::(Num a, Fractional a) => a -> a -> a
combine1 a b = a/b

aproxPi1::Int -> Double
aproxPi1 a = sum (zipWith combine1 (take a [4,4..]) (zipWith combine1 (take a [1,3..]) (take a (cycle [1,-1]))  ))

baixo::[Double]
baixo = [(x-1) * x * (x+1)| x<-[3,5..] ] 

aproxPi2::Int -> Double
aproxPi2 b = sum (3:zipWith combine1 (zipWith combine1 (take (b-1) [4,4..]) (take (b-1) (cycle [1,-1])))(take (b-1) baixo) )
 -----------ex 10-------------
pascal2::[[Integer]]
pascal2 = [[binom n k|k <- [0..n]]|n<-[0..]]



-----------ex 11-------------
--goldbach :: Integer -> (Integer, Integer)
--goldbach a = 



