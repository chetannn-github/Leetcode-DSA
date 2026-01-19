-- SELECT MAX(salary) AS SecondHighestSalary
-- FROM (
--     SELECT DISTINCT salary
--     FROM Employee
--     ORDER BY salary DESC
--     OFFSET 1
--     LIMIT 1
-- );

SELECT MAX(salary) AS SecondHighestSalary FROM (
    SELECT salary
    FROM (
        SELECT salary,
            DENSE_RANK() OVER (ORDER BY salary DESC) AS rn
        FROM employee
    ) 
    WHERE rn = 2
);





    
   



























