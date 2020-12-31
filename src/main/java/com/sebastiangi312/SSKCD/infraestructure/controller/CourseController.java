package com.sebastiangi312.SSKCD.infraestructure.controller;

import com.sebastiangi312.SSKCD.infraestructure.persistenceHandler.CoursePersistenceHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
  public void uploadCourses(@RequestBody final String career) {
    JSONObject pensum = readPensum(career);
    JSONArray components = (JSONArray) pensum.get("components");
    for (Object groupsObject : components) {
      JSONArray groups = (JSONArray) ((JSONObject) groupsObject).get("group");
      for(Object coursesObject : groups){
        JSONArray courses = (JSONArray) ((JSONObject) coursesObject).get("courses");
        for(Object course: courses){
          addCourse((JSONObject) course);
        }
      }
    }
  }
  
  private JSONObject readPensum(String pensum) {
    File resource;
    try {
      final String PATH = "pensums/" + pensum + ".json";
      resource = new ClassPathResource(PATH).getFile();
      String text = new String(Files.readAllBytes(resource.toPath()));
      JSONParser parser = new JSONParser();
      return (JSONObject) parser.parse(text);
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
    return null;
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
