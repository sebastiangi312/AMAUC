package com.sebastiangi312.SSKCD.domain.model;

public class ApprovedCourse extends Course{
  
  boolean approved;
  public ApprovedCourse(String code, String name, int untis, boolean approved) {
    super(code, name, untis);
    this.approved = approved;
  }
  
  public boolean isApproved() {
    return approved;
  }
  
  public void setApproved(boolean approved) {
    this.approved = approved;
  }
}
