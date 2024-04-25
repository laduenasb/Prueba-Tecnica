package com.test.academichistory.service;

import com.test.academichistory.model.Student;
import com.test.academichistory.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  // Repositorio para acceder a los datos de los estudiantes en la base de datos
  @Autowired
  private StudentRepository studentRepository;

  // Método para encontrar todos los estudiantes
  public List<Student> findStudents() {
    return studentRepository.findAll();
  }

  // Método para guardar un nuevo estudiante
  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  // Método para encontrar un estudiante por su ID
  public Student findStudentById(Long student_Id) {
    Optional<Student> studentOptional = studentRepository.findById(student_Id);
    return studentOptional.orElse(null);
  }

  // Método para encontrar un estudiante por su card_id(similar a la cedula)
  public Student findStudentByCardId(Long card_id){
    Optional<Student> studentOptional = studentRepository.findByCard_id(card_id);
    return studentOptional.orElse(null);
  }

  // Método para actualizar un estudiante existente
  public Student updateStudent(Long student_id, Student newStudent) {
    newStudent.setId(student_id);
    Optional<Student> studentOptional = studentRepository.findById(student_id);
    // Se realiza la validación si el estudiante ya existe en la base de datos, luego se procede
    // a actualizar los cambios, caso contrario se retorna un null
    if (studentOptional.isPresent()) {
      Student existingStudent = studentOptional.get();
      existingStudent.setCard_id(newStudent.getCard_id());
      existingStudent.setFirst_name(newStudent.getFirst_name());
      existingStudent.setLast_name(newStudent.getLast_name());
      existingStudent.setAge(newStudent.getAge());
      existingStudent.setCareer(newStudent.getCareer());
      return studentRepository.save(existingStudent);
    } else {
      return null;
    }
  }

  // Método para eliminar un estudiante por su ID, si se elimino el estudiante retorna true
  // Sino devuelve false
  public boolean deleteStudent(Long student_id) {
    Optional<Student> studentOptional = studentRepository.findById(student_id);
    // Se valida si ya existe en la base de datos el estudiante a eliminar y se elimina,
    // Caso contrario se retorna false
    if (studentOptional.isPresent()) {
      studentRepository.deleteById(student_id);
      return true;
    } else {
      return false;
    }
  }
}