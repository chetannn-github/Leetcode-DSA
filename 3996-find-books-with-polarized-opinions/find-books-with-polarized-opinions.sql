WITH eligible_books AS (
    SELECT s.book_id, t.rating_spread, t.polarization_score FROM(
        SELECT book_id
        FROM reading_sessions
        GROUP BY book_id 
        HAVING COUNT(book_id) > 4 AND (MAX(session_rating) >= 4 AND MIN(session_rating) <= 2)
    ) AS s
    LEFT JOIN (
        SELECT DISTINCT book_id, 
        MAX(session_rating) OVER(PARTITION BY book_id) - MIN(session_rating) OVER(PARTITION BY book_id) AS rating_spread,
        ROUND (
            SUM(CASE WHEN session_rating <= 2 OR session_rating >= 4 THEN 1 ELSE 0 END ) OVER(PARTITION BY book_id)::numeric /
            COUNT(book_id) OVER(PARTITION BY book_id)
        ,2)
        AS polarization_score
        FROM reading_sessions
    ) AS t

    ON s.book_id = t.book_id
)


SELECT e.book_id, b.title, b.author, b.genre, b.pages, e.rating_spread, e.polarization_score
FROM eligible_books AS e
LEFT JOIN books AS b
ON e.book_id = b.book_id
WHERE polarization_score >= 0.6
ORDER BY polarization_score DESC, title DESC;
