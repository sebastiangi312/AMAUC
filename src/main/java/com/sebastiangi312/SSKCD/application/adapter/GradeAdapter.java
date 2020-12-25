package com.sebastiangi312.SSKCD.application.adapter;

import com.sebastiangi312.SSKCD.application.fabric.GradeFabric;
import com.sebastiangi312.SSKCD.application.pdu.Course;
import com.sebastiangi312.SSKCD.application.pdu.Grade;
import com.sebastiangi312.SSKCD.persistence.entity.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class GradeAdapter {
  
  private final GradeFabric fabric;
  private final CourseAdapter courseAdapter;
  
  public GradeAdapter(GradeFabric fabric, CourseAdapter courseAdapter) {
    this.fabric = fabric;
    this.courseAdapter = courseAdapter;
  }
  
  
  public Grade GradeEntityToCourse(Object gradeEntity){
    GradeEntity grade = (GradeEntity) gradeEntity;
    return  fabric.createGrade(
                    courseAdapter.CourseEntityToCourse(grade.getCourse()), grade.isApproved(),
                                                       grade.getGrade(), grade.getDate());
  }
  
}


