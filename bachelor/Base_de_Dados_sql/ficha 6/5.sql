SELECT Year,COUNT(*) AS N
From MOVIE
WHERE Duration >= 120
GROUP BY Year
HAVING N >= 20;