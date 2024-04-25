package com.test.academichistory.service;

import com.test.academichistory.model.Student;
import com.test.academichistory.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
  @Autowired
  private StudentRepository studentRepository;
  public List<Student> findStudents() {
    return studentRepository.findAll();
  }

  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  public Student findStudentById(Long student_Id) {
    Optional<Student> studentOptional = studentRepository.findById(student_Id);
    return studentOptional.orElse(null);
  }

  public Student findStudentByCardId(Long card_id){
    Optional<Student> studentOptional = studentRepository.findByCard_id(card_id);
//    Student studentOptional = studentRepository.findByCardId(card_id);
    return studentOptional.orElse(null);
  }

  public Student updateStudent(Long student_id, Student newStudent) {
    newStudent.setId(student_id);
    Optional<Student> studentOptional = studentRepository.findById(student_id);
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

  public boolean deleteStudent(Long student_id) {
    Optional<Student> studentOptional = studentRepository.findById(student_id);
    if (studentOptional.isPresent()) {
      studentRepository.deleteById(student_id);
      return true;
    } else {
      return false;
    }
  }
}