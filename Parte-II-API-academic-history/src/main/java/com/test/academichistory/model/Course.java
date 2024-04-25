package com.test.academichistory.model;

import jakarta.persistence.*;

@Entity
@Table
public class Course {

  // ATRIBUTOS
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long course_id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private Integer credits;

  // CONSTRUCTORES
  public Course(){
  }
  public Course(Long course_id, String name, Integer credits) {
    this.course_id = course_id;
    this.name = name;
    this.credits = credits;
  }

  // GETTERS Y SETTERS


  public Long getId() {
    return course_id;
  }

  public void setId(Long course_id) {
    this.course_id = course_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCredits() {
    return credits;
  }

  public void setCredits(Integer credits) {
    this.credits = credits;
  }
}
