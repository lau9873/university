DROP VIEW STREAM_COUNT_BY_COUNTRY;

CREATE VIEW STREAM_COUNT_BY_COUNTRY(Country,StreamCount)
AS 
SELECT CUSTOMER.Country,COUNT(STREAM.StreamId)
FROM CUSTOMER LEFT JOIN STREAM ON(STREAM.CustomerId=CUSTOMER.CustomerId)
GROUP BY CUSTOMER.Country;