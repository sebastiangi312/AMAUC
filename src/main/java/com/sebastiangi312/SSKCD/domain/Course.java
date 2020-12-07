package com.sebastiangi312.SSKCD.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

  @Id
  private int id;
  private String name;
  private int units;
  private double grade;
  
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
  
  public double getGrade() {
    return grade;
  }
  
  public void setGrade(double grade) {
    this.grade = grade;
  }
  
  @Override
  public String toString() {
    return "Course{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", units=" + units +
      ", grade=" + grade +
      '}';
  }
}
