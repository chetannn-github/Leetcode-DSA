-- Write your PostgreSQL query statement below

SELECT p.product_name, t.unit
FROM 
(
    SELECT product_id, EXTRACT(MONTH FROM order_date) AS month,
    EXTRACT(YEAR FROM order_date) = 2020 as year,
    SUM(unit) as unit
    FROM Orders
    GROUP BY month, product_id,year
    HAVING sum(unit) >= 100 AND EXTRACT(MONTH FROM order_date) = 2 AND EXTRACT(YEAR FROM order_date) = 2020
) AS t
LEFT JOIN Products p
ON p.product_id = t.product_id

