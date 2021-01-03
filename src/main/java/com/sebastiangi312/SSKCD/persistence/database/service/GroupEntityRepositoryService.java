package com.sebastiangi312.SSKCD.persistence.database.service;

import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import com.sebastiangi312.SSKCD.persistence.database.repository.GroupEnitytyRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class GroupEntityRepositoryService {
  
  private final GroupEnitytyRepository repository;
  
  public GroupEntityRepositoryService(GroupEnitytyRepository repository) {
    this.repository = repository;
  }
  
  public void addGroup(GroupEntity group) {
    GroupEntity groupObtained = repository.findByNameAndComponent(group.getName(), group.getComponent());
    if(groupObtained == null)
      repository.save(group);
    else if(!groupObtained.equals(group))
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
