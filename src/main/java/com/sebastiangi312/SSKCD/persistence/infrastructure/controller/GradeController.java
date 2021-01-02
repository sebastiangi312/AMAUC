package com.sebastiangi312.SSKCD.persistence.infrastructure.controller;

import com.sebastiangi312.SSKCD.persistence.application.adapter.GradeDataAdapter;
import com.sebastiangi312.SSKCD.persistence.infrastructure.inputs.gradeTXT.TXTHandler;
import com.sebastiangi312.SSKCD.persistence.application.handler.GradePersistenceHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/courseManager/grades")
public class GradeController {
  
  private final GradePersistenceHandler gradePersistenceHandler;
  private final GradeDataAdapter gradeDataAdapter;
  private final CourseController courseController;
  
  public GradeController(GradePersistenceHandler gradePersistenceHandler,
                         GradeDataAdapter gradeDataAdapter,
                         CourseController courseController) {
    this.gradePersistenceHandler = gradePersistenceHandler;
    this.gradeDataAdapter = gradeDataAdapter;
    this.courseController = courseController;
  }
  
  @Transactional
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public void uploadGrades(@RequestBody final String gradesInTxt) {
    for (String[] course : TXTHandler.parseToList(gradesInTxt)) {
      String code = TXTHandler.separateIdAndName(course[0])[0];
      String name = TXTHandler.separateIdAndName(course[0])[1];
      if(courseController.get(code).get("course") == null)
        courseController.uploadLECourse(code,name,course[1]);
      gradePersistenceHandler.saveGrade(code,
        gradeDataAdapter.StringToGradeData(course[5], course[4], course[3]));
    }
  }
  
  @RequestMapping(value = "/", method = RequestMethod.DELETE)
  public void deleteAllCourses() {
    gradePersistenceHandler.deleteAll();
  }
  
  
  @RequestMapping(value = "/gradedCourses", method = RequestMethod.GET)
  public Map<String, List<Object>> getGradedCourses() {
    Map<String, List<Object>> response = new HashMap<>();
    response.put("courses", gradePersistenceHandler.getGradedCourses());
    return response;
  }
  
  @RequestMapping(value = "/approvedCourses", method = RequestMethod.GET)
  public Map<String, List<Object>> getApprovedCourses() {
    Map<String, List<Object>> response = new HashMap<>();
    response.put("courses", gradePersistenceHandler.getApprovedCourses());
    return response;
  }
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Map<String, List<Object>> getGrades() {
    Map<String, List<Object>> response = new HashMap<>();
    response.put("courses", gradePersistenceHandler.getAllGrades());
    return response;
  }
}
