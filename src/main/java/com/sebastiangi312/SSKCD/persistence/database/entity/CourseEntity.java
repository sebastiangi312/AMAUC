package com.sebastiangi312.SSKCD.persistence.database.entity;

import javax.persistence.*;

@Entity
public class CourseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @Column(unique = true)
  private String code;
  
  private String name;
  private int units;
  @ManyToOne(optional = false,cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
  private GroupEntity group;
  
  public CourseEntity() {
  }
  
  public CourseEntity( String code, String name, int units, GroupEntity group) {
    this.code = code;
    this.name = name;
    this.units = units;
    this.group = group;
  }
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
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
  
  public GroupEntity getGroup() {
    return group;
  }
  
  public void setGroup(GroupEntity groupEntity) {
    this.group = groupEntity;
  }
}
