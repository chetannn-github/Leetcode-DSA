SELECT user_id, MAX(time_stamp) AS last_stamp
FROM (
    SELECT user_id,time_stamp
    FROM Logins
    GROUP BY user_id, time_stamp
    HAVING EXTRACT(YEAR FROM time_stamp) = 2020
)
GROUP BY user_id
