SELECT u.name,
COALESCE(t.travelled_distance,0) as travelled_distance
FROM Users u
LEFT JOIN (
    SELECT user_id, SUM(distance) as travelled_distance
    FROM Rides
    GROUP BY user_id
) AS t
ON u.id = t.user_id
ORDER BY t.travelled_distance DESC NULLS LAST;
