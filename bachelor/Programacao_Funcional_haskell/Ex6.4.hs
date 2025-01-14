module Main where
import Data.Char

main :: IO ()
main = do
    x <- getContents
    putStr (map cesar x)


cesar:: Char -> Char
cesar x 
    | 97 <= ord x && ord x <= 109 = chr(ord x + 13)
    | 109 < ord x  && ord x <= 122 = chr(ord x - 122 + 97 + 13 - 1)
    | 65 <= ord x && ord x <= 77 = chr(ord x + 13)
    | 77 < ord x && ord x <= 90 = chr(ord x - 90 + 65 + 13 - 1)
    | otherwise = x





