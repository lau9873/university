module Main where

paragraphs :: String -> [String]
paragraphs "" = [""]
paragraphs ('\n':'\n':xs) = "" : paragraphs xs
paragraphs (x:'\n':'\n':xs) = [x] : paragraphs xs
paragraphs (x:xs) =  (x : head(paragraphs xs)): tail(paragraphs xs)


wordsThatFit :: Int -> [String] -> Int
wordsThatFit _ [] = 0
wordsThatFit y (x:xs)
  | length x > y = 0
  | length x == y = 1
  | length (unwords (x:xs)) <= y = length (x:xs)
  | otherwise = 1 + wordsThatFit (y - length x - 1) xs

fillWords :: Int -> [String] -> [[String]]
fillWords _ [] = []
fillWords x y = take (wordsThatFit x y ) y : fillWords x (drop (wordsThatFit x y) y)


main :: IO ()
main = do
    txt <- getContents
    let result = map (\x->  unlines [unwords y |  y<- fillWords 70 (words x)]) (paragraphs txt)
    putStr (unlines result) 

