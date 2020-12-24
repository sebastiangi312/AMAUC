package com.sebastiangi312.SSKCD.domain.model;

public class CourseWithoutGrade {
  
  String code;
  String name;
  int units;
  
  public CourseWithoutGrade(String code, String name, int units) {
    this.code = code;
    this.name = name;
    this.units = units;
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
  
  public int getUnits() {
    return units;
  }
  
  public void setUnits(int units) {
    this.units = units;
  }
}
