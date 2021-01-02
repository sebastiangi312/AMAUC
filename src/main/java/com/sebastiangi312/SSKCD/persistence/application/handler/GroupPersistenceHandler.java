package com.sebastiangi312.SSKCD.persistence.application.handler;

import com.sebastiangi312.SSKCD.persistence.application.adapter.GroupDataAdapter;
import com.sebastiangi312.SSKCD.persistence.application.pdu.GroupData;
import com.sebastiangi312.SSKCD.persistence.database.adapter.GroupEntityAdapter;
import com.sebastiangi312.SSKCD.persistence.database.service.GroupRepositoryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupPersistenceHandler {
  
  private final GroupRepositoryService service;
  private final GroupEntityAdapter groupEntityAdapter;
  private final GroupDataAdapter groupDataAdapter;
  
  public GroupPersistenceHandler(GroupRepositoryService service,
                                 GroupEntityAdapter groupEntityAdapter,
                                 GroupDataAdapter groupDataAdapter) {
    this.service = service;
    this.groupEntityAdapter = groupEntityAdapter;
    this.groupDataAdapter = groupDataAdapter;
  }
  
  public void createGroup(GroupData groupData) {
    service.addGroup(groupEntityAdapter.adaptGroupDataToGroupEntity(groupData));
  }
  
  public List<Object> getGroups(){
    return service.getAll().stream().map(groupDataAdapter::groupEntityToGroupData)
                                    .collect(Collectors.toList());
  }
  
  public Object getGroup(String groupName, String componentName){
    return groupDataAdapter.groupEntityToGroupData(service.get(groupName, componentName));
  }
  
  public void deleteAll(){ service.deleteAll();}
  
  public void deleteByName(String name) {
    service.delete(name);
  }
}
