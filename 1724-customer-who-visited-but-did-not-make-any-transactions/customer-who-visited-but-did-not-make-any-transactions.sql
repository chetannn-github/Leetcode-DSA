SELECT customer_id, COUNT(customer_id) AS count_no_trans
    FROM(
        SELECT v.customer_id, t.transaction_id
        FROM Visits v
        LEFT JOIN Transactions t
        ON v.visit_id = t.visit_id
    ) AS t
WHERE t.transaction_id IS NULL
GROUP BY t.customer_id

