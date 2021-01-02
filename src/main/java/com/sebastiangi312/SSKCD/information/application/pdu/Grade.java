package com.sebastiangi312.SSKCD.information.application.pdu;

public class Grade {
  
  private Course course;
  private boolean approved;
  private Double grade;
  private String date;
  
  public Grade(Course course, boolean approved, Double grade, String date) {
    this.course = course;
    this.approved = approved;
    this.grade = grade;
    this.date = date;
  }
  
  public Course getCourse() {
    return course;
  }
  
  public void setCourse(Course course) {
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
