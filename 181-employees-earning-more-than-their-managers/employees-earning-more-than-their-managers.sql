-- SELECT name AS Employee
-- FROM Employee e
-- WHERE salary > (SELECT salary FROM Employee where id = e.managerId);



SELECT e.name AS Employee
FROM Employee e
JOIN Employee m
ON e.managerId = m.id
WHERE e.salary > m.salary;