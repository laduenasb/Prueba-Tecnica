package com.test.academichistory.service;

import com.test.academichistory.model.Academic_History;
import com.test.academichistory.repository.Academic_HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Academic_HistoryService {

  // Repositorio para acceder a los datos del historial académico en la base de datos
  @Autowired
  private Academic_HistoryRepository academic_HistoryRepository;

  // Método para encontrar todos los registros de historial académico
  public List<Academic_History> findAllAcademicHistories() {
    return academic_HistoryRepository.findAll();
  }

  // Método para encontrar un registro de historial académico por su ID
  public Optional<Academic_History> findAcademicHistoryById(Long progress_id) {
    return academic_HistoryRepository.findById(progress_id);
  }

  // Método para guardar un nuevo registro de historial académico
  public Academic_History saveAcademicHistory(Academic_History academicHistory) {
    return academic_HistoryRepository.save(academicHistory);
  }

  // Método para actualizar un registro de historial académico existente
  public Academic_History updateAcademicHistory(Long progress_id, Academic_History newAcademicHistory) {
    Optional<Academic_History> academicHistoryOptional = academic_HistoryRepository.findById(progress_id);
    // Se realiza la validación si el registro academico ya existe en la base de datos, luego se procede
    // a actualizar los cambios, caso contrario se retorna un null
    if (academicHistoryOptional.isPresent()) {
      Academic_History existingAcademicHistory = academicHistoryOptional.get();
      existingAcademicHistory.setYear(newAcademicHistory.getYear());
      existingAcademicHistory.setPeriod(newAcademicHistory.getPeriod());
      existingAcademicHistory.setNote(newAcademicHistory.getNote());
      existingAcademicHistory.setStudent(newAcademicHistory.getStudent());
      existingAcademicHistory.setCourse(newAcademicHistory.getCourse());
      return academic_HistoryRepository.save(existingAcademicHistory);
    } else {
      return null;
    }
  }

  // Método para eliminar un registro de historial académico por su ID
  public boolean deleteAcademicHistory(Long progress_id) {
    Optional<Academic_History> academicHistoryOptional = academic_HistoryRepository.findById(progress_id);
    // Se valida si ya existe en la base de datos la historia academica a eliminar y se elimina,
    // Caso contrario se retorna false
    if (academicHistoryOptional.isPresent()) {
      academic_HistoryRepository.deleteById(progress_id);
      return true;
    } else {
      return false;
    }
  }
}
