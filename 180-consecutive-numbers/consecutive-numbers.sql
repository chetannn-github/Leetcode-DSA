WITH mod_logs AS(
    SELECT num, LAG(num,1) OVER() AS prev, LAG(num,2) OVER() AS next_prev
    FROM Logs
)

SELECT DISTINCT num AS ConsecutiveNums
FROM mod_logs
WHERE num = prev AND num = next_prev;