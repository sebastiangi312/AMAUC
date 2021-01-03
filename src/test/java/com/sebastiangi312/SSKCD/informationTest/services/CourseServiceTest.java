package com.sebastiangi312.SSKCD.informationTest.services;

import com.sebastiangi312.SSKCD.information.domain.fabric.GradedCourseFabric;
import com.sebastiangi312.SSKCD.information.domain.model.GradedCourse;
import com.sebastiangi312.SSKCD.information.domain.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class CourseServiceTest {
  
  @Autowired
  private CourseService courseService;
  @Autowired
  private GradedCourseFabric fabric;
  
  
  @Test
  public void getCorrectGradePoint(){
    List<GradedCourse> gradedCourseList = new LinkedList<>();
    gradedCourseList.add(
      fabric.createGradedCourse("3","a",3,true,4,"5 de junio"));
    gradedCourseList.add(
      fabric.createGradedCourse("4","b",4,true,5.0,"6 de junio"));
  
    Assertions.assertEquals(4.57,courseService.getGradePoint(gradedCourseList),0.01);
    
  }
  
  @Test
  public void returnCeroCourseListEmpty(){
    List<GradedCourse> gradedCourseList = new LinkedList<>();
    Assertions.assertEquals(0,courseService.getGradePoint(gradedCourseList),0.01);
  }
  
}
