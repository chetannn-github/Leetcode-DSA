WITH eligible_stores AS (
    SELECT store_id, 
    MAX(CASE WHEN price = max THEN product_name END) AS most_exp_product,
    MAX(CASE WHEN price = min THEN product_name END) AS cheapest_product,
    ROUND(MAX(CASE WHEN price = min THEN quantity END)::decimal / 
    MAX(CASE WHEN price = max THEN quantity END),2) AS imbalance_ratio


    FROM (
        SELECT store_id, product_name, quantity, price,
        MAX(price) OVER (PARTITION BY store_id),
        MIN(price) OVER (PARTITION BY store_id)
        FROM inventory
    )

    GROUP BY store_id
    HAVING MAX(CASE WHEN price = max THEN quantity END) < 
    MAX(CASE WHEN price = min THEN quantity END) AND COUNT(store_id) > 2
)


SELECT 
    e.store_id,s.store_name,s.location, 
    e.most_exp_product,e.cheapest_product,e.imbalance_ratio
FROM eligible_stores AS e
LEFT JOIN stores AS s
ON e.store_id = s.store_id
ORDER BY imbalance_ratio DESC, store_name ASC;


