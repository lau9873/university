module Main where

main :: IO ()
main = do
    x <- getContents
    putStrLn ( reverse (head (lines x)) ++ concat ["\n" ++ reverse y | y<- tail(lines x)])
