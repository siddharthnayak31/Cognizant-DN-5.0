USE EventManagement;

--exercise 1
SELECT
    u.full_name,
    e.title,
    e.city,
    e.start_date
FROM Users u
JOIN Registrations r
    ON u.user_id = r.user_id
JOIN Events e
    ON r.event_id = e.event_id
WHERE e.status = 'upcoming'
  AND u.city = e.city
ORDER BY e.start_date;

--exercise 2
SELECT
    e.event_id,
    e.title,
    AVG(f.rating) AS avg_rating,
    COUNT(*) AS feedback_count
FROM Events e
JOIN Feedback f
    ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(*) >= 10
ORDER BY avg_rating DESC;


--exercise 3
SELECT *
FROM Users u
WHERE NOT EXISTS (
    SELECT 1
    FROM Registrations r
    WHERE r.user_id = u.user_id
      AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
);

--exercise 4
SELECT
    e.title,
    COUNT(*) AS session_count
FROM Events e
JOIN Sessions s
    ON e.event_id = s.event_id
WHERE TIME(s.start_time)
      BETWEEN '10:00:00' AND '12:00:00'
GROUP BY e.title;


--exercise 5
SELECT
    u.city,
    COUNT(DISTINCT r.user_id) AS registrations
FROM Users u
JOIN Registrations r
    ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY registrations DESC
LIMIT 5;


--exercise 6
SELECT
    e.title,
    COUNT(r.resource_id) AS total_resources
FROM Events e
LEFT JOIN Resources r
    ON e.event_id = r.event_id
GROUP BY e.title;


--exercise 7
SELECT
    u.full_name,
    f.comments,
    e.title
FROM Feedback f
JOIN Users u
    ON f.user_id = u.user_id
JOIN Events e
    ON f.event_id = e.event_id
WHERE f.rating < 3;


--exercise  8
SELECT
    e.title,
    COUNT(s.session_id) AS total_sessions
FROM Events e
LEFT JOIN Sessions s
    ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.title;


--exercise 9
SELECT
    u.full_name,
    e.status,
    COUNT(*) AS total_events
FROM Events e
JOIN Users u
    ON e.organizer_id = u.user_id
GROUP BY u.full_name, e.status;


--exercise 10
SELECT
    e.title
FROM Events e
JOIN Registrations r
    ON e.event_id = r.event_id
LEFT JOIN Feedback f
    ON e.event_id = f.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.title;


--exercise 11
SELECT
    registration_date,
    COUNT(*) AS total_users
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date
ORDER BY registration_date;



--exercise 12
SELECT
    e.event_id,
    e.title,
    COUNT(s.session_id) AS total_sessions
FROM Events e
JOIN Sessions s
    ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(s.session_id) = (
    SELECT MAX(session_count)
    FROM (
        SELECT COUNT(*) AS session_count
        FROM Sessions
        GROUP BY event_id
    ) temp
);



--exercise 13
SELECT
    e.city,
    ROUND(AVG(f.rating), 2) AS average_rating
FROM Events e
JOIN Feedback f
    ON e.event_id = f.event_id
GROUP BY e.city;



--exercise 14
SELECT
    e.title,
    COUNT(r.registration_id) AS total_registrations
FROM Events e
JOIN Registrations r
    ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_registrations DESC
LIMIT 3;



--exercise 15
SELECT
    s1.event_id,
    s1.title AS session_1,
    s2.title AS session_2
FROM Sessions s1
JOIN Sessions s2
    ON s1.event_id = s2.event_id
   AND s1.session_id < s2.session_id
WHERE s1.start_time < s2.end_time
  AND s1.end_time > s2.start_time;



--exercise 16
SELECT *
FROM Users u
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
AND NOT EXISTS (
    SELECT 1
    FROM Registrations r
    WHERE r.user_id = u.user_id
);



--exercise 17
SELECT
    speaker_name,
    COUNT(*) AS total_sessions
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(*) > 1;


--exercise 18
SELECT
    e.event_id,
    e.title
FROM Events e
LEFT JOIN Resources r
    ON e.event_id = r.event_id
WHERE r.resource_id IS NULL;



--exercise 19
SELECT
    e.title,
    COUNT(DISTINCT r.registration_id)
        AS total_registrations,
    ROUND(AVG(f.rating), 2)
        AS average_rating
FROM Events e
LEFT JOIN Registrations r
    ON e.event_id = r.event_id
LEFT JOIN Feedback f
    ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title;



--exercise 20
SELECT
    u.user_id,
    u.full_name,

    COUNT(DISTINCT r.event_id)
        AS events_attended,

    COUNT(DISTINCT f.feedback_id)
        AS feedbacks_submitted

FROM Users u

LEFT JOIN Registrations r
    ON u.user_id = r.user_id

LEFT JOIN Feedback f
    ON u.user_id = f.user_id

GROUP BY
    u.user_id,
    u.full_name;

--exercise 21
SELECT
    u.user_id,
    u.full_name,
    COUNT(f.feedback_id) AS total_feedbacks
FROM Users u
JOIN Feedback f
    ON u.user_id = f.user_id
GROUP BY
    u.user_id,
    u.full_name
ORDER BY total_feedbacks DESC
LIMIT 5;



--exercise 22
SELECT
    user_id,
    event_id,
    COUNT(*) AS registration_count
FROM Registrations
GROUP BY
    user_id,
    event_id
HAVING COUNT(*) > 1;



--exercise 23
SELECT
    YEAR(registration_date) AS year,
    MONTH(registration_date) AS month,
    COUNT(*) AS total_registrations
FROM Registrations
WHERE registration_date >=
      CURDATE() - INTERVAL 12 MONTH
GROUP BY
    YEAR(registration_date),
    MONTH(registration_date)
ORDER BY
    year,
    month;



--exercise 24
SELECT
    e.event_id,
    e.title,

    ROUND(
        AVG(
            TIMESTAMPDIFF(
                MINUTE,
                s.start_time,
                s.end_time
            )
        ),
        2
    ) AS avg_duration_minutes

FROM Events e

JOIN Sessions s
    ON e.event_id = s.event_id

GROUP BY
    e.event_id,
    e.title;


--exercise 25

SELECT
    e.event_id,
    e.title
FROM Events e
LEFT JOIN Sessions s
    ON e.event_id = s.event_id
WHERE s.session_id IS NULL;