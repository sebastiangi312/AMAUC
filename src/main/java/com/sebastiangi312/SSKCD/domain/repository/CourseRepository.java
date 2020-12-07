package com.sebastiangi312.SSKCD.domain.repository;

import com.sebastiangi312.SSKCD.domain.Course;

import java.util.List;

public interface CourseRepository {
  
  Course getById(int id);
  
  void add(Course course);
  
  List<Course> getAll();
}
