package com.sebastiangi312.SSKCD.persistence.database.adapter;

import com.sebastiangi312.SSKCD.persistence.application.pdu.GroupData;
import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import com.sebastiangi312.SSKCD.persistence.database.fabric.GroupEntityFabric;
import org.springframework.stereotype.Component;

@Component
public class GroupEntityAdapter {
  
  private final GroupEntityFabric fabric;
  
  public GroupEntityAdapter(GroupEntityFabric fabric) {
    this.fabric = fabric;
  }
  
  public GroupEntity adaptGroupDataToGroupEntity(GroupData groupData){
    return fabric.createGroupEntity(groupData.getName(), groupData.getComponent(),
                                    groupData.getDegree(), groupData.getMinUnits());
  }
}
