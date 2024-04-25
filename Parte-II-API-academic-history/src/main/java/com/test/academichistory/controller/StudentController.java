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

  // Servicio para manejar la lógica relacionada con los estudiantes
  @Autowired
  private StudentService studentService;

  // Metodo para obtener todos los estudiantes
  @GetMapping
  public ResponseEntity<List<Student>> getStudents() {
    // Busca y obtiene todos los estudiantes de la base de datos
    List<Student> students = studentService.findStudents();
    // Devuelve los estudiantes obtenidos con estado OK (200)
    return ResponseEntity.ok().body(students);
  }

  // Metodo para obtener un estudiante por su ID
  @GetMapping("/{student_id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Long student_id) {
    // Busca un estudiante por su ID
    Student student = studentService.findStudentById(student_id);
    // Verifica si se encontró un estudiante
    if (student != null) {
      // Devuelve el estudiante encontrado con estado OK (200)
      return ResponseEntity.ok().body(student);
    } else {
      // Si no se encuentra el estudiante, devuelve estado NOT FOUND (404)
      return ResponseEntity.notFound().build();
    }
  }

  // Método para obtener un estudiante por su card_id(similar a la cedula)
  @GetMapping("/card_id/{card_id}")
  public ResponseEntity<Student> getStudentByCardId(@PathVariable Long card_id) {
    // Busca un estudiante por su card_id
    Student student = studentService.findStudentByCardId(card_id);
    // Verifica si se encontró un estudiante
    if (student != null) {
      // Devuelve el estudiante encontrado con estado OK (200)
      return ResponseEntity.ok().body(student);
    } else {
      // Si no se encuentra el estudiante, devuelve estado NOT FOUND (404)
      return ResponseEntity.notFound().build();
    }
  }

  // Método para guardar un nuevo estudiante
  @PostMapping
  public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
    // Guarda un nuevo estudiante en la base de datos
    Student savedStudent = studentService.saveStudent(student);
    // Devuelve el estudiante guardado con estado CREATED (201)
    return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
  }

  // Método para editar un estudiante existente
  @PutMapping("/{student_id}")
  public ResponseEntity<Student> editStudent(@PathVariable Long student_id, @RequestBody Student student) {
    // Actualiza la información de un estudiante existente en la base de datos
    Student updatedStudent = studentService.updateStudent(student_id, student);
    // Si se encuentra y actualiza correctamente el estudiante, devuelve el estudiante actualizado con estado OK (200)
    // Si no se encuentra el estudiante, devuelve una respuesta NOT FOUND (404)
    if (updatedStudent != null) {
      return ResponseEntity.ok().body(updatedStudent);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Método para eliminar un estudiante por su ID
  @DeleteMapping("/{student_id}")
  public ResponseEntity<Void> removeStudent(@PathVariable Long student_id) {
    // Elimina un estudiante de la base de datos
    boolean deleted = studentService.deleteStudent(student_id);
    // Si el estudiante se elimina correctamente, devuelve una respuesta NO CONTENT (204)
    // Si no se encuentra el estudiante, devuelve una respuesta NOT FOUND (404)
    if (deleted) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
