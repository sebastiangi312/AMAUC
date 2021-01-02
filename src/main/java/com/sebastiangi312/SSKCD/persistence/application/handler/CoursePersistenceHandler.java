package com.sebastiangi312.SSKCD.persistence.application.handler;

import com.sebastiangi312.SSKCD.persistence.application.pdu.CourseData;
import com.sebastiangi312.SSKCD.persistence.database.adapter.CourseEntityAdapter;
import com.sebastiangi312.SSKCD.persistence.database.service.CourseRepositoryService;
import com.sebastiangi312.SSKCD.persistence.database.service.GroupRepositoryService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CoursePersistenceHandler {
  
  private final CourseEntityAdapter courseEntityAdapter;
  private final CourseRepositoryService courseRepositoryService;
  private final GroupRepositoryService groupRepositoryService;
  
  public CoursePersistenceHandler(  CourseEntityAdapter courseEntityAdapter,
                                    CourseRepositoryService courseRepositoryService,
                                    GroupRepositoryService groupRepositoryService) {
    this.courseEntityAdapter = courseEntityAdapter;
    this.courseRepositoryService = courseRepositoryService;
    this.groupRepositoryService = groupRepositoryService;
  }
  
  public void saveCourses(CourseData courseData, String groupName, String componentName) {
    if(groupRepositoryService.get(groupName,componentName) != null)
      courseRepositoryService.addCourse(courseEntityAdapter.adaptCourseDataToCourseEntity(courseData,
          groupRepositoryService.get(groupName,componentName)));
    else
        courseRepositoryService.addCourse(courseEntityAdapter.adaptCourseDataToCourseEntity(courseData,
          groupRepositoryService.get("Libre Elección","Libre Elección")));
  }
  
  public List<Object> getCourses(){
    return Arrays.asList(courseRepositoryService.getAll().toArray());
  }
  
  public Object getCourse(String code){ return courseRepositoryService.getCourse(code); }
  
  public void deleteAll(){ courseRepositoryService.deleteAll(); }
  
  public void delete(String code){ courseRepositoryService.delete(code);}
}
