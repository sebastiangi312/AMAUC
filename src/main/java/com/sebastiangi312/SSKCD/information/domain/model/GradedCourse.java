package com.sebastiangi312.SSKCD.information.domain.model;

public class GradedCourse {
  
  private String code;
  private String name;
  private String date;
  private int units;
  private boolean isApproved;
  private double grade;
  
  
  public GradedCourse(String code, String name, int units,
                       boolean isApproved, double grade, String date) {
    this.code = code;
    this.name = name;
    this.units = units;
    this.isApproved = isApproved;
    this.grade = grade;
    this.date = date;
  }
  
  
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDate() {
    return date;
  }
  
  public void setDate(String date) {
    this.date = date;
  }
  
  public int getUnits() {
    return units;
  }
  
  public void setUnits(int units) {
    this.units = units;
  }
  
  public boolean isApproved() {
    return isApproved;
  }
  
  public void setApproved(boolean approved) {
    isApproved = approved;
  }
  
  public double getGrade() {
    return grade;
  }
  
  public void setGrade(double grade) {
    this.grade = grade;
  }
}
