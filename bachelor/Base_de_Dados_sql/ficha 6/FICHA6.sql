/*--FICHA 6----*/
/* EX 1 */
SELECT Title,Year
From MOVIE
where Duration >= 180;

/* EX2 */
SELECT Name,City,Country
From CUSTOMER
where Name LIKE "Ch%";

/* EX3 */
SELECT SUM(Charge)
From STREAM
where Year(StreamDate)=2018;

/* EX4 */
SELECT Year(StreamDate),COUNT(*),SUM(Charge)
From STREAM
GROUP BY Year(StreamDate);

/* EX5 */
SELECT Year,COUNT(*) AS N
From MOVIE
WHERE Duration >= 120
GROUP BY Year
HAVING N >= 20;

/* EX6 */
SELECT StaffId
From STAFF
WHERE Supervisor is NULL
UNION 
SELECT Manager
FROM DEPARTMENT;

/* EX7 */
SELECT DepId,DEPARTMENT.Name,Manager,STAFF.Name
From DEPARTMENT,STAFF
WHERE Manager=StaffId;

/* EX8 */
SELECT Title, Name 
FROM MOVIE 
NATURAL JOIN MOVIE_ACTOR 
NATURAL JOIN ACTOR 
WHERE Title LIKE '%Superman%';

/* EX9 */
SELECT Title, Duration, Year, StreamDate 
FROM MOVIE NATURAL JOIN STREAM 
WHERE Duration >= 140 AND Year=YEAR(StreamDate)-1;

/* EX10 */
SELECT REGION.Name, COUNT(*) AS N
FROM REGION JOIN COUNTRY JOIN CUSTOMER
ON(REGION.RegionId=COUNTRY.RegionId AND COUNTRY.Name=CUSTOMER.Country)
GROUP BY REGION.Name;

/* EX11 */
SELECT REGION.Name, STAFF.Name 
FROM REGION JOIN STAFF ON(REGION.RegionManager=StaffId) 
ORDER BY REGION.Name;

/* EX12 */
SELECT REGION.Name AS Name, COUNT(*) AS N 
FROM REGION JOIN COUNTRY ON(REGION.RegionId=COUNTRY.RegionId) 
GROUP BY Name ORDER BY N;

/* EX13 */
SELECT CUSTOMER.Name AS N,MAX(STREAM.Charge)AS C 
FROM CUSTOMER JOIN STREAM ON(STREAM.CustomerId=CUSTOMER.CustomerId) 
WHERE CUSTOMER.Country='United States' AND YEAR(StreamDate)=2018 
GROUP BY CUSTOMER.Name 
ORDER BY C DESC,N ;

/* EX14 */
SELECT MOVIE.Title 
FROM ACTOR NATURAL JOIN MOVIE_ACTOR NATURAL JOIN MOVIE 
WHERE ACTOR.Name='Tom Cruise' 
ORDER BY MOVIE.Title;

/* EX15 */
SELECT ACTOR.Name, COUNT(*) AS N 
FROM ACTOR NATURAL JOIN MOVIE_ACTOR 
GROUP BY ACTOR.Name 
ORDER BY N DESC,ACTOR.Name LIMIT 20;

/* EX16 */
SELECT DISTINCT CUSTOMER.Name AS N
FROM CUSTOMER JOIN STREAM JOIN MOVIE 
ON (CUSTOMER.CustomerId=STREAM.CustomerId 
AND MOVIE.MovieId=STREAM.MovieId)         
WHERE HOUR(STREAM.StreamDate)>=20
AND MOVIE.Duration>=180
ORDER BY N;




