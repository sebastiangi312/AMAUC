package com.sebastiangi312.SSKCD.information.domain.adapter;

import com.sebastiangi312.SSKCD.information.application.pdu.Course;
import com.sebastiangi312.SSKCD.information.application.pdu.Grade;
import com.sebastiangi312.SSKCD.information.domain.fabric.GradedCourseFabric;
import com.sebastiangi312.SSKCD.information.domain.model.GradedCourse;
import org.springframework.stereotype.Component;

@Component
public class GradedCourseAdapter {
  
  private final GradedCourseFabric fabric;
  
  public GradedCourseAdapter(GradedCourseFabric fabric) {
    this.fabric = fabric;
  }
  
  public GradedCourse ObjectToGradedCourse(Course course, Grade grade){
    return fabric.createGradedCourse(course.getCode(), course.getName(), course.getUnits(),
                                      grade.isApproved(), grade.getGrade(), grade.getDate());
  }
}
