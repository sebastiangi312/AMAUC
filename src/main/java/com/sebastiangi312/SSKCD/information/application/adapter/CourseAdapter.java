package com.sebastiangi312.SSKCD.information.application.adapter;

import com.sebastiangi312.SSKCD.information.application.fabric.CourseFabric;
import com.sebastiangi312.SSKCD.information.application.pdu.Course;
import com.sebastiangi312.SSKCD.persistence.database.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseAdapter {
  
  private final CourseFabric fabric;
  private final GroupAdapter groupAdapter;
  
  public CourseAdapter(CourseFabric fabric, GroupAdapter groupAdapter) {
    this.fabric = fabric;
    this.groupAdapter = groupAdapter;
  }
  
  public Course CourseEntityToCourse(CourseEntity course){
    return fabric.createCourse(course.getName(), course.getCode(), course.getUnits(),
                               groupAdapter.GroupEntityToGroup(course.getGroup()));
  }
}
