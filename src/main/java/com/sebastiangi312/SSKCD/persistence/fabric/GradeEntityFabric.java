package com.sebastiangi312.SSKCD.persistence.fabric;


import com.sebastiangi312.SSKCD.persistence.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistence.entity.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class GradeEntityFabric {
  
  public GradeEntity createGrade(CourseEntity course, boolean approved, Double grade, String date){
    return new GradeEntity(course,approved,grade,date);
  }
}
