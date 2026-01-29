SELECT machine_id, ROUND(time_taken::numeric/activity_count,3) AS processing_time 
FROM(
    SELECT machine_id,
    SUM(
        CASE WHEN activity_type = 'start' THEN -timestamp
        ELSE timestamp END
    ) AS time_taken,
    SUM(
        CASE WHEN activity_type = 'start' THEN 1
        ELSE 0 END
    ) AS activity_count
    FROM Activity
    GROUP BY machine_id
    ORDER BY machine_id
)