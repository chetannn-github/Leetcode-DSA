SELECT id, 
CASE 
    WHEN p_id IS NULL THEN 'Root'
    WHEN parent IS NOT NULL THEN 'Inner'
    ELSE 'Leaf'
    END AS type 
FROM (
    SELECT t.id, t.p_id, s.parent
    FROM Tree AS t
    LEFT JOIN (
        SELECT DISTINCT p_id AS parent
        FROM Tree
        WHERE p_id IS NOT NULL
    ) AS s
ON t.id = s.parent
)