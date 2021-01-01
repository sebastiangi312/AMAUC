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
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GroupEntity)) return false;
    
    GroupEntity that = (GroupEntity) o;
    
    if (getMinUnits() != that.getMinUnits()) return false;
    if (!getName().equals(that.getName())) return false;
    if (!getComponent().equals(that.getComponent())) return false;
    return getDegree().equals(that.getDegree());
  }
  
  @Override
  public int hashCode() {
    int result = getName().hashCode();
    result = 31 * result + getComponent().hashCode();
    result = 31 * result + getDegree().hashCode();
    result = 31 * result + getMinUnits();
    return result;
  }
}
