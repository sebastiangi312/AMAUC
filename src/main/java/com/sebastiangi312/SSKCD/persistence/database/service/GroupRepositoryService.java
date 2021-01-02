package com.sebastiangi312.SSKCD.persistence.database.service;

import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import com.sebastiangi312.SSKCD.persistence.database.repository.GroupEnitytyRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class GroupRepositoryService {
  
  private final GroupEnitytyRepository repository;
  
  public GroupRepositoryService(GroupEnitytyRepository repository) {
    this.repository = repository;
  }
  
  public void addGroup(GroupEntity group) {
    GroupEntity groupGet = repository.findByNameAndComponent(group.getName(), group.getComponent());
    if(groupGet == null)
      repository.save(group);
    else if(!groupGet.equals(group))
      repository.save(group);
  }
  
  public List<GroupEntity> getAll(){
    return StreamSupport.stream(repository.findAll().spliterator(), false)
                                          .collect(Collectors.toList());
  }
  
  public void deleteAll(){
    repository.deleteAll();
  }
  
  public void delete(String name){ repository.deleteByName(name);}
  
  public GroupEntity get(String name, String component) {
    return repository.findByNameAndComponent(name, component);
  }
}
