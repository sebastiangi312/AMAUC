package com.sebastiangi312.SSKCD.persistance;

import com.sebastiangi312.SSKCD.persistance.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistance.repository.CourseEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class CourseDatabase {
  
  private final CourseEntityRepository repository;
  
  public CourseDatabase(CourseEntityRepository repository) {
    this.repository = repository;
  }
  
  public void addCourse(CourseEntity course){
    repository.save(course);
  }
  
  public void getCourse(String code){
  
  }
}
