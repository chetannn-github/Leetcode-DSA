SELECT id,num 
FROM (
    SELECT COALESCE(e.id,t.id) AS id,
    CASE 
        WHEN e.count IS NULL THEN t.count
        WHEN t.count IS NULL THEN e.count
        ELSE e.count + t.count
    END AS num
    FROM (
        SELECT requester_id as id, COUNT(requester_id) as count
        FROM RequestAccepted
        GROUP BY requester_id
    ) AS e
    FULL OUTER JOIN (
        SELECT accepter_id as id, COUNT(accepter_id) as count
        FROM RequestAccepted
        GROUP BY accepter_id
    ) AS t
    ON e.id = t.id
)
ORDER BY num DESC
LIMIT 1;