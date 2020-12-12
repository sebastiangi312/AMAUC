package com.sebastiangi312.SSKCD.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course implements Comparable<Course> {
  
  @Id
  private long id;
  private String name;
  private int units;
  private double grade;
  
  public Course() {
  
  }
  
  public Course(long id, String name, int units, double grade) {
    this.id = id;
    this.name = name;
    this.units = units;
    this.grade = grade;
  }
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
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
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Course course = (Course) o;
    
    if (id != course.id) return false;
    if (units != course.units) return false;
    if (Double.compare(course.grade, grade) != 0) return false;
    return name.equals(course.name);
  }
  
  @Override
  public int compareTo(Course that) {
    return Long.compare(this.id, that.id);
  }
}
