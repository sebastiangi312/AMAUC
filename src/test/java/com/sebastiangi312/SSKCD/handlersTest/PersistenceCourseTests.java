package com.sebastiangi312.SSKCD.handlersTest;

import com.sebastiangi312.SSKCD.application.handler.PersistenceCourseHandler;
import com.sebastiangi312.SSKCD.persistence.entity.CourseEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersistenceCourseTests {
  
  @Autowired
  public PersistenceCourseHandler persistenceCourseHandler;
  
  @Test
  public void should_save_courses(){
    persistenceCourseHandler.saveCourses("3007848","BASE DE DATOS II","3");
    CourseEntity course = (CourseEntity) persistenceCourseHandler.getCourses().get(0);
    Assert.assertEquals("3007848",course.getCode());
  }
}
