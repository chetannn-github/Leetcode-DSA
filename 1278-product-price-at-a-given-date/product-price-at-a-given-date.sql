WITH changed_product AS (
    SELECT p.product_id, p.new_price AS price
    FROM Products AS p
    RIGHT JOIN (
        SELECT product_id, MAX(change_date) as change_date
        FROM Products
        WHERE change_date <= '2019-08-16'
        GROUP BY product_id
    ) AS t
    ON p.product_id = t.product_id AND p.change_date = t.change_date
)

SELECT product_id,price FROM changed_product
UNION ALL
SELECT DISTINCT p.product_id, 10 AS price
FROM Products p
LEFT JOIN changed_product c
ON p.product_id = c.product_id
WHERE c.product_id IS NULL
