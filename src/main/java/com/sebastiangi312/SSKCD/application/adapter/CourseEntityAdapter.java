package com.sebastiangi312.SSKCD.application.adapter;

import com.sebastiangi312.SSKCD.application.fabric.CourseEntityFabric;
import com.sebastiangi312.SSKCD.persistance.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityAdapter {
  
  private final CourseEntityFabric entityFabric;
  
  public CourseEntityAdapter(CourseEntityFabric entityFabric) {
    this.entityFabric = entityFabric;
  }
  
  public CourseEntity adaptStringToCourseEntity(String idAndName, String units){
    String id = separateIdAndName(idAndName)[0];
    String name = separateIdAndName(idAndName)[1];
    return entityFabric.createCourseEntity(id, name, Integer.parseInt(units));
  }
  
  private String[] separateIdAndName(String idAndName) {
    String name = idAndName.split("\\s\\(\\d+\\)")[0];
    StringBuilder id = new StringBuilder();
    boolean aux = false;
    for (int i = idAndName.length() - 1; i >= 0; i--) {
      if (idAndName.charAt(i) == '(')
        break;
      if (aux)
        id.insert(0, idAndName.charAt(i));
      if (idAndName.charAt(i) == ')')
        aux = true;
    }
    return new String[]{id.toString(), name};
  }
  
}
