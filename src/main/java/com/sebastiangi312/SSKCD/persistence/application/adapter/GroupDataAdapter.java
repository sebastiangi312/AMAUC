package com.sebastiangi312.SSKCD.persistence.application.adapter;

import com.sebastiangi312.SSKCD.persistence.application.fabric.GroupDataFabric;
import com.sebastiangi312.SSKCD.persistence.application.pdu.GroupData;
import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupDataAdapter {
  
  public GroupDataAdapter(GroupDataFabric fabric) {
    this.fabric = fabric;
  }
  
  private final GroupDataFabric fabric;
  
  public GroupData groupEntityToGroupData(GroupEntity groupEntity){
    return fabric.createGroup(groupEntity.getName(), groupEntity.getComponent(),
                              groupEntity.getDegree(), groupEntity.getMinUnits());
  }
  
  public GroupData stringToGroupData(String name, String component,
                                     String degree, String minUnits){
    return fabric.createGroup(name,component,degree,Integer.parseInt(minUnits));
  }
}
