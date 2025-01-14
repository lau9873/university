
primos :: [Integer]
primos = crivo [2..]
  where
    crivo (p:xs) = p : filter (\x -> x`mod`p /= 0) (crivo xs)

listarPrimos :: Integer -> Integer -> [Integer]
listarPrimos a b = takeWhile (<=b) (dropWhile (< a) primos)