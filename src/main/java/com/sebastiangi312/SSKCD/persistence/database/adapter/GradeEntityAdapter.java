package com.sebastiangi312.SSKCD.persistence.database.adapter;

import com.sebastiangi312.SSKCD.persistence.application.pdu.GradeData;
import com.sebastiangi312.SSKCD.persistence.database.fabric.GradeEntityFabric;
import com.sebastiangi312.SSKCD.persistence.database.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistence.database.entity.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class GradeEntityAdapter {
  
  private final GradeEntityFabric fabric;
  
  public GradeEntityAdapter(GradeEntityFabric fabric) {
    this.fabric = fabric;
  }
  
  public GradeEntity gradeDataToGradeEntity(CourseEntity course, GradeData gradeData){
    return fabric.createGrade(course, gradeData.isApproved(), gradeData.getGrade(), gradeData.getDate());
  }
}
