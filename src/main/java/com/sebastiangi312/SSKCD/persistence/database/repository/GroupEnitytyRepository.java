package com.sebastiangi312.SSKCD.persistence.database.repository;

import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupEnitytyRepository extends CrudRepository<GroupEntity, Long> {
  
  GroupEntity findByNameAndComponent(String name, String component);
  
  void deleteByName(String name);
}
