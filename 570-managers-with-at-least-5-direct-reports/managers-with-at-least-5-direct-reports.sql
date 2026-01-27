SELECT t.name AS name 
FROM (
    SELECT managerId
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(managerId) > 4
    ) AS e
JOIN Employee AS t
ON e.managerId = t.id
