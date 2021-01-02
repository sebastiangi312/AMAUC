package com.sebastiangi312.SSKCD.information.application.fabric;

import com.sebastiangi312.SSKCD.information.application.pdu.Course;
import com.sebastiangi312.SSKCD.information.application.pdu.Group;
import org.springframework.stereotype.Component;

@Component
public class CourseFabric {
  
  public Course createCourse(String name, String code, int units, Group group){
    return new Course(name, code, units, group);
  }
}
