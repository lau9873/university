SELECT S1.Name AS A1, S2.Name AS A2, COUNT(*) AS N
FROM ACTOR S1 JOIN ACTOR S2 JOIN MOVIE_ACTOR S3 JOIN MOVIE_ACTOR S4
ON(S1.ActorId=S3.ActorId AND S2.ActorId=S4.ActorId)
WHERE S3.MovieId=S4.MovieId AND S1.Name!=S2.Name
GROUP BY A1,A2
HAVING N>=4 AND A1<A2
ORDER BY N DESC, A1,A2;