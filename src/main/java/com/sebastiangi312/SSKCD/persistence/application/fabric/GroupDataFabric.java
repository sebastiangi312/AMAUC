package com.sebastiangi312.SSKCD.persistence.application.fabric;

import com.sebastiangi312.SSKCD.persistence.application.pdu.GroupData;
import org.springframework.stereotype.Component;

@Component
public class GroupDataFabric {
  
  public GroupData createGroup(String name, String component, String degree, int minUnits){
    return new GroupData(name, component, degree, minUnits);
  }
}
