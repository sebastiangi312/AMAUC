package com.sebastiangi312.SSKCD.handlersTest;

import com.sebastiangi312.SSKCD.infraestructure.persistenceHandler.CoursePersistenceHandler;
import com.sebastiangi312.SSKCD.persistence.entity.CourseEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersistenceCourseWithoutGradeTests {
  
  @Autowired
  public CoursePersistenceHandler coursePersistenceHandler;
  
  @Test
  public void should_save_courses(){
    coursePersistenceHandler.saveCourses("3007848","BASE DE DATOS II","3");
    CourseEntity course = (CourseEntity) coursePersistenceHandler.getCourses().get(0);
    Assert.assertEquals("3007848",course.getCode());
  }
}
