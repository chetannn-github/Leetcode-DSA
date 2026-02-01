SELECT ROUND(SUM(tiv_2016) :: DECIMAL, 2) AS tiv_2016
FROM (
    SELECT tiv_2015, tiv_2016,lat,lon,
    COUNT(pid) OVER(PARTITION BY lat, lon),
    COUNT(tiv_2015) OVER(PARTITION BY tiv_2015) AS count_2015
    FROM Insurance
)
WHERE count = 1 AND count_2015 > 1
