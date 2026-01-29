SELECT e.employee_id, e.name, t.reports_count, t.average_age 
FROM(
    SELECT DISTINCT reports_to AS employee_id, 
    ROUND(AVG(age) OVER(PARTITION BY reports_to)) AS average_age,
    COUNT(age) OVER(PARTITION BY reports_to) AS reports_count
    FROM Employees
    WHERE reports_to IS NOT NULL
) AS t
LEFT JOIN Employees AS e
ON e.employee_id = t.employee_id
ORDER BY employee_id;