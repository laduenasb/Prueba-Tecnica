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
  @Autowired
  CourseService courseService;

  @GetMapping
  public ResponseEntity<List<Course>> getCourses() {
    List<Course> courses = courseService.findCourses();
    return ResponseEntity.ok().body(courses);
  }
  @GetMapping("/{course_id}")
  public ResponseEntity<Course> getCourseById(@PathVariable Long course_id) {
    Course course = courseService.findCourseById(course_id);
    if (course != null) {
      return ResponseEntity.ok().body(course);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  @PostMapping
  public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
    Course savedCourse = courseService.saveCourse(course);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
  }
  @PutMapping("/{course_id}")
  public ResponseEntity<Course> editCourse(@PathVariable Long course_id, @RequestBody Course course) {
    Course updatedCourse = courseService.updateCourse(course_id, course);
    if (updatedCourse != null) {
      return ResponseEntity.ok().body(updatedCourse);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  @DeleteMapping("/{course_id}")
  public ResponseEntity<Void> removeCourse(@PathVariable Long course_id) {
    boolean deleted = courseService.deleteCourse(course_id);
    if (deleted) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
