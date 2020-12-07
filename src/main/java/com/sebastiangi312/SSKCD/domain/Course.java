package com.sebastiangi312.SSKCD.domain;

public class Course {

  private int id;
  private String name;
  private int units;
  private int grade;
  
  public Course() {
  
  }
  
  public Course(int id, String name, int units, int grade) {
    this.id = id;
    this.name = name;
    this.units = units;
    this.grade = grade;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getUnits() {
    return units;
  }
  
  public void setUnits(int units) {
    this.units = units;
  }
  
  public int getGrade() {
    return grade;
  }
  
  public void setGrade(int grade) {
    this.grade = grade;
  }
}
