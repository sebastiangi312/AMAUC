package com.sebastiangi312.SSKCD.information.application.adapter;

import com.sebastiangi312.SSKCD.information.application.fabric.GroupFabric;
import com.sebastiangi312.SSKCD.information.application.pdu.Group;
import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupAdapter {
  
  public GroupAdapter(GroupFabric fabric) {
    this.fabric = fabric;
  }
  
  private final GroupFabric fabric;
  
  public Group GroupEntityToGroup(GroupEntity groupEntity){
    return fabric.createGroup(groupEntity.getName(), groupEntity.getComponent(),
                              groupEntity.getDegree(), groupEntity.getMinUnits());
  }
}
