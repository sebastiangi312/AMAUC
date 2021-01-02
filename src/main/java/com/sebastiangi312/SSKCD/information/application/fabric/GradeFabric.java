package com.sebastiangi312.SSKCD.information.application.fabric;

import com.sebastiangi312.SSKCD.information.application.pdu.Course;
import com.sebastiangi312.SSKCD.information.application.pdu.Grade;
import org.springframework.stereotype.Component;

@Component
public class GradeFabric {
  
  public Grade createGrade(Course course, boolean approved, Double grade, String date){
    return new Grade(course,approved,grade,date);
  }
}
