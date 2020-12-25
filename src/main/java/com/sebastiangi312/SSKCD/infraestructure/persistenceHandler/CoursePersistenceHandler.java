package com.sebastiangi312.SSKCD.infraestructure.persistenceHandler;

import com.sebastiangi312.SSKCD.persistence.adapter.CourseEntityAdapter;
import com.sebastiangi312.SSKCD.persistence.service.CourseRepositoryService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CoursePersistenceHandler {
  
  private final CourseEntityAdapter courseEntityAdapter;
  private final CourseRepositoryService courseRepositoryService;
  
  public CoursePersistenceHandler(CourseEntityAdapter courseEntityAdapter,
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
  
  public Object getCourse(String code){ return courseRepositoryService.getCourse(code); }
  
  public void deleteAll(){ courseRepositoryService.deleteAll(); }
  
  public void delete(String code){ courseRepositoryService.delete(code);}
}
