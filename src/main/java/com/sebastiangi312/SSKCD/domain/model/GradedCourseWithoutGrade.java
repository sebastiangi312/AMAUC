package com.sebastiangi312.SSKCD.domain.model;

public class GradedCourseWithoutGrade extends ApprovedCourseWithoutGrade {
  
  private double grade;
  
  public GradedCourseWithoutGrade(String code, String name, int untis, boolean isApproved, double grade) {
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
