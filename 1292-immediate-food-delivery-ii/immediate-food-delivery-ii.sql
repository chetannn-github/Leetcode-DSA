WITH first_orders AS (
    SELECT customer_id,
        order_date,
        customer_pref_delivery_date,
        RANK() OVER (PARTITION BY customer_id ORDER BY order_date) AS rn
    FROM Delivery
)


SELECT 
    ROUND(COUNT(*)::decimal * 100
    /
    (SELECT COUNT(DISTINCT customer_id) FROM Delivery),2) AS immediate_percentage
FROM first_orders
WHERE rn = 1 AND order_date = customer_pref_delivery_date;