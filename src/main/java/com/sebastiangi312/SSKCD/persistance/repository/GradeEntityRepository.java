package com.sebastiangi312.SSKCD.persistance.repository;

import com.sebastiangi312.SSKCD.persistance.entity.GradeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeEntityRepository extends CrudRepository<GradeEntity, Long> {
}
