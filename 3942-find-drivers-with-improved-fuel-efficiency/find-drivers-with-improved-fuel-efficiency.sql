WITH modTable AS (
    SELECT driver_id,
    AVG(distance_km / fuel_consumed) AS avg,
    CASE WHEN EXTRACT(MONTH FROM trip_date) <= 6 THEN 'h1' ELSE 'h2' END AS half
    FROM trips
    GROUP BY driver_id,half
),

result_table AS (
    SELECT t.driver_id,
    MAX(CASE WHEN m.half = 'h1' THEN m.avg END) AS first_half_avg,
    MAX(CASE WHEN m.half = 'h2' THEN m.avg END) AS second_half_avg, 
    MAX(CASE WHEN m.half = 'h2' THEN m.avg END)  -
    MAX(CASE WHEN m.half = 'h1' THEN m.avg END) AS efficiency_improvement

    FROM (
        SELECT driver_id
        FROM modTable
        GROUP BY driver_id 
        HAVING COUNT(DISTINCT half) = 2
    ) AS t

    LEFT JOIN modTable AS m
    ON m.driver_id = t.driver_id
    GROUP BY t.driver_id
    HAVING 
    MAX(CASE WHEN m.half = 'h1' THEN m.avg END)  - 
    MAX(CASE WHEN m.half = 'h2' THEN m.avg END)  < 0
)


SELECT 
    r.driver_id, driver_name, 
    ROUND(first_half_avg,2) AS first_half_avg,
    ROUND(second_half_avg,2) AS second_half_avg,
    ROUND(efficiency_improvement,2) AS efficiency_improvement
FROM result_table AS r
LEFT JOIN drivers AS d
ON r.driver_id = d.driver_id
ORDER BY efficiency_improvement DESC, driver_name ASC