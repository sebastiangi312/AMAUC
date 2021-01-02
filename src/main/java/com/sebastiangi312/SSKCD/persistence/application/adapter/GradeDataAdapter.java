package com.sebastiangi312.SSKCD.persistence.application.adapter;

import com.sebastiangi312.SSKCD.persistence.application.fabric.GradeDataFabric;
import com.sebastiangi312.SSKCD.persistence.application.pdu.GradeData;
import com.sebastiangi312.SSKCD.persistence.database.entity.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class GradeDataAdapter {
  
  private final GradeDataFabric fabric;
  
  public GradeDataAdapter(GradeDataFabric fabric) {
    this.fabric = fabric;
  }
  
  
  public GradeData GradeEntityToGradeData(Object gradeEntity){
    GradeEntity grade = (GradeEntity) gradeEntity;
    return  fabric.createGrade(grade.isApproved(),grade.getGrade(), grade.getDate());
  }
  
  public GradeData StringToGradeData(String approved, String graded, String date){
    boolean isApproved = approved.equals("APROBADA\r");
    Double grade;
    if(isNumeric(graded))
      grade = Double.parseDouble(graded);
    else
      grade = null;
    return fabric.createGrade(isApproved,grade,date);
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


