package com.sebastiangi312.SSKCD.persistence.application.fabric;

import com.sebastiangi312.SSKCD.persistence.application.pdu.CourseData;
import com.sebastiangi312.SSKCD.persistence.application.pdu.GradeData;
import org.springframework.stereotype.Component;

@Component
public class GradeDataFabric {
  
  public GradeData createGrade(boolean approved, Double grade, String date){
    return new GradeData(approved,grade,date);
  }
}
