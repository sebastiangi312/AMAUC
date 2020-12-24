package com.sebastiangi312.SSKCD.application.fabric;

import com.sebastiangi312.SSKCD.application.pdu.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseFabric {
  
  public Course createCourse(String name, String code, int units){
    return new Course(name, code, units);
  }
}
