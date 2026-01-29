SELECT customer_id
FROM customer_transactions
GROUP BY customer_id
HAVING COUNT(customer_id) >= 3 AND (
    SUM (
        CASE WHEN transaction_type = 'refund' THEN 1
        ELSE 0
        END 
    )::numeric / COUNT(customer_id) < 0.2 )
    AND MAX(transaction_date) - MIN(transaction_date) >= 30
ORDER BY customer_id
