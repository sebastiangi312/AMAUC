package com.sebastiangi312.SSKCD.application.adapter;

import com.sebastiangi312.SSKCD.application.fabric.GradeEntityFabric;
import com.sebastiangi312.SSKCD.persistance.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistance.entity.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class GradeEntityAdapter {
  
  private final GradeEntityFabric fabric;
  
  public GradeEntityAdapter(GradeEntityFabric fabric) {
    this.fabric = fabric;
  }
  
  public GradeEntity adaptToGradeEntity(CourseEntity course, String approved, String graded,String date){
    boolean isApproved = approved.equals("APROBADA\r");
    Double grade;
    if(isNumeric(graded))
      grade = Double.parseDouble(graded);
    else
      grade = null;
    return fabric.createGrade(course, isApproved,grade,date);
  }
  
  private boolean isNumeric(String number) {
    boolean result;
    try {
      Double.parseDouble(number);
      result = true;
    } catch (NumberFormatException excepcion) {
      result = false;
    }
    return result;
  }
}
