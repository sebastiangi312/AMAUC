package com.sebastiangi312.SSKCD.application.handler;

import com.sebastiangi312.SSKCD.application.adapter.CourseEntityAdapter;
import com.sebastiangi312.SSKCD.persistance.CourseRepositoryService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PersistanceCourseHandler {
  
  private final CourseEntityAdapter courseEntityAdapter;
  private final CourseRepositoryService courseRepositoryService;
  
  public PersistanceCourseHandler(CourseEntityAdapter courseEntityAdapter,
                                  CourseRepositoryService courseRepositoryService) {
    this.courseEntityAdapter = courseEntityAdapter;
    this.courseRepositoryService = courseRepositoryService;
  }
  
  public void saveCourses(String code, String name, String units) {
    courseRepositoryService.addCourse(courseEntityAdapter.adaptStringToCourseEntity(code, name, units));
  }
  
  public List<Object> getCourses(){
    return Arrays.asList(courseRepositoryService.getAll().toArray());
  }
}
