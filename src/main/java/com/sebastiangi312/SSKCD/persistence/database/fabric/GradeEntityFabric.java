package com.sebastiangi312.SSKCD.persistence.database.fabric;


import com.sebastiangi312.SSKCD.persistence.database.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistence.database.entity.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class GradeEntityFabric {
  
  public GradeEntity createGrade(CourseEntity course, boolean approved, Double grade, String date){
    return new GradeEntity(course,approved,grade,date);
  }
}
