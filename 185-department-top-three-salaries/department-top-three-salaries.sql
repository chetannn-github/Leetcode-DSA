SELECT Employee, Department,Salary 
FROM (
    SELECT e.name as Employee, d.name AS Department, e.salary as Salary,
        DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY salary DESC ) as rank
        FROM Employee e
        LEFT JOIN Department d
        ON e.departmentId = d.id
    )
WHERE rank < 4;           