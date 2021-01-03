package com.sebastiangi312.SSKCD.persistence.service;

import com.sebastiangi312.SSKCD.persistence.database.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import com.sebastiangi312.SSKCD.persistence.database.fabric.CourseEntityFabric;
import com.sebastiangi312.SSKCD.persistence.database.fabric.GroupEntityFabric;
import com.sebastiangi312.SSKCD.persistence.database.service.CourseEntityRepositoryService;
import com.sebastiangi312.SSKCD.persistence.database.service.GroupEntityRepositoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseEntityRepositoryServiceTest {
  
  @Autowired
  private CourseEntityRepositoryService courseEntityRepositoryService;
  
  @Autowired
  private CourseEntityFabric courseEntityFabric;
  
  @Autowired
  private GroupEntityFabric groupEntityFabric;
  
  @Autowired
  private GroupEntityRepositoryService repositoryService;
  
  
  @Test
  public void dontAddDuplicates(){
    GroupEntity groupEntity = groupEntityFabric.createGroupEntity("A","AComponent","IS",3);
    repositoryService.addGroup(groupEntity);
    CourseEntity courseEntity = courseEntityFabric.createCourseEntity("1","a",3,groupEntity);
    courseEntityRepositoryService.addCourse(courseEntity);
    courseEntityRepositoryService.addCourse(courseEntity);
    Assertions.assertEquals(1, courseEntityRepositoryService.getAll().size());
    courseEntityRepositoryService.deleteAll();
  }
}
