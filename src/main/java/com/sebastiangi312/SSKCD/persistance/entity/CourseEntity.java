package com.sebastiangi312.SSKCD.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String code;
  private String name;
  private int units;
  
  public CourseEntity() {
  }
  
  public CourseEntity( String code, String name, int units) {
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
