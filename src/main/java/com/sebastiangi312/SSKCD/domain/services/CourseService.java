package com.sebastiangi312.SSKCD.domain.services;

import com.sebastiangi312.SSKCD.domain.Course;
import com.sebastiangi312.SSKCD.domain.repository.CourseRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CourseService {
  
  private final CourseRepository repository;
  
  public CourseService(CourseRepository repository) {
    this.repository = repository;
  }
  
  public void addCourse(Course course) {
    repository.save(course);
  }
  
  public Course getCourseByCode(String code) {
    return repository.findByCode(code);
  }
  
  public List<Course> getAll() {
    return StreamSupport.stream(repository.findAll().spliterator(), false)
      .collect(Collectors.toList());
  }
}
