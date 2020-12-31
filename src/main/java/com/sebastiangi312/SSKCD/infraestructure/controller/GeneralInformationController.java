package com.sebastiangi312.SSKCD.infraestructure.controller;

import com.sebastiangi312.SSKCD.application.handler.GradeHandler;
import com.sebastiangi312.SSKCD.application.adapter.GradeAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/courseManager/generalInformation")
public class GeneralInformationController {
  
  private final GradeController courseController;
  private final GradeHandler gradeHandler;
  private final GradeAdapter gradeAdapter;
  
  public GeneralInformationController(GradeController courseController,
                                      GradeHandler gradeHandler, GradeAdapter gradeAdapter) {
    this.courseController = courseController;
    this.gradeHandler = gradeHandler;
    this.gradeAdapter = gradeAdapter;
  }
  
  @RequestMapping(value = "/PAPA", method = RequestMethod.GET)
  public Map<String, Double> getPAPA() {
    Map<String, Double> response = new HashMap<>();
    List<Object> gradedCourses = courseController.getGradedCourses().get("courses");
    response.put("PAPA", gradeHandler.getPAPA(gradedCourses.stream().map(gradeAdapter::GradeEntityToCourse)
                                                                    .filter(i -> i.getGrade()!= null).collect(Collectors.toList())));
    return response;
  }
  
  @RequestMapping(value = "/PA", method = RequestMethod.GET)
  public Map<String, Double> getPA() {
    Map<String, Double> response = new HashMap<>();
    List<Object> approvedCourses = courseController.getApprovedCourses().get("courses");
    response.put("PA", gradeHandler.getPA(approvedCourses.stream().map(gradeAdapter::GradeEntityToCourse)
                                                                  .collect(Collectors.toList())));
    return response;
  }
}
