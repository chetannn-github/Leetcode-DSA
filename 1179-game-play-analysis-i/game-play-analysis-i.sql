SELECT a.player_id, MIN(event_date) AS first_login
FROM Activity a
GROUP BY a.player_id