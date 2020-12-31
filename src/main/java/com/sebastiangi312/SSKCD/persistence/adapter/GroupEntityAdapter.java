package com.sebastiangi312.SSKCD.persistence.adapter;

import com.sebastiangi312.SSKCD.persistence.entity.GroupEntity;
import com.sebastiangi312.SSKCD.persistence.fabric.GroupEntityFabric;
import org.springframework.stereotype.Component;

@Component
public class GroupEntityAdapter {
  
  private final GroupEntityFabric fabric;
  
  public GroupEntityAdapter(GroupEntityFabric fabric) {
    this.fabric = fabric;
  }
  
  public GroupEntity adaptStringToGroupEntity(String name, String component,
                                              String degree, int minUnits){
    return fabric.createGroupEntity(name, component, degree, minUnits);
  }
}
