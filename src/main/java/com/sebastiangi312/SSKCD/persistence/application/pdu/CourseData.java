package com.sebastiangi312.SSKCD.persistence.application.pdu;

public class CourseData {
  
  private String name;
  private String code;
  private int units;
  
  public CourseData(String name, String code, int units) {
    this.name = name;
    this.code = code;
    this.units = units;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getCode() {
    return code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public int getUnits() {
    return units;
  }
  
  public void setUnits(int units) {
    this.units = units;
  }
  
}
