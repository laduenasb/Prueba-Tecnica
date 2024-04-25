package com.test.academichistory.controller;

import com.test.academichistory.model.Student;
import com.test.academichistory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/students")
public class StudentController {
  @Autowired
  private StudentService studentService;
  @GetMapping
  public ResponseEntity<List<Student>> getStudents() {
    List<Student> students = studentService.findStudents();
    return ResponseEntity.ok().body(students);
  }

  @GetMapping("/{student_id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Long student_id) {
    Student student = studentService.findStudentById(student_id);
    if (student != null) {
      return ResponseEntity.ok().body(student);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/card_id/{card_id}")
  public ResponseEntity<Student> getStudentByCardId(@PathVariable Long card_id) {
    Student student = studentService.findStudentByCardId(card_id);
    if (student != null) {
      return ResponseEntity.ok().body(student);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  @PostMapping
  public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
    Student savedStudent = studentService.saveStudent(student);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
  }

  @PutMapping("/{student_id}")
  public ResponseEntity<Student> editStudent(@PathVariable Long student_id, @RequestBody Student student) {
    Student updatedStudent = studentService.updateStudent(student_id, student);
    if (updatedStudent != null) {
      return ResponseEntity.ok().body(updatedStudent);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{student_id}")
  public ResponseEntity<Void> removeStudent(@PathVariable Long student_id) {
    boolean deleted = studentService.deleteStudent(student_id);
    if (deleted) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
