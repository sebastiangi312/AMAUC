package com.sebastiangi312.SSKCD.persistence.infrastructure.controller;

import com.sebastiangi312.SSKCD.persistence.application.adapter.GroupDataAdapter;
import com.sebastiangi312.SSKCD.persistence.infrastructure.inputs.JSONHandler;
import com.sebastiangi312.SSKCD.persistence.application.handler.GroupPersistenceHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/courseManager/groups")
public class GroupController {
  
  private final GroupPersistenceHandler handler;
  private final GroupDataAdapter adapter;
  
  public GroupController(GroupPersistenceHandler handler, GroupDataAdapter adapter) {
    this.handler = handler;
    this.adapter = adapter;
  }
  
  @Transactional
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public void uploadGroups(@RequestBody final String degreeSelected) {
    JSONObject degree = JSONHandler.readJSON(degreeSelected);
    Object degreeInfo = JSONHandler.getProperty(degree,"degree");
    String degreeName = (String)JSONHandler.getProperty(degreeInfo,"name");
    JSONArray components = (JSONArray) JSONHandler.getProperty(degree,"components");
    for (Object component : components) {
      String componentName = (String) JSONHandler.getProperty(component,"name");
      JSONArray groups = (JSONArray) JSONHandler.getProperty(component,"groups");
      for(Object group : groups){
        String groupName = (String)JSONHandler.getProperty(group,"name");
        String minUnits = (String)JSONHandler.getProperty(group,"min_units");
        handler.createGroup(adapter.stringToGroupData(groupName,componentName,degreeName,minUnits));
      }
    }
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Map<String, List<Object>> getGroups(){
    Map<String, List<Object>> response = new HashMap<>();
    List<Object> groups = handler.getGroups().stream().collect(Collectors.toList());
    response.put("groups",groups);
    return response;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.DELETE)
  public void deleteAll(){
    handler.deleteAll();
  }
  
  @RequestMapping(value = "/{name}/{component}", method = RequestMethod.DELETE)
  public void deleteByNameAndComponent(@PathVariable String name){
    handler.deleteByName(name);
  }
  
  
}
