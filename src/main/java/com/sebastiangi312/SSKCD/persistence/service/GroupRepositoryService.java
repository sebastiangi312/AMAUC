package com.sebastiangi312.SSKCD.persistence.service;

import com.sebastiangi312.SSKCD.persistence.entity.GroupEntity;
import com.sebastiangi312.SSKCD.persistence.repository.GroupEnitytyRepository;
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
    GroupEntity groupGetted = get(group.getName());
    if(groupGetted == null)
      repository.save(group);
    else if(!groupGetted.equals(group))
      repository.save(group);
  }
  
  public List<GroupEntity> getAll(){
    return StreamSupport.stream(repository.findAll().spliterator(), false).
      collect(Collectors.toList());
  }
  
  public void deleteAll(){
    repository.deleteAll();
  }
  
  public void delete(String name){ repository.deleteByName(name);}
  
  public GroupEntity get(String name){ return repository.findByName(name); }
}
