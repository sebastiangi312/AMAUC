package com.sebastiangi312.SSKCD.persistence.application.handler;

import com.sebastiangi312.SSKCD.persistence.application.adapter.GroupDataAdapter;
import com.sebastiangi312.SSKCD.persistence.application.pdu.GroupData;
import com.sebastiangi312.SSKCD.persistence.database.adapter.GroupEntityAdapter;
import com.sebastiangi312.SSKCD.persistence.database.service.GroupEntityRepositoryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupPersistenceHandler {
  
  private final GroupEntityRepositoryService groupEntityRepositoryService;
  private final GroupEntityAdapter groupEntityAdapter;
  private final GroupDataAdapter groupDataAdapter;
  
  public GroupPersistenceHandler(GroupEntityRepositoryService groupEntityRepositoryService,
                                 GroupEntityAdapter groupEntityAdapter,
                                 GroupDataAdapter groupDataAdapter) {
    this.groupEntityRepositoryService = groupEntityRepositoryService;
    this.groupEntityAdapter = groupEntityAdapter;
    this.groupDataAdapter = groupDataAdapter;
  }
  
  public void createGroup(GroupData groupData) {
    groupEntityRepositoryService.addGroup(groupEntityAdapter.adaptGroupDataToGroupEntity(groupData));
  }
  
  public List<Object> getGroups(){
    return groupEntityRepositoryService.getAll().stream().map(groupDataAdapter::groupEntityToGroupData)
                                    .collect(Collectors.toList());
  }
  
  public Object getGroup(String groupName, String componentName){
    return groupDataAdapter.groupEntityToGroupData(groupEntityRepositoryService.get(groupName, componentName));
  }
  
  public void deleteAll(){ groupEntityRepositoryService.deleteAll();}
  
  public void deleteByName(String name) {
    groupEntityRepositoryService.delete(name);
  }
}
