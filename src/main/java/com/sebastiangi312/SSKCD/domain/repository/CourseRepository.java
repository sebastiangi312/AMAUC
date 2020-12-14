package com.sebastiangi312.SSKCD.domain.repository;

import com.sebastiangi312.SSKCD.domain.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

  Course findByCode(String code);
}
