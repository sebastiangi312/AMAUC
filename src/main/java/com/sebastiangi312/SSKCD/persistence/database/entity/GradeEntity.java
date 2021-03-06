package com.sebastiangi312.SSKCD.persistence.database.entity;

import javax.persistence.*;

@Entity
public class GradeEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @ManyToOne(optional = false,cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
  private CourseEntity course;
  
  private boolean approved;
  private Double grade;
  private String date;
  
  public GradeEntity() {
  }
  
  public GradeEntity(CourseEntity course, boolean approved, Double grade, String date) {
    this.course = course;
    this.approved = approved;
    this.grade = grade;
    this.date = date;
  }
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public CourseEntity getCourse() {
    return course;
  }
  
  public void setCourse(CourseEntity course) {
    this.course = course;
  }
  
  public boolean isApproved() {
    return approved;
  }
  
  public void setApproved(boolean approved) {
    this.approved = approved;
  }
  
  public Double getGrade() {
    return grade;
  }
  
  public void setGrade(Double grade) {
    this.grade = grade;
  }
  
  public String getDate() {
    return date;
  }
  
  public void setDate(String date) {
    this.date = date;
  }
}
