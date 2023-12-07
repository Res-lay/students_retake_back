CREATE TABLE IF NOT EXISTS users_table (
	id SERIAL PRIMARY KEY,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	photo_url VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS student_groups(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
    term INT
);

CREATE TABLE IF NOT EXISTS student(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	group_id INT REFERENCES student_groups(id),
	code VARCHAR(255),
	term INT,
	user_id BIGINT REFERENCES users_table(id)
);

CREATE TABLE IF NOT EXISTS subject(
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    exam VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS role(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS teacher(
    id BIGINT PRIMARY KEY NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);

create table if not exists teacher_groups(
    teacher_id bigint not null
        constraint fkh6egnyvnn8toiohupap6fmhu9
            references teacher,
    groups_id  bigint not null
        constraint fk6p16c6kwgh63vxtxdfgd8d6jd
            references student_groups
);

create table if not exists teacher_subjects(
    teacher_id bigint not null
        constraint fkjkx6egayo8f0yrpjb1fychxbq
            references teacher,
    subject_id bigint not null
        constraint fkn680sbj5cc0wo9yeajo62gfwb
            references subject
);

CREATE TABLE IF NOT EXISTS roles_users(
    user_id BIGINT NOT NULL
        CONSTRAINT fk35a8iedo7x2umx781eo50yf1q
            REFERENCES users_table,
    role_id BIGINT NOT NULL
        CONSTRAINT fkiekkooywvstxn9cgt1iyvorq8
            REFERENCES role,
    PRIMARY KEY	 (user_id, role_id)
);

CREATE TABLE IF NOT EXISTS debt(
	id SERIAL PRIMARY KEY NOT NULL,
	retake_day DATE,
	term INTEGER NOT NULL,
	student_id BIGINT CONSTRAINT fk6xaptqhsrjgb1eg7mkwof8wm REFERENCES student,
	subject_id BIGINT CONSTRAINT uk_jyfvioi2ka6rv1dldxu8qgff5 UNIQUE
		CONSTRAINT fkipoufvwep3j5i712827h2p5hf REFERENCES subject
);

CREATE TABLE IF NOT EXISTS performance(
	id SERIAL PRIMARY KEY NOT NULL,
	mark INTEGER NOT NULL,
	student_id BIGINT CONSTRAINT fks9pjut2jvjpm3xsl1scdgipdn REFERENCES student,
	subject_id BIGINT CONSTRAINT uk_nrxsudv3v22xjtm294lgatwcu UNIQUE
		CONSTRAINT fko0c8jglas44w1c5tjwjmq4y6t REFERENCES subject,
	term INTEGER
);

CREATE TABLE IF NOT EXISTS student_groups(
	id BIGINT PRIMARY KEY NOT NULL,
	name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS student_groups_students(
	group_id BIGINT NOT NULL CONSTRAINT fkjtkghxwraaigkx4k79pjvtapx
            references student_groups,
    students_id BIGINT NOT NULL
        CONSTRAINT uk_nvj53yjr5m07kju6lnc0lh6h3
            UNIQUE
        CONSTRAINT fkehhaff5u7mjcxrrp58mxoj9uy
            REFERENCES student
);

CREATE TABLE IF NOT EXISTS student_groups_subjects(
    group_id BIGINT NOT NULL
        CONSTRAINT fkqk2s15grlfl1n7dmhtubnovyt
            REFERENCES student_groups,
    subjects_id BIGINT NOT NULL
        CONSTRAINT uk_4v42jgpgqhqw7eo13v4j1wuou
            UNIQUE
        CONSTRAINT fkkjrhc4quuom143fu2ns3oqi40
        	REFERENCES subject
);

