/*--FICHA 8----*/
/* EX 1 */
DROP FUNCTION IF EXISTS getChargeValue;
DELIMITER $

CREATE FUNCTION
getChargeValue(stream_time DATETIME, movie_id INT, customer_id INT)
RETURNS DECIMAL(4,2)
BEGIN
  DECLARE c DECIMAL(4,2);
  DECLARE movie_duration INT;
  DECLARE country_name VARCHAR(128);
  DECLARE region_name VARCHAR(128);

  SELECT Duration INTO movie_duration
  FROM MOVIE WHERE MovieId = movie_id;

  SET c = 0.5 + 0.01 * movie_duration;

  IF HOUR(stream_time) >= 21 THEN
    SET c = c + 0.75;
    IF WEEKDAY(stream_time) >= 4 THEN
      SET c = c + 0.75;
    END IF;
  END IF;
  
  SELECT Country INTO country_name
  FROM CUSTOMER WHERE CustomerId = customer_id;
  
  SELECT REGION.Name INTO region_name
  FROM REGION JOIN COUNTRY JOIN CUSTOMER
  ON(REGION.RegionId=COUNTRY.RegionId
  AND COUNTRY.Name=CUSTOMER.Country)
  WHERE CustomerId = customer_id;
  
  IF country_name = 'United States' OR region_name = 'Europe' THEN
	SET c = c + 1;
  END IF;
   
  RETURN c;
END $
DELIMITER;

/* EX 2 */
DROP VIEW STREAM_COUNT_BY_COUNTRY;

CREATE VIEW STREAM_COUNT_BY_COUNTRY(Country,StreamCount)
AS 
SELECT CUSTOMER.Country,COUNT(STREAM.StreamId)
FROM CUSTOMER LEFT JOIN STREAM ON(STREAM.CustomerId=CUSTOMER.CustomerId)
GROUP BY CUSTOMER.Country;

/* EX 3 */
DROP VIEW DEPARTMENT_STAFF;

CREATE VIEW DEPARTMENT_STAFF(DName,SName,Job)
AS 
(SELECT DEPARTMENT.Name AS DName, S1.Name 
AS SNAME,S1.Job AS Job
FROM STAFF S1 JOIN DEPARTMENT
ON(DEPARTMENT.Manager=S1.StaffId))
UNION
(SELECT DEPARTMENT.Name AS DName, S2.Name 
AS SNAME,S2.Job AS Job
FROM STAFF S1 JOIN STAFF S2 ON(S1.StaffId=S2.Supervisor)
JOIN DEPARTMENT ON(DEPARTMENT.Manager=S1.StaffId));

/* EX 4 */
DROP FUNCTION IF EXISTS getDepartment;
DELIMITER $
CREATE FUNCTION getDepartment(staff_id INT)
RETURNS INT
BEGIN
  DECLARE dep_id INT;  
  SET dep_id = NULL;

  SELECT DEPARTMENT.DepId INTO dep_id
	FROM STAFF S1 JOIN DEPARTMENT
	ON(DEPARTMENT.Manager=S1.StaffId)
	WHERE StaffId=staff_id;
  
  
  IF dep_id IS NULL THEN
	SELECT DEPARTMENT.DepId INTO dep_id
	FROM STAFF S1 JOIN STAFF S2 ON(S1.StaffId=S2.Supervisor)
	JOIN DEPARTMENT ON(DEPARTMENT.Manager=S1.StaffId)
	WHERE S2.StaffId=staff_id;
  END IF;
  
  RETURN dep_id;
END $
DELIMITER ;
