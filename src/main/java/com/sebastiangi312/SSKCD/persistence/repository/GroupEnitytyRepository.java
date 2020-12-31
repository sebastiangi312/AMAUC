package com.sebastiangi312.SSKCD.persistence.repository;

import com.sebastiangi312.SSKCD.persistence.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupEnitytyRepository extends CrudRepository<GroupEntity, Long> {
  
  GroupEntity findByName(String name);
  
  void deleteByName(String name);
}
