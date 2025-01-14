module Main where

main :: IO ()
main = do 
    x <- getContents
    print (length(lines x))
    print (length(words x))
    print (length x)




