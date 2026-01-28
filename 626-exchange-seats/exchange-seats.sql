SELECT id, 
CASE 
    WHEN id % 2 = 1 AND lead IS NOT NULL THEN lead
    WHEN id % 2 = 0 THEN lag
    ELSE student
END AS student 
FROM (
    SELECT id, student,
    LAG(student) OVER(),
    LEAD(student) OVER()
    FROM Seat
)
