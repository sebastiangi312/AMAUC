package com.sebastiangi312.SSKCD.persistance.repository;

import com.sebastiangi312.SSKCD.persistance.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEntityRepository extends CrudRepository<CourseEntity, Long> {

  CourseEntity findByCode(String code);
}
