

SELECT user_id,
MAX(CASE WHEN activity_type = 'free_trial' THEN round END) AS trial_avg_duration,
MAX(CASE WHEN activity_type = 'paid' THEN round END) AS paid_avg_duration
FROM (SELECT t.user_id, t.round, t.activity_type 
FROM(
    SELECT user_id
    FROM (
        SELECT user_id, ROUND(AVG(activity_duration),2),activity_type
        FROM UserActivity
        GROUP BY user_id, activity_type
        HAVING activity_type != 'cancelled'
        ORDER BY user_id
    )
    GROUP BY user_id
    HAVING COUNT(user_id) = 2
) AS e

LEFT JOIN (
    SELECT user_id, ROUND(AVG(activity_duration),2),activity_type
        FROM UserActivity
        GROUP BY user_id, activity_type
        HAVING activity_type != 'cancelled'
        ORDER BY user_id
) AS t

ON t.user_id = e.user_id)

GROUP BY user_id


