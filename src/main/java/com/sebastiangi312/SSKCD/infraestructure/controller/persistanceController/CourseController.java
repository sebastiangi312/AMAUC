package com.sebastiangi312.SSKCD.infraestructure.controller.persistanceController;

import com.sebastiangi312.SSKCD.infraestructure.controller.inputs.JSONHandler;
import com.sebastiangi312.SSKCD.infraestructure.persistenceHandler.CoursePersistenceHandler;
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
  
  public CourseController(CoursePersistenceHandler coursePersistenceHandler) {
    this.coursePersistenceHandler = coursePersistenceHandler;
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
          addCourse((JSONObject)course);
        }
      }
    }
  }
  
  private void addCourse(JSONObject course) {
    String name = (String) course.get("name");
    String code = (String) course.get("code");
    String units = (String) course.get("units");
    coursePersistenceHandler.saveCourses(code, name, units);
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
