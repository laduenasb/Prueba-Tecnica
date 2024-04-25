package com.test.academichistory.dto;

import com.test.academichistory.model.Academic_History;

import java.math.BigDecimal;

public class Academic_HistoryDTO {
  // ATRIBUTOS
  private Long progress_id;
  private Integer year;
  private Integer period;
  private BigDecimal note;
  private Long student_id;
  private Long course_id;

  // CONSTRUCTOR
  public Academic_HistoryDTO(Long progress_id, Integer year, Integer period, BigDecimal note, Long student_id, Long course_id) {
    this.progress_id = progress_id;
    this.year = year;
    this.period = period;
    this.note = note;
    this.student_id = student_id;
    this.course_id = course_id;
  }

  // Construir un objeto academic_history con los mismos datos que recibe de academic_historyDTO
  public Academic_History setAcademic_History(Academic_HistoryDTO academic_historyDTO){
    Academic_History academic_History = new Academic_History();
    academic_History.setId(academic_historyDTO.getProgress_id());
    academic_History.setYear(academic_historyDTO.getYear());
    academic_History.setPeriod(academic_historyDTO.getPeriod());
    academic_History.setNote(academic_historyDTO.getNote());
    return academic_History;
  }

  // GETTERS Y SETTERS

  public Long getProgress_id() {
    return progress_id;
  }

  public void setProgress_id(Long progress_id) {
    this.progress_id = progress_id;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getPeriod() {
    return period;
  }

  public void setPeriod(Integer period) {
    this.period = period;
  }

  public BigDecimal getNote() {
    return note;
  }

  public void setNote(BigDecimal note) {
    this.note = note;
  }

  public Long getStudent_id() {
    return student_id;
  }

  public void setStudent_id(Long student_id) {
    this.student_id = student_id;
  }

  public Long getCourse_id() {
    return course_id;
  }

  public void setCourse_id(Long course_id) {
    this.course_id = course_id;
  }
}
