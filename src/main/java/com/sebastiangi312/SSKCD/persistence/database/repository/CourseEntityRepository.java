package com.sebastiangi312.SSKCD.persistence.database.repository;

import com.sebastiangi312.SSKCD.persistence.database.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEntityRepository extends CrudRepository<CourseEntity, Long> {

  CourseEntity findByCode(String code);
  
  void deleteByCode(String code);
}
