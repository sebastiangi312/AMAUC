package com.sebastiangi312.SSKCD.handlersTest;

import com.sebastiangi312.SSKCD.application.handler.PersistenceCourseHandler;
import com.sebastiangi312.SSKCD.application.handler.PersistenceGradeHandler;
import com.sebastiangi312.SSKCD.persistence.entity.GradeEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersistenceGradeTests {
  
  @Autowired
  public PersistenceGradeHandler persistenceGradeHandler;
  
  @Autowired
  public PersistenceCourseHandler persistenceCourseHandler;
  
  @Test
  public void should_save_grades(){
    persistenceCourseHandler.saveCourses("3007848","BASE DE DATOS II","3");
    persistenceGradeHandler.saveGrade("3007848", "APROBADA\r", "4.0", "20-19");
    GradeEntity grade = (GradeEntity) persistenceGradeHandler.getGradedCourses().get(0);
    Assert.assertEquals(4.0,grade.getGrade(),0.1);
    Assert.assertEquals(3,grade.getCourse().getUnits());
  }
}
