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

  // Servicio para manejar la lógica relacionada con el historial académico
  @Autowired
  private Academic_HistoryService academic_historyService;
  // Servicio para manejar la lógica relacionada con los cursos
  @Autowired
  private CourseService courseService;
  // Servicio para manejar la lógica relacionada con los estudiantes
  @Autowired
  private StudentService studentService;

  // Método para obtener todos los registros de historial académico
  @GetMapping
  public ResponseEntity<List<Academic_History>> getAcademicHistories() {
    // Busca y obtiene todos los registros de historial académico de la base de datos
    List<Academic_History> academicHistories = academic_historyService.findAllAcademicHistories();
    // Verifica si se encontraron registros de historial académico
    if (!academicHistories.isEmpty()) {
      // Devuelve los registros de historial académico con estado OK (200)
      return ResponseEntity.ok().body(academicHistories);
    } else {
      // Si no se encuentran registros de historial académico, devuelve estado NOT FOUND (404)
      return ResponseEntity.notFound().build();
    }
  }

  // Método para obtener un registro de historial académico por su ID
  @GetMapping("/{progress_id}")
  public ResponseEntity<Academic_History> getAcademicHistoryById(@PathVariable Long progress_id) {
    // Busca un registro de historial académico por su ID
    Optional<Academic_History> academicHistoryOptional = academic_historyService.findAcademicHistoryById(progress_id);
    // Verifica si se encontró un registro de historial académico
    if (academicHistoryOptional.isPresent()) {
      // Devuelve el registro de historial académico encontrado con estado OK (200)
      Academic_History academicHistory = academicHistoryOptional.get();
      return ResponseEntity.ok().body(academicHistory);
    } else {
      // Si no se encuentra el registro de historial académico, devuelve estado NOT FOUND (404)
      return ResponseEntity.notFound().build();
    }
  }

  // Método para guardar un nuevo registro de historial académico
  @PostMapping
  public ResponseEntity<Academic_History> saveAcademicHistory(@RequestBody Academic_HistoryDTO academic_historyDTO) {
    // Se usa un DTO porque el cuerpo de esta petición tiene dos atributos son student_id y course_id
    // Pero la clase Academic_History tiene como atributos student y course que son objetos
    // Por lo tanto primero debemos construir el objeto Academic_History y asignarle el estudiante
    // que tiene ese id, lo mismo para course

    // Crea un nuevo registro de historial académico y lo guarda en la base de datos
    Academic_History academic_history = academic_historyDTO.setAcademic_History(academic_historyDTO);
    academic_history.setCourse(courseService.findCourseById(academic_historyDTO.getCourse_id()));
    academic_history.setStudent(studentService.findStudentById(academic_historyDTO.getStudent_id()));
    Academic_History savedAcademicHistory = academic_historyService.saveAcademicHistory(academic_history);
    // Devuelve el registro de historial académico guardado con estado CREATED (201)
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAcademicHistory);
  }

  // Método para editar un registro de historial académico existente
  @PutMapping("/{progress_id}")
  public ResponseEntity<Academic_History> editAcademicHistory(@PathVariable Long progress_id, @RequestBody Academic_HistoryDTO academic_historyDTO){
    // Busca un registro de historial académico por su ID
    Optional<Academic_History> academicHistoryOptional = academic_historyService.findAcademicHistoryById(progress_id);
    // Verifica si se encontró un registro de historial académico
    if (academicHistoryOptional.isPresent()) {
      // Obtiene el registro de historial académico a actualizar
      Academic_History academicHistoryToUpdate = academicHistoryOptional.get();
      // Actualiza la información del registro de historial académico con los datos recibidos en el DTO
      academicHistoryToUpdate.setYear(academic_historyDTO.getYear());
      academicHistoryToUpdate.setPeriod(academic_historyDTO.getPeriod());
      academicHistoryToUpdate.setNote(academic_historyDTO.getNote());
      academicHistoryToUpdate.setCourse(courseService.findCourseById(academic_historyDTO.getCourse_id()));
      academicHistoryToUpdate.setStudent(studentService.findStudentById(academic_historyDTO.getStudent_id()));
      // Guarda el registro de historial académico actualizado en la base de datos
      Academic_History updatedAcademicHistory = academic_historyService.saveAcademicHistory(academicHistoryToUpdate);
      // Devuelve el registro de historial académico actualizado con estado OK (200)
      return ResponseEntity.ok().body(updatedAcademicHistory);
    } else {
      // Si no se encuentra el registro de historial académico, devuelve estado NOT FOUND (404)
      return ResponseEntity.notFound().build();
    }
  }

  // Método para eliminar un registro de historial académico por su ID
  @DeleteMapping("/{progress_id}")
  public ResponseEntity<Void> removeAcademicHistory(@PathVariable Long progress_id){
    // Elimina un registro de historial académico de la base de datos
    boolean result = academic_historyService.deleteAcademicHistory(progress_id);
    // Verifica si el registro de historial académico se eliminó correctamente
    if (result) {
      // Si se elimina correctamente, devuelve una respuesta NO CONTENT (204)
      return ResponseEntity.noContent().build();
    } else {
      // Si no se encuentra el registro de historial académico, devuelve una respuesta NOT FOUND (404)
      return ResponseEntity.notFound().build();
    }
  }


}
