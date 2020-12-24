package com.sebastiangi312.SSKCD.application.handler;

import com.sebastiangi312.SSKCD.application.pdu.Course;
import com.sebastiangi312.SSKCD.domain.adapter.GradeAdapter;
import com.sebastiangi312.SSKCD.domain.service.CourseService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseHandler {
  
  private final CourseService service;
  private final GradeAdapter adapter;
  
  public CourseHandler(CourseService service, GradeAdapter adapter) {
    this.service = service;
    this.adapter = adapter;
  }
  
  public Double getPAPA(List<Course> gradedCourses){
    return service.getGradePoint(gradedCourses.stream()
                  .map(adapter::ObjectToGradedCourse).collect(Collectors.toList()));
  }
  
  public Double getPA(List<Course> ApprovedCourses){
    return service.getGradePoint(ApprovedCourses.stream()
                  .map(adapter::ObjectToGradedCourse).collect(Collectors.toList()));
  }
}
