-- Insertar un nuevo curso
INSERT INTO course (name, credits) VALUES ('Chemistry II', 4);

-- Seleccionar todos los estudiantes
SELECT * FROM student;

-- Actualizar la edad de un estudiante
UPDATE student SET age = 23 WHERE student_id = 2;

-- Eliminar un curso
DELETE FROM course WHERE course_id = 10;

-- Insertar un nuevo estudiante
INSERT INTO student (card_id, first_name, last_name, age, career) VALUES (987654, 'Alejandro', 'Dueñas', 26, 'Quantum Physics');

-- Seleccionar los cursos con más de 3 créditos
SELECT * FROM course WHERE credits > 3;

-- Actualizar la nota de un registro de historial académico
UPDATE academic_history SET note = 3.8 WHERE progress_id = 6;

-- Insertar un nuevo registro de historial académico
INSERT INTO academic_history (year, period, note, student_id, course_id) VALUES (2024, 1, 3.9, 4, 7);

-- Seleccionar el historial académico de un estudiante específico
SELECT * FROM academic_history WHERE student_id = 3;

