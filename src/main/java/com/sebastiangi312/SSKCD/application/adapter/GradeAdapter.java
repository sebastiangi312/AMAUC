package com.sebastiangi312.SSKCD.application.adapter;

import com.sebastiangi312.SSKCD.application.fabric.GradeFabric;
import com.sebastiangi312.SSKCD.application.pdu.Grade;
import org.springframework.stereotype.Component;

@Component
public class GradeAdapter {
  
  private final GradeFabric fabric;
  
  public GradeAdapter(GradeFabric fabric) {
    this.fabric = fabric;
  }
  
  
  public Grade GradeEntityToCourse(Object gradeEntity){
    Grade grade = (Grade) gradeEntity;
    return  fabric.createGrade(grade.getCourse(),grade.isApproved(),
                                grade.getGrade(), grade.getDate());
  }
}
