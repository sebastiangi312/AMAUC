package com.sebastiangi312.SSKCD.domain.model;

public class GradedCourse extends ApprovedCourse {
  
  private double grade;
  
  public GradedCourse(String code, String name, int untis, boolean isApproved, double grade) {
    super(code, name, untis, isApproved);
    this.grade = grade;
  }
  
  public double getGrade() {
    return grade;
  }
  
  public void setGrade(double grade) {
    this.grade = grade;
  }
}
