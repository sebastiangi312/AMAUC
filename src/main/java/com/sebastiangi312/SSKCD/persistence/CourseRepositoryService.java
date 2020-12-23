package com.sebastiangi312.SSKCD.persistence;

import com.sebastiangi312.SSKCD.persistence.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistence.repository.CourseEntityRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CourseRepositoryService {
  
  private final CourseEntityRepository repository;
  
  public CourseRepositoryService(CourseEntityRepository repository) {
    this.repository = repository;
  }
  
  public void addCourse(CourseEntity course){
    if(getCourse(course.getCode()) == null){
      repository.save(course);
    }
  }
  
  public CourseEntity getCourse(String code){
    return repository.findByCode(code);
  }
  
  public List<CourseEntity> getAll(){
    return StreamSupport.stream(repository.findAll().spliterator(), false).
                                           collect(Collectors.toList());
  }
  
  public void deleteAll(){ repository.deleteAll(); }
  
  public void delete(String code){ repository.deleteByCode(code); }
}