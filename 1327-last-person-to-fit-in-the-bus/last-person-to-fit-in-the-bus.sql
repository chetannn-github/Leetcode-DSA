SELECT person_name
FROM (
    SELECT person_name,turn,
    SUM(weight) OVER(ORDER BY turn) AS running_sum,
    SUM(weight) OVER (
        ORDER BY turn
        ROWS BETWEEN UNBOUNDED PRECEDING AND 1 FOLLOWING
    ) AS plus_next
    FROM Queue
)
WHERE (running_sum <= 1000 AND plus_next > 1000) OR
turn = (SELECT turn FROM Queue ORDER BY turn DESC LIMIT 1)
LIMIT 1;

