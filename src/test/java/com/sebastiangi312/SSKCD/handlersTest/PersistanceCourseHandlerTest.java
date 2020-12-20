package com.sebastiangi312.SSKCD.handlersTest;

import com.sebastiangi312.SSKCD.application.handler.PersistanceCourseHandler;
import com.sebastiangi312.SSKCD.persistance.CourseRepositoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersistanceCourseHandlerTest {
  
  private final PersistanceCourseHandler courseHandler;
  private final CourseRepositoryService courseRepositoryService;
  
  public PersistanceCourseHandlerTest(PersistanceCourseHandler courseHandler,
                                      CourseRepositoryService courseRepositoryService) {
    this.courseHandler = courseHandler;
    this.courseRepositoryService = courseRepositoryService;
  }
  
  @Test
  public void should_save_courses(){
    courseHandler.saveCourses("BASE DE DATOS II (3007848)","3");
  
    Assert.assertEquals("3007848", courseRepositoryService.getCourse("3007848").getCode());
  }
}
