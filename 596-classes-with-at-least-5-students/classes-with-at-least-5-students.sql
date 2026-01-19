SELECT class
FROM (
    SELECT class, ROW_NUMBER() OVER(PARTITION BY class) AS row
    FROM Courses
    ORDER BY class) AS t
GROUP BY class
HAVING MAX(row) > 4;
