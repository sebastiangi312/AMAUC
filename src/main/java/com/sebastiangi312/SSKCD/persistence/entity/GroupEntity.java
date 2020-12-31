package com.sebastiangi312.SSKCD.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GroupEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  
  private String name;
  private String Component;
  private String degree;
  private int minUnits;
  
  public GroupEntity() {
  }
  
  public GroupEntity(String name, String component, String degree, int minUnits) {
    this.name = name;
    Component = component;
    this.degree = degree;
    this.minUnits = minUnits;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getComponent() {
    return Component;
  }
  
  public void setComponent(String component) {
    Component = component;
  }
  
  public String getDegree() {
    return degree;
  }
  
  public void setDegree(String degree) {
    this.degree = degree;
  }
  
  public int getMinUnits() {
    return minUnits;
  }
  
  public void setMinUnits(int minUnits) {
    this.minUnits = minUnits;
  }
}
