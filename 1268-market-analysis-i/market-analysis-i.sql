SELECT u.user_id AS buyer_id, u.join_date, 
COALESCE(t.orders_in_2019,0) AS orders_in_2019
FROM Users AS u

LEFT JOIN(
    SELECT buyer_id, COUNT(order_id) AS orders_in_2019
    FROM Orders
    WHERE EXTRACT(YEAR FROM order_date) = 2019
    GROUP BY buyer_id
) AS t

ON u.user_id = t.buyer_id