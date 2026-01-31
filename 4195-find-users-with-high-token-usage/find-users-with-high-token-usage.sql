WITH modTable AS(
    SELECT 
        user_id, tokens,
        ROUND(AVG(tokens) OVER(PARTITION BY user_id),2) AS avg_tokens,
        COUNT(user_id) OVER(PARTITION BY user_id) AS freq
    FROM prompts
)


SELECT DISTINCT user_id, freq AS prompt_count, avg_tokens
FROM modTable
WHERE avg_tokens < tokens AND freq > 2
ORDER BY avg_tokens DESC, user_id ASC

  
