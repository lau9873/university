SELECT Year(StreamDate),COUNT(*),SUM(Charge)
From STREAM
GROUP BY Year(StreamDate);
