package com.sebastiangi312.SSKCD.persistence.application.adapter;

import com.sebastiangi312.SSKCD.persistence.application.fabric.CourseDataFabric;
import com.sebastiangi312.SSKCD.persistence.application.pdu.CourseData;
import com.sebastiangi312.SSKCD.persistence.database.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseDataAdapter {
  
  private final CourseDataFabric fabric;
  
  public CourseDataAdapter(CourseDataFabric fabric) {
    this.fabric = fabric;
  }
  
  public CourseData CourseEntityToCourseData(CourseEntity course){
    return fabric.createCourseData(course.getName(), course.getCode(), course.getUnits());
  }
  
  public CourseData StringToCourseData(String code, String name, String units){
    return fabric.createCourseData(name,code,Integer.parseInt(units));
  }
}
