package com.sebastiangi312.SSKCD.information.application.pdu;

public class Course {
  
  private String name;
  private String code;
  private int units;
  private Group group;
  
  public Course(String name, String code, int units, Group group) {
    this.name = name;
    this.code = code;
    this.units = units;
    this.group = group;
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
  
  public Group getGroup() {
    return group;
  }
  
  public void setGroup(Group group) {
    this.group = group;
  }
}
