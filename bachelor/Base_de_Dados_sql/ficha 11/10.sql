DROP FUNCTION IF EXISTS bonus;
DELIMITER $

CREATE FUNCTION bonus(staff_id INT, year INT)
RETURNS INT
BEGIN
  DECLARE value INT;
  DECLARE n INT;
  DECLARE s INT;
  DECLARE r INT;
  
  SELECT COUNT(STREAM.StreamId) INTO n
  FROM STREAM 
  WHERE MONTH(StreamDate)=12
  AND YEAR(StreamDate)= year 
  GROUP BY MONTH(StreamDate);
  
  SELECT COUNT(S1.StaffId) INTO s
  FROM STAFF S1 
  RIGHT JOIN STAFF S2 ON(S1.Supervisor=S2.StaffId)
  WHERE S2.StaffId=staff_id
  GROUP BY S2.StaffId;
  
  SELECT COUNT(REGION.RegionId) INTO r
  FROM REGION 
  RIGHT JOIN STAFF ON(REGION.RegionManager=STAFF.StaffId)
  WHERE STAFF.StaffId=staff_id
  GROUP BY STAFF.StaffId;
  
  SET value = n * ( s + r + 1 );
  
  IF value < 300 THEN
	SET value = 300;
  END IF;
  
  IF value > 2000 THEN
	SET value = 2000;
  END IF;
  
  RETURN value;
END$

DELIMITER ;
