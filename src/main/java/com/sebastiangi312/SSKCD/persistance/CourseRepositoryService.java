package com.sebastiangi312.SSKCD.persistance;

import com.sebastiangi312.SSKCD.persistance.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistance.repository.CourseEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class CourseRepositoryService {
  
  private final CourseEntityRepository repository;
  
  public CourseRepositoryService(CourseEntityRepository repository) {
    this.repository = repository;
  }
  
  public void addCourse(CourseEntity course){
    repository.save(course);
  }
  
  public CourseEntity getCourse(String code){
    return repository.findByCode(code);
  }
}
