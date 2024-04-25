package com.test.academichistory.service;

import com.test.academichistory.model.Course;
import com.test.academichistory.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
  @Autowired
  private CourseRepository courseRepository;
  // METODOS
  // Método para encontrar todos los cursos
  public List<Course> findCourses() {
    return courseRepository.findAll();
  }

  // Método para guardar un nuevo curso
  public Course saveCourse(Course course) {
    return courseRepository.save(course);
  }

  // Método para encontrar un curso por su ID
  public Course findCourseById(Long course_id) {
    Optional<Course> courseOptional = courseRepository.findById(course_id);
    return courseOptional.orElse(null);
  }

  // Método para actualizar un curso existente
  public Course updateCourse(Long course_id, Course newCourse) {
    newCourse.setId(course_id);
    Optional<Course> courseOptional = courseRepository.findById(course_id);
    // Se realiza la validación si el curso ya existe en la base de datos, luego se procede
    // a actualizar los cambios, caso contrario se retorna un null
    if (courseOptional.isPresent()) {
      Course existingCourse = courseOptional.get();
      existingCourse.setName(newCourse.getName());
      existingCourse.setCredits(newCourse.getCredits());
      return courseRepository.save(existingCourse);
    } else {
      return null;
    }
  }

  // Método para eliminar un curso por su ID
  public boolean deleteCourse(Long course_id){
    Optional<Course> courseOptional = courseRepository.findById(course_id);
    // Se valida si ya existe en la base de datos el curso a eliminar y se elimina,
    // Caso contrario se retorna false
    if (courseOptional.isPresent()){
      courseRepository.deleteById(course_id);
      return true;
    } else {
      return false;
    }
  }

}
