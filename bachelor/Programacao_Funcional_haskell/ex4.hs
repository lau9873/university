import Log
import Log (LogEntry(Unknown))

parseMessage :: String -> LogEntry
parseMessage a
    | head (words a) == "I" = LogMessage Info (read (head (tail (words a)))::Int) (unwords (tail (tail (words a))))
    | head (words a) == "W" = LogMessage Warning (read (head (tail (words a)))::Int) (unwords (tail (tail (words a))))
    | head (words a) == "E" = LogMessage (Error (read (head (tail (words a)))::Int)) (read (head (tail (tail (words a))))::Int) (unwords (tail (tail (tail (words a)))))
    | otherwise = Unknown a
    
insert :: LogEntry -> MessageTree -> MessageTree
insert (Unknown a) tree = tree 
insert a Empty = Node a Empty Empty
insert (LogMessage MessageType TimeStamp1 String) (Node (LogMessage MessageType TimeStamp2 String) esq dir)
    | TimeStamp1 < TimeStamp2 = Node y (insert x esq) dir
    | TimeStamp1 >= TimeStamp2 = Node y esq (insert x dir)



