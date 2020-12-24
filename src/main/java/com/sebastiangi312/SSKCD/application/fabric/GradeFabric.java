package com.sebastiangi312.SSKCD.application.fabric;

import com.sebastiangi312.SSKCD.application.pdu.Course;
import com.sebastiangi312.SSKCD.application.pdu.Grade;
import org.springframework.stereotype.Component;

@Component
public class GradeFabric {
  
  public Grade createGrade(Course course, boolean approved, Double grade, String date){
    return new Grade(course,approved,grade,date);
  }
}
