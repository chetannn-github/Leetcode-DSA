SELECT teacher_id, COUNT(teacher_id) as cnt
FROM (
    SELECT teacher_id, COUNT(subject_id) as count
    FROM Teacher
    GROUP BY teacher_id, subject_id
)
GROUP BY teacher_id