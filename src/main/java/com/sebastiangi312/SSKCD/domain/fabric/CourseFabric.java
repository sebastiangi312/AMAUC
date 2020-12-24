package com.sebastiangi312.SSKCD.domain.fabric;

import com.sebastiangi312.SSKCD.domain.model.CourseWithoutGrade;
import com.sebastiangi312.SSKCD.domain.model.GradedCourseWithoutGrade;
import org.springframework.stereotype.Component;

@Component
public class CourseFabric {
  
  public CourseWithoutGrade createCourse(String name, String code, int units){
    return new CourseWithoutGrade(code, name, units);
  }
  
  public GradedCourseWithoutGrade createGradedCourse(String name, String code, int units, boolean approved, double grade){
    return new GradedCourseWithoutGrade(code, name, units, approved, grade);
  }
}
