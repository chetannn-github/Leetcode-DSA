SELECT e.employee_id, e.department_id
FROM (
    SELECT employee_id,COUNT(employee_id)
    FROM Employee
    GROUP BY employee_id
) AS t
CROSS JOIN Employee e
WHERE e.employee_id = t.employee_id AND (
    (t.count = 1 AND e.primary_flag = 'N') OR (t.count > 1 AND e.primary_flag = 'Y')
)