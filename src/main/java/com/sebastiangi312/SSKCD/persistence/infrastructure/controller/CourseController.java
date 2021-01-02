package com.sebastiangi312.SSKCD.persistence.infrastructure.controller;

import com.sebastiangi312.SSKCD.persistence.application.adapter.CourseDataAdapter;
import com.sebastiangi312.SSKCD.persistence.infrastructure.inputs.JSONPensums.JSONHandler;
import com.sebastiangi312.SSKCD.persistence.application.handler.CoursePersistenceHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/courseManager/courses")
public class CourseController {
  
  private final CoursePersistenceHandler coursePersistenceHandler;
  private final CourseDataAdapter courseDataAdapter;
  
  public CourseController(CoursePersistenceHandler coursePersistenceHandler,
                          CourseDataAdapter courseDataAdapter) {
    this.coursePersistenceHandler = coursePersistenceHandler;
    this.courseDataAdapter = courseDataAdapter;
  }
  
  @Transactional
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public void uploadCourses(@RequestBody final String degreeSelected) {
    JSONObject degree = JSONHandler.readJSON(degreeSelected);
    JSONArray components = (JSONArray) JSONHandler.getProperty(degree,"components");
    for (Object component : components) {
      JSONArray groups = (JSONArray) JSONHandler.getProperty(component,"groups");
      for(Object group : groups){
        JSONArray courses = (JSONArray) JSONHandler.getProperty(group,"courses");
        for(Object course: courses){
          String componentName =  (String) JSONHandler.getProperty(component,"name");
          String groupName = (String) JSONHandler.getProperty(group,"name");
          addCourse((JSONObject)course, componentName, groupName);
        }
      }
    }
  }
  
  private void addCourse(JSONObject course, String componentName, String groupName) {
    String name = (String) course.get("name");
    String code = (String) course.get("code");
    String units = (String) course.get("units");
    coursePersistenceHandler.saveCourses(
      courseDataAdapter.StringToCourseData(code,name,units), groupName, componentName);
  }
  
  public void uploadLECourse(String code, String name, String units) {
    coursePersistenceHandler.saveCourses(
      courseDataAdapter.StringToCourseData(code,name,units),
      "Libre Elección", "Libre Elección");
  }
  
  @RequestMapping(value = "/{code}", method = RequestMethod.GET)
  public Map<String, Object> get(@PathVariable String code) {
    Map<String, Object> response = new HashMap<>();
    response.put("course", coursePersistenceHandler.getCourse(code));
    return response;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Map<String, List<Object>> getCourses() {
    Map<String, List<Object>> response = new HashMap<>();
    response.put("courses", coursePersistenceHandler.getCourses());
    return response;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.DELETE)
  public void deleteAllCourses() {
    coursePersistenceHandler.deleteAll();
  }
  
  @Transactional
  @RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
  public void delete(@PathVariable String code) {
    coursePersistenceHandler.delete(code);
  }
  
}
