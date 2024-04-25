package com.test.academichistory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

@Entity
@Table
public class Academic_History {

  // ATRIBUTOS
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long progress_id;
  @Column(nullable = false)
  private Integer year;
  // El periodo puede ser 1, 2 o 3 no hay mas posibilidades
  @Column(nullable = false)
  @Min(value = 1, message = "El valor mínimo permitido es 1")
  @Max(value = 3, message = "El valor máximo permitido es 3")
  private Integer period;
  // La nota solo tiene un digito despues del punto digital, por ejemplo: 3.5
  @Column(precision = 2, scale = 1, nullable = false)
  private BigDecimal note;
  // Relación de uno a muchos entre student y academic_history
  @ManyToOne @JoinColumn(name="student_id")
  private Student student;
  // Relación de uno a muchos entre course y academic_history
  @ManyToOne @JoinColumn(name="course_id")
  private Course course;

  // CONSTRUCTORES

  public Academic_History() {}

  public Academic_History(Long progress_id, Integer year, Integer period, BigDecimal note, Student student, Course course) {
    this.progress_id = progress_id;
    this.year = year;
    this.period = period;
    this.note = note;
    this.student = student;
    this.course = course;
  }

  // GETTERS Y SETTERS

  public Long getId() {
    return progress_id;
  }

  public void setId(Long progress_id) {
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

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }
}
