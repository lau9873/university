SELECT STREAM.StreamDate, MOVIE.Title AS N, 
CUSTOMER.Name, CUSTOMER.Country

FROM STREAM JOIN MOVIE 
JOIN CUSTOMER JOIN MOVIE_ACTOR 
JOIN ACTOR

ON(CUSTOMER.CustomerId=STREAM.CustomerId 
AND MOVIE.MovieId=STREAM.MovieId 
AND MOVIE.MovieId=MOVIE_ACTOR.MovieId
AND ACTOR.ActorId=MOVIE_ACTOR.ActorId)

WHERE CUSTOMER.Country!='China' 
AND ACTOR.Name='Johnny Depp'
AND MOVIE.MovieId NOT IN(

SELECT MOVIE.MovieId
FROM ACTOR JOIN MOVIE_ACTOR JOIN MOVIE
ON( MOVIE.MovieId=MOVIE_ACTOR.MovieId
AND ACTOR.ActorId=MOVIE_ACTOR.ActorId)
WHERE ACTOR.Name='Helena Bonham Carter'
)

ORDER BY STREAM.StreamDate DESC
LIMIT 15;
