package com.sebastiangi312.SSKCD.persistence.application.fabric;

import com.sebastiangi312.SSKCD.persistence.application.pdu.CourseData;
import com.sebastiangi312.SSKCD.persistence.application.pdu.GroupData;
import org.springframework.stereotype.Component;

@Component
public class CourseDataFabric {
  
  public CourseData createCourseData(String name, String code, int units){
    return new CourseData(name, code, units);
  }
}
