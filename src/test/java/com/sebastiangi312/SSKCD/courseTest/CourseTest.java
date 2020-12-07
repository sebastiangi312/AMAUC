package com.sebastiangi312.SSKCD.courseTest;

import com.sebastiangi312.SSKCD.domain.Course;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class CourseTest {
  
  @Autowired
  private EntityManager entityManager;
  
  @Test
  public void verifyCourseCanBeSaved(){
    final Course course = new Course();
    course.setId(3007848);
    course.setName("BASE DE DATOS II");
    course.setUnits(4);
    course.setGrade(3.8);
    
    entityManager.persist(course);
    
    final TypedQuery<Course> query = entityManager.createQuery("SELECT c from  Course c", Course.class);
    
    final Course resultCourse = query.getResultList().get(0);
  
    Assert.assertEquals("BASE DE DATOS II",resultCourse.getName());
  }
  
}
