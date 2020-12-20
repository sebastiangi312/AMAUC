package com.sebastiangi312.SSKCD.domainTest;

import com.sebastiangi312.SSKCD.domain.Course;
import com.sebastiangi312.SSKCD.repository.CourseRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootTest
@Transactional
class CourseTest {
  
  @Autowired
  private EntityManager entityManager;
  
  @Autowired
  private CourseRepository courseRepository;
  
  @Test
  public void verifyCourseCanBeSaved() {
    final Course course = new Course();
    course.setCode("3007848");
    course.setName("BASE DE DATOS II");
    course.setUnits(4);
    course.setGrade(3.8);
    
    entityManager.persist(course);
    
    final TypedQuery<Course> query = entityManager.createQuery("SELECT c from  Course c", Course.class);
    
    final Course resultCourse = query.getResultList().get(0);
    
    Assert.assertEquals("BASE DE DATOS II", resultCourse.getName());
    entityManager.clear();
  }
  
  @Test
  public void shouldPerformCRUDOperations() {
    final Course course = new Course();
    course.setCode("3007848");
    course.setName("BASE DE DATOS II");
    course.setUnits(4);
    course.setGrade(4.2);
    
    courseRepository.save(course);
    List<Course> obtained = StreamSupport.stream(courseRepository.findAll().spliterator(), false)
      .collect(Collectors.toList());
    courseRepository.deleteByCode("3007848");
  
    Assert.assertEquals(0,courseRepository.count());
    Assert.assertEquals(course.toString(), obtained.get(0).toString());
    
    courseRepository.deleteAll();
  }
  
}
