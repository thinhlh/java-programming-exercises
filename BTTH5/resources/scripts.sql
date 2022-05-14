DROP TABLE IF EXISTS "student";
CREATE TABLE student
(
    student_id VARCHAR(6) PRIMARY KEY not null,
    first_name VARCHAR(255) null,
    last_name VARCHAR(255) null,
    dob DATE null,
    department VARCHAR(255) null,
    entrance_date DATE null,
    graduation_date DATE null,
    credits INT4 not null default 0,
    score DEC(10,2) default 0.00
);