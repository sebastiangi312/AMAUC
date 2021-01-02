package com.sebastiangi312.SSKCD.persistence.application.pdu;

public class GradeData {
  
  private boolean approved;
  private Double grade;
  private String date;
  
  public GradeData(boolean approved, Double grade, String date) {
    this.approved = approved;
    this.grade = grade;
    this.date = date;
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
