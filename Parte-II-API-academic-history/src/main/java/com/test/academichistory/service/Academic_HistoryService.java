package com.test.academichistory.service;

import com.test.academichistory.model.Academic_History;
import com.test.academichistory.repository.Academic_HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Academic_HistoryService {
  @Autowired
  private Academic_HistoryRepository academic_HistoryRepository;

  public List<Academic_History> findAllAcademicHistories() {
    return academic_HistoryRepository.findAll();
  }

  public Optional<Academic_History> findAcademicHistoryById(Long progress_id) {
    return academic_HistoryRepository.findById(progress_id);
  }

  public Academic_History saveAcademicHistory(Academic_History academicHistory) {
    return academic_HistoryRepository.save(academicHistory);
  }

  public Academic_History updateAcademicHistory(Long progress_id, Academic_History newAcademicHistory) {
    Optional<Academic_History> academicHistoryOptional = academic_HistoryRepository.findById(progress_id);
    if (academicHistoryOptional.isPresent()) {
      Academic_History existingAcademicHistory = academicHistoryOptional.get();
      existingAcademicHistory.setYear(newAcademicHistory.getYear());
      existingAcademicHistory.setPeriod(newAcademicHistory.getPeriod());
      existingAcademicHistory.setNote(newAcademicHistory.getNote());
      existingAcademicHistory.setStudent(newAcademicHistory.getStudent());
      existingAcademicHistory.setCourse(newAcademicHistory.getCourse());
      return academic_HistoryRepository.save(existingAcademicHistory);
    } else {
      // Handle error: academic history not found
      return null;
    }
  }

  public boolean deleteAcademicHistory(Long progress_id) {
    Optional<Academic_History> academicHistoryOptional = academic_HistoryRepository.findById(progress_id);
    if (academicHistoryOptional.isPresent()) {
      academic_HistoryRepository.deleteById(progress_id);
      return true;
    } else {
      return false;
    }
  }
}
