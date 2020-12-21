package com.sebastiangi312.SSKCD.persistence.fabric;

import com.sebastiangi312.SSKCD.persistence.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityFabric {
  
  public CourseEntity createCourseEntity(String code, String name, int units) {
    return new CourseEntity(code, name, units);
  }
  
}
