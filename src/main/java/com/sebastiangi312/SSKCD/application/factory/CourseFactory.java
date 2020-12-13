package com.sebastiangi312.SSKCD.application.factory;

import com.sebastiangi312.SSKCD.domain.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseFactory {
  
  public Course createCourse(long id, String name, int units, double grade){
    return new Course(id,name,units,grade);
  }
}
