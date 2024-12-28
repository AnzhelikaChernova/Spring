INSERT INTO user
VALUES ('ADMIN', 1, CURRENT_TIMESTAMP, 'admin@narxoz.kz', 'ADMIN', false, 'ADMIN',
        '$2a$10$.Baq/dWdsZveB.yR0YS8IunW32fW6xUu339a47I44S.wmiH9L7bSy', null, null, null);

insert into user (id, role, created_at, email, firstname, is_deleted, lastname, password, course, department, grade)
values
    (2, 'STUDENT', now(), 'student1@example.com', 'John', 0, 'Doe', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (3, 'STUDENT', now(), 'student2@example.com', 'Jane', 0, 'Smith', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'BACHELOR'),
    (4, 'STUDENT', now(), 'student3@example.com', 'Alice', 0, 'Johnson', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'MASTER'),
    (5, 'STUDENT', now(), 'student4@example.com', 'Bob', 0, 'Davis', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (6, 'STUDENT', now(), 'student5@example.com', 'Charlie', 0, 'Miller', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'BACHELOR'),
    (7, 'STUDENT', now(), 'student6@example.com', 'David', 0, 'Wilson', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'MASTER'),
    (8, 'STUDENT', now(), 'student7@example.com', 'Eva', 0, 'Moore', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (9, 'STUDENT', now(), 'student8@example.com', 'Frank', 0, 'Taylor', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'BACHELOR'),
    (10, 'STUDENT', now(), 'student9@example.com', 'Grace', 0, 'Anderson', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'MASTER'),
    (11, 'STUDENT', now(), 'student10@example.com', 'Henry', 0, 'Thomas', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (12, 'STUDENT', now(), 'student11@example.com', 'Isabella', 0, 'Jackson', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'BACHELOR'),
    (13, 'STUDENT', now(), 'student12@example.com', 'Jack', 0, 'White', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'PHD'),
    (14, 'STUDENT', now(), 'student13@example.com', 'Liam', 0, 'Harris', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (15, 'STUDENT', now(), 'student14@example.com', 'Mia', 0, 'Martin', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'MASTER'),
    (16, 'STUDENT', now(), 'student15@example.com', 'Noah', 0, 'Garcia', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'PHD'),
    (17, 'STUDENT', now(), 'student16@example.com', 'Olivia', 0, 'Rodriguez', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (18, 'STUDENT', now(), 'student17@example.com', 'James', 0, 'Martinez', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'BACHELOR'),
    (19, 'STUDENT', now(), 'student18@example.com', 'Ava', 0, 'Roberts', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'MASTER'),
    (20, 'STUDENT', now(), 'student19@example.com', 'William', 0, 'Clark', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (21, 'STUDENT', now(), 'student20@example.com', 'Sophia', 0, 'Lewis', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'BACHELOR'),
    (22, 'STUDENT', now(), 'student21@example.com', 'Benjamin', 0, 'Lee', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'MASTER'),
    (23, 'STUDENT', now(), 'student22@example.com', 'Lucas', 0, 'Walker', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (24, 'STUDENT', now(), 'student23@example.com', 'Amelia', 0, 'Young', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'BACHELOR'),
    (25, 'STUDENT', now(), 'student24@example.com', 'Oliver', 0, 'Allen', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'PHD'),
    (26, 'STUDENT', now(), 'student25@example.com', 'Elijah', 0, 'Scott', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (27, 'STUDENT', now(), 'student26@example.com', 'Charlotte', 0, 'King', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'MASTER'),
    (28, 'STUDENT', now(), 'student27@example.com', 'Henry', 0, 'Adams', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'BACHELOR'),
    (29, 'STUDENT', now(), 'student28@example.com', 'Amelia', 0, 'Baker', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (30, 'STUDENT', now(), 'student29@example.com', 'Jackson', 0, 'Gonzalez', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'PHD'),
    (31, 'STUDENT', now(), 'student30@example.com', 'Zoe', 0, 'White', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'MASTER');

insert into user (id, role, created_at, email, firstname, is_deleted, lastname, password, course, department, grade)
values
    (32, 'TEACHER', now(), 'teacher1@example.com', 'Prof. John', 0, 'Doe', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (33, 'TEACHER', now(), 'teacher2@example.com', 'Prof. Jane', 0, 'Smith', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'MASTER'),
    (34, 'TEACHER', now(), 'teacher3@example.com', 'Prof. Alice', 0, 'Johnson', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'PHD'),
    (35, 'TEACHER', now(), 'teacher4@example.com', 'Prof. Bob', 0, 'Davis', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (36, 'TEACHER', now(), 'teacher5@example.com', 'Prof. Charlie', 0, 'Miller', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'BACHELOR'),
    (37, 'TEACHER', now(), 'teacher6@example.com', 'Prof. David', 0, 'Wilson', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'MASTER'),
    (38, 'TEACHER', now(), 'teacher7@example.com', 'Prof. Eva', 0, 'Moore', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'FIRST', 'IT', 'BACHELOR'),
    (39, 'TEACHER', now(), 'teacher8@example.com', 'Prof. Frank', 0, 'Taylor', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'SECOND', 'ECONOMICS_AND_MANAGEMENT', 'BACHELOR'),
    (40, 'TEACHER', now(), 'teacher9@example.com', 'Prof. Grace', 0, 'Anderson', '$2a$10$l6ou6jVmdWBHr3nfbRr0PeuzYjij4MwA4n10toJ9cS66lhoo2NZuG', 'THIRD', 'LAW_AND_POLICY', 'PHD');

insert into lesson (id, cabinet, course, day_of_week, department, name, student_count, time_of_lesson, created_at, is_deleted)
values
    (1, 101, 'FIRST', 'MONDAY', 'IT', 'Math 101', 30, 'FIRST', now(), 0),
    (2, 102, 'SECOND', 'TUESDAY', 'ECONOMICS_AND_MANAGEMENT', 'Economics 201', 30, 'SECOND', now(), 0),
    (3, 103, 'THIRD', 'WEDNESDAY', 'LAW_AND_POLICY', 'Law 301', 25, 'THIRD', now(), 0),
    (4, 104, 'FIRST', 'THURSDAY', 'IT', 'Programming 101', 35, 'FOURTH', now(), 0),
    (5, 105, 'SECOND', 'FRIDAY', 'ECONOMICS_AND_MANAGEMENT', 'Microeconomics 202', 40, 'FIFTH', now(), 0),
    (6, 106, 'THIRD', 'SATURDAY', 'LAW_AND_POLICY', 'Constitutional Law 401', 20, 'SIXTH', now(), 0),
    (7, 107, 'FIRST', 'SUNDAY', 'IT', 'Algorithms 101', 28, 'SEVENTH', now(), 0),
    (8, 108, 'SECOND', 'MONDAY', 'ECONOMICS_AND_MANAGEMENT', 'Macroeconomics 301', 32, 'EIGHTH', now(), 0),
    (9, 109, 'THIRD', 'TUESDAY', 'LAW_AND_POLICY', 'Criminal Law 302', 33, 'NINTH', now(), 0),
    (10, 110, 'FIRST', 'WEDNESDAY', 'IT', 'Data Structures 101', 30, 'FIRST', now(), 0);

insert into student_lesson (lesson_id, student_id)
values
    (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (1, 9), (1, 10), (1, 11),
    (2, 12), (2, 13), (2, 14), (2, 15), (2, 16), (2, 17), (2, 18), (2, 19), (2, 20), (2, 21),
    (3, 22), (3, 23), (3, 24), (3, 25), (3, 26), (3, 27), (3, 28), (3, 29), (3, 30), (3, 31),
    (4, 2), (4, 3), (4, 4), (4, 5), (4, 6), (4, 7), (4, 8), (4, 9), (4, 10), (4, 11),
    (5, 12), (5, 13), (5, 14), (5, 15), (5, 16), (5, 17), (5, 18), (5, 19), (5, 20), (5, 21),
    (6, 22), (6, 23), (6, 24), (6, 25), (6, 26), (6, 27), (6, 28), (6, 29), (6, 30), (6, 31),
    (7, 2), (7, 3), (7, 4), (7, 5), (7, 6), (7, 7), (7, 8), (7, 9), (7, 10), (7, 11),
    (8, 12), (8, 13), (8, 14), (8, 15), (8, 16), (8, 17), (8, 18), (8, 19), (8, 20), (8, 21),
    (9, 22), (9, 23), (9, 24), (9, 25), (9, 26), (9, 27), (9, 28), (9, 29), (9, 30), (9, 31),
    (10, 2), (10, 3), (10, 4), (10, 5), (10, 6), (10, 7), (10, 8), (10, 9), (10, 10), (10, 11);

insert into teacher_lesson (id, lesson_id, teacher_id)
values
    (1, 1, 32),   -- Teacher 32 teaches lesson 1
    (2, 2, 33),   -- Teacher 33 teaches lesson 2
    (3, 3, 34),   -- Teacher 34 teaches lesson 3
    (4, 4, 35),   -- Teacher 35 teaches lesson 4
    (5, 5, 36),   -- Teacher 36 teaches lesson 5
    (6, 6, 37),   -- Teacher 37 teaches lesson 6
    (7, 7, 38),   -- Teacher 38 teaches lesson 7
    (8, 8, 39),   -- Teacher 39 teaches lesson 8
    (9, 9, 40),  -- Teacher 40 teaches lesson 9
    (10, 10, 32); -- Teacher 32 teaches lesson 10



