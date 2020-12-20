package com.sebastiangi312.SSKCD.repository;

import com.sebastiangi312.SSKCD.domain.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

  Course findByCode(String code);
  
  void deleteByCode(String code);
}
