package com.sebastiangi312.SSKCD.application.handler;

import com.sebastiangi312.SSKCD.application.adapter.CourseEntityAdapter;
import com.sebastiangi312.SSKCD.persistance.CourseRepositoryService;
import com.sebastiangi312.SSKCD.persistance.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class PersistanceCourseHandler {
  
  private final CourseEntityAdapter courseEntityAdapter;
  private final CourseRepositoryService courseRepositoryService;
  
  public PersistanceCourseHandler(CourseEntityAdapter courseEntityAdapter,
                                  CourseRepositoryService courseRepositoryService) {
    this.courseEntityAdapter = courseEntityAdapter;
    this.courseRepositoryService = courseRepositoryService;
  }
  
  public void saveCourses(String idAndName, String units) {
    CourseEntity course = courseEntityAdapter.adaptStringToCourseEntity(idAndName, units);
    courseRepositoryService.addCourse(course);
  }
  
  
}
