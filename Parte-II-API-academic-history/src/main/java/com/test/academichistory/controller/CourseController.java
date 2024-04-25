package com.test.academichistory.controller;

import com.test.academichistory.model.Course;
import com.test.academichistory.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/courses")
public class CourseController {

  // Servicio para manejar la lógica relacionada con los cursos
  @Autowired
  CourseService courseService;

  // Método para obtener todos los cursos
  @GetMapping
  public ResponseEntity<List<Course>> getCourses() {
    // Busca y obtiene todos los cursos de la base de datos
    List<Course> courses = courseService.findCourses();
    // Devuelve los cursos obtenidos con estado OK (200)
    return ResponseEntity.ok().body(courses);
  }

  // Método para obtener un curso por su ID
  @GetMapping("/{course_id}")
  public ResponseEntity<Course> getCourseById(@PathVariable Long course_id) {
    // Busca un curso por su ID
    Course course = courseService.findCourseById(course_id);
    // Verifica si se encontró un curso
    if (course != null) {
      // Devuelve el curso encontrado con estado OK (200)
      return ResponseEntity.ok().body(course);
    } else {
      // Si no se encuentra el curso, devuelve estado NOT FOUND (404)
      return ResponseEntity.notFound().build();
    }
  }

  // Método para guardar un nuevo curso
  @PostMapping
  public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
    // Guarda un nuevo curso en la base de datos
    Course savedCourse = courseService.saveCourse(course);
    // Devuelve el curso guardado con estado CREATED (201)
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
  }

  // Método para editar un curso existente
  @PutMapping("/{course_id}")
  public ResponseEntity<Course> editCourse(@PathVariable Long course_id, @RequestBody Course course) {
    // Actualiza la información de un curso existente en la base de datos
    Course updatedCourse = courseService.updateCourse(course_id, course);
    // Si se encuentra y actualiza correctamente el curso, devuelve el curso actualizado con estado OK (200)
    // Si no se encuentra el curso, devuelve una respuesta NOT FOUND (404)
    if (updatedCourse != null) {
      return ResponseEntity.ok().body(updatedCourse);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Método para eliminar un curso por su ID
  @DeleteMapping("/{course_id}")
  public ResponseEntity<Void> removeCourse(@PathVariable Long course_id) {
    // Elimina un curso de la base de datos
    boolean deleted = courseService.deleteCourse(course_id);
    // Si el curso se elimina correctamente, devuelve una respuesta NO CONTENT (204)
    // Si no se encuentra el curso, devuelve una respuesta NOT FOUND (404)
    if (deleted) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
