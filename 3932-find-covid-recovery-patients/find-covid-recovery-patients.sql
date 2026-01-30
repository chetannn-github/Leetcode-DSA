WITH eligible_id AS (
    SELECT l.patient_id, l.first_positive,c.test_date AS negative_date
    FROM (
        SELECT patient_id, MIN(test_date) as first_positive
        FROM covid_tests
        WHERE result = 'Positive'
        GROUP BY patient_id
    ) AS l
    LEFT JOIN covid_tests c
    ON l.patient_id = c.patient_id
    WHERE c.result = 'Negative' AND test_date > first_positive
)


SELECT 
    l.patient_id, r.patient_name,r.age, l.recovery_time
FROM (
    SELECT patient_id, MIN(negative_date) - first_positive AS recovery_time
    FROM eligible_id
    GROUP BY patient_id, first_positive
) AS l
LEFT JOIN patients AS r
ON l.patient_id = r.patient_id
ORDER BY recovery_time ASC, patient_name ASC;