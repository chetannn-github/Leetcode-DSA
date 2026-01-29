SELECT visited_on,amount,average_amount 
FROM  (
    SELECT visited_on, 
    SUM(amount) OVER (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND 0 FOLLOWING) AS amount , 
    ROUND(AVG(amount) OVER (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND 0 FOLLOWING),2) AS             average_amount, 
    RANK() OVER(ORDER BY visited_on) AS rn
    FROM (
        SELECT visited_on,SUM(amount) as amount
        FROM Customer
        GROUP BY visited_on
    )
)
WHERE rn > 6