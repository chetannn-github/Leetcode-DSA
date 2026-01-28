SELECT season,category,total_quantity,total_revenue 
FROM (
    SELECT season,category,total_quantity,total_revenue,
    DENSE_RANK() OVER (PARTITION BY season ORDER BY total_quantity DESC, total_revenue  DESC) AS rn
    FROM (
        SELECT season,category,SUM(quantity) AS total_quantity, SUM(totalPrice) as total_revenue
        FROM (
            SELECT season, category, quantity, totalPrice 
            FROM (
                SELECT product_id, (quantity * price) AS totalPrice, quantity,
                CASE 
                    WHEN EXTRACT(MONTH FROM sale_date) = 12 OR EXTRACT(MONTH FROM sale_date) = 1 OR EXTRACT(MONTH FROM sale_date) = 2 THEN 'Winter'
                    WHEN EXTRACT(MONTH FROM sale_date) = 3 OR EXTRACT(MONTH FROM sale_date) = 4 OR EXTRACT(MONTH FROM sale_date) = 5 THEN 'Spring'
                    WHEN EXTRACT(MONTH FROM sale_date) = 6 OR EXTRACT(MONTH FROM sale_date) = 7 OR EXTRACT(MONTH FROM sale_date) = 8 THEN 'Summer'
                    WHEN EXTRACT(MONTH FROM sale_date) = 9 OR EXTRACT(MONTH FROM sale_date) = 10 OR EXTRACT(MONTH FROM sale_date) = 11 THEN 'Fall'
                END AS season

                FROM sales
            ) AS t

            LEFT JOIN products AS p
            ON p.product_id = t.product_id
        )
        GROUP BY season, category
    )
)
WHERE rn = 1;