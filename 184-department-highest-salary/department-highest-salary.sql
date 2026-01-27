-- SELECT Employee, Department,Salary 
-- FROM (
--     SELECT e.name as Employee, d.name AS Department, e.salary as Salary,
--         MAX(salary) OVER (PARTITION BY e.departmentId ORDER BY salary DESC )
--         FROM Employee e
--         LEFT JOIN Department d
--         ON e.departmentId = d.id)
-- WHERE max = salary


SELECT e.dname AS Department, e.name AS Employee,e.Salary 
FROM (
    SELECT d.name as dname,e.name,e.Salary, e.departmentId
    FROM Employee e
    LEFT JOIN Department d
    ON e.departmentId = d.id
    ) AS e
JOIN (
    SELECT e.departmentId, MAX(e.salary) as maxSalary
        FROM Employee e
        GROUP BY e.departmentId
    ) AS t
ON t.maxSalary = e.salary AND e.departmentId= t.departmentId



