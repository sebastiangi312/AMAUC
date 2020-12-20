package com.sebastiangi312.SSKCD.handlersTest;

import com.sebastiangi312.SSKCD.application.handler.PersistanceCourseHandler;
import com.sebastiangi312.SSKCD.persistance.CourseRepositoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class PersistanceCourseHandlerTest {
  
  @Autowired
  private PersistanceCourseHandler persistanceCourseHandler;
  
  @Autowired
  private CourseRepositoryService courseRepositoryService;
  
  
  @Test
  public void should_save_courses(){
    persistanceCourseHandler.saveCourses("BASE DE DATOS II (3007848)","3");
  
    Assert.assertEquals("3007848", courseRepositoryService.getCourse("3007848").getCode());
  }
}
