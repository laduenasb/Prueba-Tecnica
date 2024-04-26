-- Traer estudiantes que aprobaron o reprobaron las materias

SELECT s.first_name AS student_name,
       c.name AS course_name,
       CASE 
           WHEN ah.note >= 3 THEN 'Aprobado'
           ELSE 'Reprobado'
       END AS estado
FROM student s
INNER JOIN academic_history ah ON s.student_id = ah.student_id
INNER JOIN course c ON ah.course_id = c.course_id;

-- Esta consulta muestra el nombre del estudiante y el nombre del curso al que 
-- se ha inscrito cada estudiante. Si un estudiante no está inscrito 
-- en ningún curso, se mostrará "No inscrito" como nombre del curso.

SELECT s.first_name AS student_name,
       CASE
           WHEN c.name IS NOT NULL THEN c.name
           ELSE 'No inscrito'
       END AS course_name
FROM student s
LEFT JOIN academic_history ah ON s.student_id = ah.student_id
LEFT JOIN course c ON ah.course_id = c.course_id;

-- Esta consulta muestra el nombre del estudiante y el nombre del curso 
-- al que se ha inscrito cada estudiante. Si un curso no tiene estudiantes inscritos, 
-- se mostrará "Ningún estudiante" como nombre del estudiante.
-- si el estudiante no se ha inscrito a ningun curso saldra null en el nombre del curso

SELECT c.name AS course_name,
       CASE
           WHEN s.first_name IS NOT NULL THEN s.first_name
           ELSE 'Ningun estudiante'
       END AS student_name
FROM course c
RIGHT JOIN academic_history ah ON c.course_id = ah.course_id
RIGHT JOIN student s ON ah.student_id = s.student_id;


-- Esta consulta combina los nombres de los estudiantes y los nombres 
-- de los cursos en una lista

SELECT 'Estudiante' AS type,
       s.first_name AS name
FROM student s
UNION
SELECT 'Curso' AS type,
       c.name AS name
FROM course c;
