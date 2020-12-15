package com.sebastiangi312.SSKCD.handlerTest;

import com.sebastiangi312.SSKCD.application.handler.CourseHandler;
import com.sebastiangi312.SSKCD.domain.Course;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class CourseHandlerTest {
  
  @Autowired
  private CourseHandler courseHandler;
  
  @Test
  public void parseAndSaveCourses(){
    List<String[]> courses = new LinkedList<>();
    String[] first = {"BASE DE DATOS II (3007848) ", "3", "DISCIPLINAR OPTATIVA",
      "2019-2S Ordinaria", "4.3", "APROBADA"};
    courses.add(first);
    String[] second = {"ESTADÍSTICA II (3006915) ", "4", "FUND. OPTATIVA",
      "2019-2S Ordinaria", "3.5", "APROBADA"};
    courses.add(second);
    
    courseHandler.saveCourses(courses);
    
    List<Course> expected = new LinkedList<>();
    
    expected.add(new Course("3007848","BASE DE DATOS II",3,4.3, Course.typeCourse.gradable));
    expected.add(new Course("3006915","ESTADÍSTICA II",4,3.5, Course.typeCourse.gradable));
    
    List<Course> obtained = courseHandler.getAll();
    Collections.sort(expected);
    Collections.sort(obtained);
    for(int i = 0; i < obtained.size();i++){
      Assert.assertEquals(expected.get(i),obtained.get(i));
    }
    
    Assert.assertEquals(expected.size(), obtained.size());
  }
  
  @Test
  public void isGettingCorrectGradeAverage(){
  
    List<Course> courses = new LinkedList<>();
  
    courses.add(new Course("3007848","BASE DE DATOS II",3,4.3, Course.typeCourse.gradable));
    courses.add(new Course("3006915","ESTADÍSTICA II",4,3.5, Course.typeCourse.gradable));
    
    Assert.assertEquals(3.842,courseHandler.getGradeAverage(courses),0.01);
    
    courses.clear();
  
    Assert.assertEquals(0,courseHandler.getGradeAverage(courses),0.01);
  }
}
