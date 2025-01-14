UPDATE CUSTOMER 
SET Active = FALSE 
WHERE Country= 'China' AND CustomerId NOT IN
(SELECT CustomerId FROM STREAM);

