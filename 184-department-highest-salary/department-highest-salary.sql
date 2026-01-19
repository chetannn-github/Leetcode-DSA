SELECT Employee, Department,Salary 
FROM (
    SELECT e.name as Employee, d.name AS Department, e.salary as Salary,
        MAX(salary) OVER (PARTITION BY e.departmentId ORDER BY salary DESC )
        FROM Employee e
        LEFT JOIN Department d
        ON e.departmentId = d.id)
WHERE max = salary