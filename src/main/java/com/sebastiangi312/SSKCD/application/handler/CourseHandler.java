package com.sebastiangi312.SSKCD.application.handler;

import com.sebastiangi312.SSKCD.domain.model.GradedCourse;
import com.sebastiangi312.SSKCD.domain.service.CourseService;

import java.util.stream.Collectors;

public class CourseHandler {
  
  private final PersistenceGradeHandler persistenceGradeHandler;
  private final CourseService service;
  
  public CourseHandler(PersistenceGradeHandler courseGradeHandler, CourseService service) {
    this.persistenceGradeHandler = courseGradeHandler;
    this.service = service;
  }
  
  public Double getPAPA(){
    return service.getGradePoint(persistenceGradeHandler.getGradedCourses().stream()
                  .map(i -> (GradedCourse)i).collect(Collectors.toList()));
  }
  
  public Double getPA(){
    return service.getGradePoint(persistenceGradeHandler.getApprovedCourses().stream()
                  .map(i -> (GradedCourse)i).collect(Collectors.toList()));
  }
}
