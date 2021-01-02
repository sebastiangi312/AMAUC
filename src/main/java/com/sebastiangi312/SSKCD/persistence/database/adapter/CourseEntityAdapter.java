package com.sebastiangi312.SSKCD.persistence.database.adapter;

import com.sebastiangi312.SSKCD.persistence.application.adapter.GroupDataAdapter;
import com.sebastiangi312.SSKCD.persistence.application.pdu.CourseData;
import com.sebastiangi312.SSKCD.persistence.application.pdu.GroupData;
import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import com.sebastiangi312.SSKCD.persistence.database.fabric.CourseEntityFabric;
import com.sebastiangi312.SSKCD.persistence.database.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEntityAdapter {
  
  private final CourseEntityFabric entityFabric;
  private final GroupEntityAdapter groupEntityAdapter;
  
  public CourseEntityAdapter(CourseEntityFabric entityFabric,
                             GroupEntityAdapter groupEntityAdapter) {
    this.entityFabric = entityFabric;
    this.groupEntityAdapter = groupEntityAdapter;
  }
  
  public CourseEntity adaptStringToCourseEntity(String code, String name,
                                                String units, GroupData group){
    return entityFabric.createCourseEntity(code, name, Integer.parseInt(units),
                                           groupEntityAdapter.adaptGroupDataToGroupEntity(group));
  }
  
  public CourseEntity adaptCourseDataToCourseEntity(CourseData courseData, GroupEntity groupEntity){
    return entityFabric.createCourseEntity(courseData.getCode(), courseData.getName(),
                                           courseData.getUnits(),groupEntity);
  }
}
