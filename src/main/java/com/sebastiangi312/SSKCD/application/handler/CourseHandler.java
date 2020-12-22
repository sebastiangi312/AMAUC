package com.sebastiangi312.SSKCD.application.handler;

import com.sebastiangi312.SSKCD.domain.adapter.GradeAdapter;
import com.sebastiangi312.SSKCD.domain.service.CourseService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CourseHandler {
  
  private final PersistenceGradeHandler persistenceGradeHandler;
  private final CourseService service;
  private final GradeAdapter adapter;
  
  public CourseHandler(PersistenceGradeHandler courseGradeHandler,
                       CourseService service, GradeAdapter adapter) {
    this.persistenceGradeHandler = courseGradeHandler;
    this.service = service;
    this.adapter = adapter;
  }
  
  public Double getPAPA(){
    return service.getGradePoint(persistenceGradeHandler.getGradedCourses().stream()
                  .map(adapter::ObjectToGradedCourse).collect(Collectors.toList()));
  }
  
  public Double getPA(){
    return service.getGradePoint(persistenceGradeHandler.getApprovedCourses().stream()
                  .map(adapter::ObjectToGradedCourse).collect(Collectors.toList()));
  }
}
