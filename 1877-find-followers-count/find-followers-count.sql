SELECT DISTINCT user_id, COUNT(user_id) as followers_count
FROM (
    SELECT user_id
    FROM Followers
    GROUP BY user_id, follower_id
)
GROUP BY user_id
ORDER BY user_id