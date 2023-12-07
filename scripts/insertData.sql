insert into users_table (id, email, password, photo_url)
values  (1, 'testTeacher@mail.com', '$2a$10$mAVTDTPFUKUnUJZJcmmC/uET0XdhgBRuQdMCOobsMfKuD/q.IhrjO', null),
        (2, 'testStudent@mail.com', '$2a$10$3nF1pTfhj7l7lPt.Sc48OuNn7dW3JJR2uJ4TOrppyCTmBfIqzwUC.', 'http://localhost:8080/static/images/tyler.jpg'),
        (3, 'testAdmin@mail.com', '$2a$10$uvs2gpDUsAkx594pIRB1Y.mdse4m8VNxruGdgbFOpAxE1zsNGicTa', null);

insert into role (id, name)
values  (1, 'ROLE_STUDENT'),
        (2, 'ROLE_TEACHER'),
        (3, 'ROLE_ADMIN');

insert into student_groups (id, name)
values  (1, 'IKBO-17-21'),
        (2, 'IKBO-10-21');

insert into student (id, code, first_name, last_name, term, group_id, user_id)
values  (1, '152365', 'Vanya', 'The Creator', 3, 1, 2);


insert into subject (id, name, exam)
values  (16, 'Geology', 'Exam'),
        (15, 'Art History', 'Exam'),
        (9, 'History', 'Test'),
        (11, 'Economics', 'Test'),
        (21, 'Anthropology', 'Test'),
        (4, 'Mathematics', 'Exam'),
        (5, 'Physics', 'Exam'),
        (7, 'Biology', 'Exam'),
        (6, 'Chemistry', 'Exam'),
        (14, 'Sociology', 'Test'),
        (23, 'Engineering', 'Exam'),
        (17, 'Philosophy', 'Test'),
        (10, 'Literature', 'Test'),
        (20, 'Music', 'Test'),
        (12, 'Psychology', 'Exam'),
        (22, 'Business Adm.', 'Exam'),
        (18, 'Linguistics', 'Exam'),
        (19, 'Env.Science', 'Test'),
        (13, 'Pol.Science', 'Test'),
        (8, 'Comp.Science', 'Exam');

insert into teacher (id, first_name, last_name)
values  (2, 'Jane', 'Black'),
        (3, 'Alice', 'Smith'),
        (4, 'Bob', 'Johnson'),
        (5, 'Eve', 'Williams'),
        (6, 'Charlie', 'Brown'),
        (7, 'Grace', 'Lee'),
        (8, 'David', 'Miller'),
        (9, 'Sophie', 'Clark'),
        (10, 'Michael', 'Davis'),
        (1, 'Nurulla', 'Amin');


insert into roles_users (user_id, role_id)
values  (1, 2),
        (2, 1),
        (3, 3);

insert into student_groups_students (group_id, students_id)
values  (1, 1);

insert into student_groups_subjects (group_id, subjects_id)
values  (1, 11),
        (1, 12),
        (1, 13),
        (1, 14),
        (1, 15),
        (1, 16),
        (1, 17),
        (1, 18);

insert into teacher_groups (teacher_id, groups_id)
values  (1, 2),
        (2, 2),
        (3, 2),
        (4, 2),
        (5, 2),
        (6, 2),
        (7, 2),
        (8, 2);

insert into teacher_subjects (teacher_id, subject_id)
values  (1, 11),
        (2, 12),
        (3, 11),
        (4, 11),
        (5, 12),
        (6, 13),
        (7, 14),
        (8, 15);

insert into debt (id, retake_day, term, student_id, subject_id)
values  (1, '2023-09-03', 1, 1, 8),
        (2, '2023-09-12', 1, 1, 20),
        (3, '2023-10-11', 2, 1, 19);

insert into performance (id, mark, student_id, subject_id, term)
values  (1, 3, 1, 16, 2),
        (2, 5, 1, 17, 2),
        (3, 4, 1, 18, 1),
        (4, 3, 1, 6, 1),
        (5, 4, 1, 4, 1),
        (6, 5, 1, 5, 1),
        (7, 4, 1, 21, 2),
        (8, 4, 1, 22, 1),
        (9, 5, 1, 9, 1),
        (10, 5, 1, 7, 1);