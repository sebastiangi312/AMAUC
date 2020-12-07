package com.sebastiangi312.SSKCD.domain.services;

import com.sebastiangi312.SSKCD.domain.Course;
import com.sebastiangi312.SSKCD.domain.repository.CourseRepository;

import java.util.List;

public class CourseService {
  
  private final CourseRepository repository;
  
  public CourseService(CourseRepository repository) {
    this.repository = repository;
  }
  
  public Course getCourseById(int id){
    return repository.getById(id);
  }
  
  public void addCourse(Course course){
    repository.add(course);
  }
  
  public List<Course> getAll(){
    return repository.getAll();
  }
}
