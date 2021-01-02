package com.sebastiangi312.SSKCD.information.application.handler;

import com.sebastiangi312.SSKCD.information.application.pdu.Grade;
import com.sebastiangi312.SSKCD.information.domain.adapter.GradedCourseAdapter;
import com.sebastiangi312.SSKCD.information.domain.service.CourseService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GradeHandler {
  
  private final CourseService service;
  private final GradedCourseAdapter adapter;
  
  public GradeHandler(CourseService service, GradedCourseAdapter adapter) {
    this.service = service;
    this.adapter = adapter;
  }
  
  public Double getGradePoint(List<Grade> courses) {
    return service.getGradePoint(courses.stream()
      .map(i -> adapter.ObjectToGradedCourse(i.getCourse(), i)).collect(Collectors.toList()));
  }
  
}
