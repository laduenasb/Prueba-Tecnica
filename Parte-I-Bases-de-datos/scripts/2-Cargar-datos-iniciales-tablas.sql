
-- Insertar registros en la tabla course
INSERT INTO course (name, credits) VALUES
('Mathematics', 4),
('Physics', 3),
('Biology', 3),
('History', 2),
('Computer Science', 4),
('Literature', 3),
('Chemistry', 4),
('Geography', 3),
('Art', 2),
('Economics', 3);

-- Insertar registros en la tabla Student
INSERT INTO student (card_id, first_name, last_name, age, career) VALUES
(123456, 'John', 'Doe', 20, 'Mechanical Engineering'),
(234567, 'Jane', 'Smith', 21, 'International Relations'),
(345678, 'Michael', 'Johnson', 19, 'Political Science'),
(456789, 'Emily', 'Brown', 23, 'Graphic Design'),
(567890, 'David', 'Martinez', 31, 'Psychology'),
(678901, 'Sarah', 'Taylor', 26, 'International Relations'),
(789012, 'Daniel', 'Anderson', 19, 'Psychology'),
(890123, 'Jessica', 'Wilson', 24, 'Political Science'),
(901234, 'Ryan', 'Thomas', 27, 'Mechanical Engineering'),
(123123, 'Lauren', 'White', 25, 'Graphic Design');

-- Insertar registros en la tabla academic_history

INSERT INTO academic_history (year, period, note, student_id, course_id) VALUES
(2023, 1, 3.5, 1, 1),
(2023, 2, 4, 3, 2),
(2023, 3, 3, 3, 3),
(2023, 2, 2.9, 4, 4),
(2024, 1, 3.7, 5, 5),
(2024, 1, 4, 6, 8),
(2024, 3, 3.2, 7, 4),
(2024, 2, 3.9, 8, 3),
(2025, 3, 2.8, 7, 5),
(2025, 1, 3.5, 10, 6);

