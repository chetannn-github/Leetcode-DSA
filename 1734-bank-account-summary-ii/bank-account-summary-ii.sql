SELECT a.name AS NAME, t.balance AS BALANCE 
FROM (
    SELECT account, SUM(amount) AS balance
    FROM Transactions
    GROUP BY account
    HAVING SUM(amount) > 10000
) AS t
LEFT JOIN Users AS a
ON a.account = t.account