package com.sebastiangi312.SSKCD.application.comando;


import com.sebastiangi312.SSKCD.domain.Course;

public class CourseComando {
  
  private String id;
  private String name;
  private int units;
  private double grade;
  
  
  private Course.typeCourse isGradable;
  
  public CourseComando(String id, String name, int units, double grade, Course.typeCourse isGradable) {
    this.id = id;
    this.name = name;
    this.units = units;
    this.grade = grade;
    this.isGradable = isGradable;
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
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
  public Course.typeCourse getIsGradable() {
    return isGradable;
  }
  
  public void setIsGradable(Course.typeCourse isGradable) {
    this.isGradable = isGradable;
  }
}
