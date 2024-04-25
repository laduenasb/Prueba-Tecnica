
-- Creación de la tabla course
CREATE TABLE course (
    course_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    credits INT NOT NULL
);

-- Creación de la tabla student
CREATE TABLE student (
    student_id BIGINT PRIMARY KEY AUTO_INCREMENT,
	card_id BIGINT UNIQUE NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    career VARCHAR(255) NOT NULL
);

-- Creación de la tabla academic_history
CREATE TABLE academic_history (
    progress_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    year INT NOT NULL,
    period INT CHECK (period IN (1, 2, 3)) NOT NULL,
    note DECIMAL(2,1) NOT NULL,
	student_id BIGINT,
    course_id BIGINT,
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);
