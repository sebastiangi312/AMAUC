package com.sebastiangi312.SSKCD.persistence.application.handler;

import com.sebastiangi312.SSKCD.persistence.application.pdu.CourseData;
import com.sebastiangi312.SSKCD.persistence.database.adapter.CourseEntityAdapter;
import com.sebastiangi312.SSKCD.persistence.database.service.CourseEntityRepositoryService;
import com.sebastiangi312.SSKCD.persistence.database.service.GroupEntityRepositoryService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CoursePersistenceHandler {
  
  private final CourseEntityAdapter courseEntityAdapter;
  private final CourseEntityRepositoryService courseEntityRepositoryService;
  private final GroupEntityRepositoryService groupEntityRepositoryService;
  
  public CoursePersistenceHandler(CourseEntityAdapter courseEntityAdapter,
                                  CourseEntityRepositoryService courseEntityRepositoryService,
                                  GroupEntityRepositoryService groupEntityRepositoryService) {
    this.courseEntityAdapter = courseEntityAdapter;
    this.courseEntityRepositoryService = courseEntityRepositoryService;
    this.groupEntityRepositoryService = groupEntityRepositoryService;
  }
  
  public void saveCourses(CourseData courseData, String groupName, String componentName) {
    if(groupEntityRepositoryService.get(groupName,componentName) != null)
      courseEntityRepositoryService.addCourse(courseEntityAdapter.adaptCourseDataToCourseEntity(courseData,
          groupEntityRepositoryService.get(groupName,componentName)));
    else
        courseEntityRepositoryService.addCourse(courseEntityAdapter.adaptCourseDataToCourseEntity(courseData,
          groupEntityRepositoryService.get("Libre Elección","Libre Elección")));
  }
  
  public List<Object> getCourses(){
    return Arrays.asList(courseEntityRepositoryService.getAll().toArray());
  }
  
  public Object getCourse(String code){ return courseEntityRepositoryService.getCourse(code); }
  
  public void deleteAll(){ courseEntityRepositoryService.deleteAll(); }
  
  public void delete(String code){ courseEntityRepositoryService.delete(code); }
  
}
