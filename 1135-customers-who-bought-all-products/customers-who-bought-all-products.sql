SELECT customer_id 
FROM (
    SELECT customer_id, COUNT(DISTINCT product_key)
    FROM Customer
    GROUP BY customer_id
)
WHERE count = (SELECT COUNT(product_key) FROM Product)