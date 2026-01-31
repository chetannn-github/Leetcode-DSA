WITH mod_reactions AS (
    SELECT user_id,reaction,
    COUNT(user_id) OVER(PARTITION BY user_id) AS total_reactions, 
    COUNT(reaction) OVER(PARTITION BY user_id, reaction) AS reaction_freq,
    COUNT(*) OVER (PARTITION BY user_id ) AS content_reacted
    FROM reactions
)


SELECT 
    user_id,reaction AS dominant_reaction,
    ROUND(reaction_freq :: DECIMAL / total_reactions,2) AS reaction_ratio
FROM (
    SELECT 
        user_id,reaction,total_reactions,
        reaction_freq,
        ROW_NUMBER() OVER(PARTITION BY user_id ORDER BY reaction_freq DESC) as rn
    FROM mod_reactions
    WHERE content_reacted >= 5
    
)
WHERE rn = 1 AND reaction_freq :: DECIMAL / total_reactions >= 0.6
ORDER BY reaction_ratio DESC, user_id ASC;