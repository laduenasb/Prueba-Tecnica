package com.test.academichistory.controller;

import com.test.academichistory.dto.Academic_HistoryDTO;
import com.test.academichistory.model.Academic_History;
import com.test.academichistory.service.Academic_HistoryService;
import com.test.academichistory.service.CourseService;
import com.test.academichistory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path= "api/v1/academic_histories")
public class Academic_HistoryController {

  @Autowired
  private Academic_HistoryService academic_historyService;
  @Autowired
  private CourseService courseService;
  @Autowired
  private StudentService studentService;

  @GetMapping
  public ResponseEntity<List<Academic_History>> getAcademicHistories() {
    List<Academic_History> academicHistories = academic_historyService.findAllAcademicHistories();
    if (!academicHistories.isEmpty()) {
      return ResponseEntity.ok().body(academicHistories);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/{progress_id}")
  public ResponseEntity<Academic_History> getAcademicHistoryById(@PathVariable Long progress_id) {
    Optional<Academic_History> academicHistoryOptional = academic_historyService.findAcademicHistoryById(progress_id);
    if (academicHistoryOptional.isPresent()) {
      Academic_History academicHistory = academicHistoryOptional.get();
      return ResponseEntity.ok().body(academicHistory);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Academic_History> saveAcademicHistory(@RequestBody Academic_HistoryDTO academic_historyDTO) {
    Academic_History academic_history = academic_historyDTO.setAcademic_History(academic_historyDTO);
    academic_history.setCourse(courseService.findCourseById(academic_historyDTO.getCourse_id()));
    academic_history.setStudent(studentService.findStudentById(academic_historyDTO.getStudent_id()));
    Academic_History savedAcademicHistory = academic_historyService.saveAcademicHistory(academic_history);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAcademicHistory);
  }


  @PutMapping("/{progress_id}")
  public ResponseEntity<Academic_History> editAcademicHistory(@PathVariable Long progress_id, @RequestBody Academic_HistoryDTO academic_historyDTO){
    Optional<Academic_History> academicHistoryOptional = academic_historyService.findAcademicHistoryById(progress_id);
    if (academicHistoryOptional.isPresent()) {
      Academic_History academicHistoryToUpdate = academicHistoryOptional.get();
      academicHistoryToUpdate.setYear(academic_historyDTO.getYear());
      academicHistoryToUpdate.setPeriod(academic_historyDTO.getPeriod());
      academicHistoryToUpdate.setNote(academic_historyDTO.getNote());
      academicHistoryToUpdate.setCourse(courseService.findCourseById(academic_historyDTO.getCourse_id()));
      academicHistoryToUpdate.setStudent(studentService.findStudentById(academic_historyDTO.getStudent_id()));
      Academic_History updatedAcademicHistory = academic_historyService.saveAcademicHistory(academicHistoryToUpdate);
      return ResponseEntity.ok().body(updatedAcademicHistory);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{progress_id}")
  public ResponseEntity<Void> removeAcademicHistory(@PathVariable Long progress_id){
    boolean result = academic_historyService.deleteAcademicHistory(progress_id);
    if (result) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }


}
