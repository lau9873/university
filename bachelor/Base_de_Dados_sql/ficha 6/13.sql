SELECT CUSTOMER.Name AS N,MAX(STREAM.Charge)AS C FROM CUSTOMER JOIN STREAM ON(STREAM.CustomerId=CUSTOMER.CustomerId) WHERE CUSTOMER.Country='United States' AND YEAR(StreamDate)=2018 GROUP BY CUSTOMER.Name ORDER BY C DESC,N ;