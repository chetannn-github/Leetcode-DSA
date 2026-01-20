SELECT s.student_id,
s.student_name,
s.subject_name, 
COALESCE(t.attended_exams,0) AS attended_exams
FROM (
    SELECT *
    FROM Students
    CROSS JOIN Subjects
) AS s
LEFT JOIN (
    SELECT student_id,subject_name, COUNT(student_id) AS attended_exams
    FROM Examinations
    GROUP BY subject_name, student_id
) as t
ON s.student_id = t.student_id AND s.subject_name = t.subject_name
ORDER BY s.student_id
;




