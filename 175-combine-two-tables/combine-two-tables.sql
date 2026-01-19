
SELECT p.firstName AS firstName, p.lastName AS lastName, a.city as city, a.state as state
FROM Person p
LEFT JOIN Address a
ON p.personId = a.personId;
