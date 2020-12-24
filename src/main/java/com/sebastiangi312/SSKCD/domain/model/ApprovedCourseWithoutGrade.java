package com.sebastiangi312.SSKCD.domain.model;

public class ApprovedCourseWithoutGrade extends CourseWithoutGrade {
  
  boolean approved;
  public ApprovedCourseWithoutGrade(String code, String name, int untis, boolean approved) {
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
