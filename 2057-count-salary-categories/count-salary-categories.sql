WITH categories AS (
    SELECT 'High Salary' AS category
    UNION ALL
    SELECT 'Low Salary'
    UNION ALL
    SELECT 'Average Salary'
)

SELECT c.category,
COALESCE(t.accounts_count,0) AS accounts_count
FROM categories c
LEFT JOIN (
    SELECT category, COUNT(account_id) AS accounts_count
    FROM (
        SELECT account_id,
        CASE 
            WHEN income < 20000 THEN 'Low Salary'
            WHEN income <= 50000 THEN 'Average Salary'
            ELSE 'High Salary'
        END AS category
        FROM Accounts
    )
    GROUP BY category
) AS t
ON c.category = t.category;


