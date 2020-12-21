package com.sebastiangi312.SSKCD.handlersTest;

import com.sebastiangi312.SSKCD.application.handler.PersistanceCourseHandler;
import com.sebastiangi312.SSKCD.persistance.CourseRepositoryService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersistanceCourseTests {
  
  @Autowired
  public PersistanceCourseHandler persistanceCourseHandler;
  
  @Autowired
  public CourseRepositoryService courseRepositoryService;
  
  
  @Test
  public void should_save_courses(){
    persistanceCourseHandler.saveCourses("3007848","BASE DE DATOS II","3");
    
    Assert.assertEquals("3007848", courseRepositoryService.getCourse("3007848").getCode());
  }
}
