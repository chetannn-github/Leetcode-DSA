WITH mod_table AS (
    SELECT customer_id, 
    COUNT(customer_id) AS total_orders,
    SUM(CASE WHEN order_timestamp::time BETWEEN TIME '11:00' AND TIME '14:00' THEN 1
    WHEN order_timestamp::time BETWEEN TIME '18:00' AND TIME '21:00' THEN 1 ELSE 0 END) as peak_orders, 
    SUM(CASE WHEN order_rating IS NOT NULL THEN 1 ELSE 0 END) AS total_ratings,
    AVG(order_rating) AS average_rating

    FROM restaurant_orders
    GROUP BY customer_id
)


SELECT 
    customer_id,total_orders,
    ROUND(peak_orders :: decimal / total_orders, 2) * 100 AS peak_hour_percentage,
    ROUND(average_rating,2) AS average_rating
FROM mod_table
WHERE total_orders > 2 AND 
ROUND(average_rating,2) >= 4.0 AND
total_ratings::decimal / total_orders > 0.5 AND
peak_orders:: decimal / total_orders > 0.6 

ORDER BY average_rating DESC, customer_id DESC;