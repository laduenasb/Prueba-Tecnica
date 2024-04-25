package com.test.academichistory.model;

import jakarta.persistence.*;

@Entity
@Table
public class Student {

  // ATRIBUTOS
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long student_id;
  @Column(unique = true, nullable = false)
  private Long card_id;
  @Column(nullable = false)
  private String first_name;
  @Column(nullable = false)
  private String last_name;
  @Column(nullable = false)
  private Integer age;
  @Column(nullable = false)
  private String career;

  // CONSTRUCTORES

  public Student(){
  }
  public Student(Long student_id, Long card_id, String first_name, String last_name, Integer age, String career) {
    this.student_id = student_id;
    this.card_id = card_id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.age = age;
    this.career = career;
  }

  // GETTERS Y SETTERS

  public Long getId() {
    return student_id;
  }

  public void setId(Long student_id) {
    this.student_id = student_id;
  }

  public Long getCard_id() {
    return card_id;
  }

  public void setCard_id(Long card_id) {
    this.card_id = card_id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }
}
