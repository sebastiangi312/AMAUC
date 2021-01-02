package com.sebastiangi312.SSKCD.persistence.database.repository;

import com.sebastiangi312.SSKCD.persistence.database.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistence.database.entity.GradeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeEntityRepository extends CrudRepository<GradeEntity, Long> {
  
  public void deleteByCourse(CourseEntity courseEntity);
}
