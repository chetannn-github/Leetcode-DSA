SELECT s.product_id, p.product_name
FROM (
    SELECT product_id
    FROM Sales 
    GROUP BY product_id
    HAVING MAX(EXTRACT(MONTH FROM sale_date)) < 4 AND MAX(EXTRACT(YEAR FROM sale_date)) = 2019 AND MIN(EXTRACT(YEAR FROM sale_date)) = 2019
) AS s
LEFT JOIN Product p
ON p.product_id = s.product_id
