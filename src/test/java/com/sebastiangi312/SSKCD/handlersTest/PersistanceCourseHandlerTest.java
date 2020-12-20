package com.sebastiangi312.SSKCD.handlersTest;

import com.sebastiangi312.SSKCD.application.handler.PersistanceCourseHandler;
import org.junit.Test;


public class PersistanceCourseHandlerTest {
  
  private final PersistanceCourseHandler courseHandler;
  
  public PersistanceCourseHandlerTest(PersistanceCourseHandler courseHandler) {
    this.courseHandler = courseHandler;
  }
  
  @Test
  public void should_save_courses(){
    courseHandler.saveCourses("BASE DE DATOS II (3007848)","3");
    
  }
}
