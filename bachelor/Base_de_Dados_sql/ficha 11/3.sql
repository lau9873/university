SELECT DISTINCT Title
FROM MOVIE JOIN MOVIE_GENRE JOIN GENRE
ON(MOVIE.MovieId=MOVIE_GENRE.MovieId
AND MOVIE_GENRE.GenreId=GENRE.GenreId)
WHERE MOVIE.MovieId IN(
SELECT MovieId 
FROM MOVIE_GENRE NATURAL JOIN GENRE
WHERE Label='Action' )
AND MOVIE.MovieId IN(
SELECT MovieId 
FROM MOVIE_GENRE NATURAL JOIN GENRE
WHERE Label='Comedy')
ORDER BY Title;
