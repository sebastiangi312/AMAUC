package com.sebastiangi312.SSKCD.persistence.repository;

import com.sebastiangi312.SSKCD.persistence.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistence.entity.GradeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeEntityRepository extends CrudRepository<GradeEntity, Long> {
  
  public void deleteByCourse(CourseEntity courseEntity);
}
