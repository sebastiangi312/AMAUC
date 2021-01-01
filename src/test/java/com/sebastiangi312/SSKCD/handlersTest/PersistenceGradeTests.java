package com.sebastiangi312.SSKCD.handlersTest;

import com.sebastiangi312.SSKCD.infraestructure.persistenceHandler.CoursePersistenceHandler;
import com.sebastiangi312.SSKCD.infraestructure.persistenceHandler.GradePersistenceHandler;
import com.sebastiangi312.SSKCD.persistence.entity.GradeEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersistenceGradeTests {
  
  @Autowired
  public GradePersistenceHandler gradePersistenceHandler;
  
  @Autowired
  public CoursePersistenceHandler coursePersistenceHandler;
  
  @Test
  public void should_save_grades(){
    coursePersistenceHandler.saveCourses("3007848","BASE DE DATOS II","3");
    gradePersistenceHandler.saveGrade("3007848", "APROBADA\r", "4.0", "20-19");
    GradeEntity grade = (GradeEntity) gradePersistenceHandler.getAllGrades().get(0);
    Assertions.assertEquals(4.0,grade.getGrade(),0.1);
    Assertions.assertEquals(3,grade.getCourse().getUnits());
  }
}
