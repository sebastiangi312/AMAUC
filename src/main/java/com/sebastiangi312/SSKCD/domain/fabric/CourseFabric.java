package com.sebastiangi312.SSKCD.domain.fabric;

import com.sebastiangi312.SSKCD.domain.model.Course;
import com.sebastiangi312.SSKCD.domain.model.GradedCourse;
import org.springframework.stereotype.Component;

@Component
public class CourseFabric {
  
  public Course createCourse(String name, String code, int units){
    return new Course(code, name, units);
  }
  
  public GradedCourse createGradedCourse(String name, String code, int units, boolean approved, double grade){
    return new GradedCourse(code, name, units, approved, grade);
  }
}
