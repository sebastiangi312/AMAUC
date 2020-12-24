package com.sebastiangi312.SSKCD.application.adapter;

import com.sebastiangi312.SSKCD.application.fabric.CourseFabric;
import com.sebastiangi312.SSKCD.application.pdu.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseAdapter {
  
  private final CourseFabric fabric;
  
  public CourseAdapter(CourseFabric fabric) {
    this.fabric = fabric;
  }
  
  public Course CourseEntityToCourse(Object courseEntity){
    Course course = (Course) courseEntity;
    return fabric.createCourse(course.getName(), course.getCode(), course.getUnits());
  }
}
