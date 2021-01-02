package com.sebastiangi312.SSKCD.persistence.database.fabric;

import com.sebastiangi312.SSKCD.persistence.database.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityFabric {
  
  public CourseEntity createCourseEntity(String code, String name, int units, GroupEntity group) {
    return new CourseEntity(code, name, units, group);
  }
  
}
