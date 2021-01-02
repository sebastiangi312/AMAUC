package com.sebastiangi312.SSKCD.persistence.database.fabric;

import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupEntityFabric {
  
  public GroupEntity createGroupEntity(String name, String component,String degree, int minUnits){
    return new GroupEntity(name, component, degree, minUnits);
  }
}
