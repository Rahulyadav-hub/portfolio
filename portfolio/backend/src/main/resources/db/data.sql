-- Seed data: inserted only when the tables are empty, so edits survive restarts.
INSERT INTO projects (name, description, technologies, github_url, live_url, category, display_order)
SELECT 'Tanishq POS/NAP (Titan)', 'Worked on the Tanishq POS/NAP application for Titan at LTIMindtree. EDIT: add only non-confidential responsibilities.', 'Java, Spring Boot, REST APIs, SQL', NULL, NULL, 'PROFESSIONAL', 1 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM projects)
UNION ALL
SELECT 'Task Manager API (Personal/Demo)', 'Personal demo project: a REST API for managing tasks. EDIT: replace with your real repo details.', 'Java 17, Spring Boot, JPA, MySQL', 'https://github.com/your-username/task-manager-api', NULL, 'DEMO', 2 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM projects)
UNION ALL
SELECT 'Employee Directory (Personal/Demo)', 'Personal demo project: CRUD application for an employee directory. EDIT: replace with your real repo details.', 'Spring Boot, React, MySQL', 'https://github.com/your-username/employee-directory', NULL, 'DEMO', 3 FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM projects);

INSERT INTO skills (name, category, display_order)
SELECT 'Java 8/17','Backend',1 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Spring Boot','Backend',2 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Microservices','Backend',3 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'REST APIs','Backend',4 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Spring Data JPA','Backend',5 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Hibernate','Backend',6 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'SQL','Database',7 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'MySQL','Database',8 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'React','Frontend',9 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'JavaScript','Frontend',10 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'HTML/CSS','Frontend',11 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Angular','Frontend',12 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Git','Tools',13 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Maven','Tools',14 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Jenkins','Tools',15 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Postman','Tools',16 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Swagger','Tools',17 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'JUnit','Testing',18 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills)
UNION ALL SELECT 'Mockito','Testing',19 FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM skills);
