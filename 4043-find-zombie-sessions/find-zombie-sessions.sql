WITH mod_events_table AS (
    SELECT session_id, user_id,
    EXTRACT(
        EPOCH FROM (
            MAX(event_timestamp) OVER(PARTITION BY session_id) - 
            MIN(event_timestamp) OVER(PARTITION BY session_id)
        )
    ) AS session_duration_secs,

    SUM(CASE WHEN event_type = 'click' THEN 1 ELSE 0 END) OVER(PARTITION BY session_id) AS click_count, 
    SUM(CASE WHEN event_type = 'scroll' THEN 1 ELSE 0 END) OVER(PARTITION BY session_id) AS scroll_count,
    SUM(CASE WHEN event_type = 'purchase' THEN 1 ELSE 0 END) OVER(PARTITION BY session_id) AS purchase_count
    FROM app_events
)

SELECT 
    DISTINCT session_id,user_id, 
    session_duration_secs / 60 AS session_duration_minutes,
    scroll_count
FROM mod_events_table
WHERE 
    session_duration_secs > 1800 AND 
    click_count :: decimal / scroll_count < 0.2 AND 
    purchase_count = 0 AND
    scroll_count > 4
ORDER BY scroll_count DESC, session_id ASC;