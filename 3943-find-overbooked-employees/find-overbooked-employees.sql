SELECT t.employee_id, e.employee_name, e.department, t.meeting_heavy_weeks 
FROM (
    SELECT 
    employee_id, 
    COUNT(employee_id) AS meeting_heavy_weeks
    FROM (
        SELECT
            employee_id,
            date_trunc('week', meeting_date) AS week_start
        FROM meetings
        GROUP BY employee_id, week_start
        HAVING SUM(duration_hours) > 20.0 
        ORDER BY employee_id, week_start
    )
    GROUP BY employee_id
    HAVING COUNT(employee_id) > 1
) AS t

LEFT JOIN employees AS e
ON e.employee_id = t.employee_id
ORDER BY meeting_heavy_weeks DESC, employee_name ASC
