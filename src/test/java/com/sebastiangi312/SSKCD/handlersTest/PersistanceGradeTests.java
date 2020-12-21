package com.sebastiangi312.SSKCD.handlersTest;

import com.sebastiangi312.SSKCD.application.handler.PersistanceCourseHandler;
import com.sebastiangi312.SSKCD.application.handler.PersistanceGradeHandler;
import com.sebastiangi312.SSKCD.persistance.entity.GradeEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersistanceGradeTests {
  
  @Autowired
  public PersistanceGradeHandler persistanceGradeHandler;
  
  @Autowired
  public PersistanceCourseHandler persistanceCourseHandler;
  
  @Test
  public void should_save_grades(){
    persistanceCourseHandler.saveCourses("3007848","BASE DE DATOS II","3");
    persistanceGradeHandler.saveGrade("3007848", "APROBADA\r", "4.0", "20-19");
    GradeEntity grade = (GradeEntity) persistanceGradeHandler.getGradedCourses();
    Assert.assertEquals(4.0,grade.getGrade(),0.1);
    Assert.assertEquals(3,grade.getCourse().getUnits());
  }
}
