package com.sebastiangi312.SSKCD.information.application.fabric;

import com.sebastiangi312.SSKCD.information.application.pdu.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupFabric {
  
  public Group createGroup(String name, String component, String degree, int minUnits){
    return new Group(name,component,degree,minUnits);
  }
}
