SELECT Country,COUNT(*) AS N
FROM  STREAM RIGHT JOIN CUSTOMER
ON(STREAM.CustomerId=CUSTOMER.CustomerId)
WHERE StreamId IS NULL 
GROUP BY Country;
