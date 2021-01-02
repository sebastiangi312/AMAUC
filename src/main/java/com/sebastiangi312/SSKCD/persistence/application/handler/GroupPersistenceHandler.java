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
  
  private final GroupRepositoryService groupRepositoryService;
  private final GroupEntityAdapter groupEntityAdapter;
  private final GroupDataAdapter groupDataAdapter;
  
  public GroupPersistenceHandler(GroupRepositoryService groupRepositoryService,
                                 GroupEntityAdapter groupEntityAdapter,
                                 GroupDataAdapter groupDataAdapter) {
    this.groupRepositoryService = groupRepositoryService;
    this.groupEntityAdapter = groupEntityAdapter;
    this.groupDataAdapter = groupDataAdapter;
  }
  
  public void createGroup(GroupData groupData) {
    groupRepositoryService.addGroup(groupEntityAdapter.adaptGroupDataToGroupEntity(groupData));
  }
  
  public List<Object> getGroups(){
    return groupRepositoryService.getAll().stream().map(groupDataAdapter::groupEntityToGroupData)
                                    .collect(Collectors.toList());
  }
  
  public Object getGroup(String groupName, String componentName){
    return groupDataAdapter.groupEntityToGroupData(groupRepositoryService.get(groupName, componentName));
  }
  
  public void deleteAll(){ groupRepositoryService.deleteAll();}
  
  public void deleteByName(String name) {
    groupRepositoryService.delete(name);
  }
}
