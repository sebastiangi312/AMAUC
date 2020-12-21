package com.sebastiangi312.SSKCD.application.adapter.entityAdpaters;

import com.sebastiangi312.SSKCD.persistance.fabric.CourseEntityFabric;
import com.sebastiangi312.SSKCD.persistance.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityAdapter {
  
  private final CourseEntityFabric entityFabric;
  
  public CourseEntityAdapter(CourseEntityFabric entityFabric) {
    this.entityFabric = entityFabric;
  }
  
  public CourseEntity adaptStringToCourseEntity(String code, String name, String units){
    return entityFabric.createCourseEntity(code, name, Integer.parseInt(units));
  }
  
}
