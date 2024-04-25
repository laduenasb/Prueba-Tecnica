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
  public List<Course> findCourses() {
    return courseRepository.findAll();
  }
  public Course saveCourse(Course course) {
    return courseRepository.save(course);
  }
  public Course findCourseById(Long course_id) {
    Optional<Course> courseOptional = courseRepository.findById(course_id);
    return courseOptional.orElse(null);
  }

  public Course updateCourse(Long course_id, Course newCourse) {
    newCourse.setId(course_id);
    Optional<Course> courseOptional = courseRepository.findById(course_id);
    if (courseOptional.isPresent()) {
      Course existingCourse = courseOptional.get();
      existingCourse.setName(newCourse.getName());
      existingCourse.setCredits(newCourse.getCredits());
      return courseRepository.save(existingCourse);
    } else {
      return null;
    }
  }

  public boolean deleteCourse(Long course_id){
    Optional<Course> courseOptional = courseRepository.findById(course_id);
    if (courseOptional.isPresent()){
      courseRepository.deleteById(course_id);
      return true;
    } else {
      return false;
    }
  }

}
