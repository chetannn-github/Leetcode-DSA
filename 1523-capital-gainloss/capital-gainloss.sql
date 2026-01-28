SELECT stock_name, SUM(sum) AS capital_gain_loss 
FROM(
        SELECT stock_name,operation,
        CASE 
            WHEN operation = 'Sell' THEN sum
            ELSE -sum
        END AS sum 
        FROM(
                SELECT stock_name,operation, SUM(price)
                FROM Stocks
                GROUP BY stock_name,operation
                ORDER BY stock_name
            )
    )
GROUP BY stock_name;