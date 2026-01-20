SELECT DISTINCT t.author_id as id 
FROM(
        SELECT DISTINCT *
        FROM Views
    ) AS t
WHERE t.author_id = t.viewer_id
ORDER BY t.author_id ASC;


