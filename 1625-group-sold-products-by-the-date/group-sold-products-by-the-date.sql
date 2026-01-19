SELECT sell_date, COUNT(sell_date) AS num_sold, STRING_AGG(product,',' ORDER BY product) AS products
FROM (SELECT * FROM Activities GROUP BY sell_date, product) 
GROUP BY sell_date