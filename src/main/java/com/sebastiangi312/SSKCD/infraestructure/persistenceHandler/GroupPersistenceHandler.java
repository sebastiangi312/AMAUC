package com.sebastiangi312.SSKCD.infraestructure.persistenceHandler;

import com.sebastiangi312.SSKCD.persistence.adapter.GroupEntityAdapter;
import com.sebastiangi312.SSKCD.persistence.service.GroupRepositoryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupPersistenceHandler {
  
  private final GroupRepositoryService service;
  private final GroupEntityAdapter adapter;
  
  public GroupPersistenceHandler(GroupRepositoryService service,
                                 GroupEntityAdapter adapter) {
    this.service = service;
    this.adapter = adapter;
  }
  
  public void createGroup(String name, String component, String minUnits, String degree) {
    service.addGroup(adapter.adaptStringToGroupEntity(name,component,degree,Integer.parseInt(minUnits)));
  }
  
  public List<Object> getGroups(){
    return service.getAll().stream().map(i -> (Object)i).collect(Collectors.toList());
  }
  
  public void deleteGroup(String name){ service.delete(name);}
  
  public void deleteAll(){ service.deleteAll();}
  
  public void deleteByName(String name) {
    service.delete(name);
  }
}
