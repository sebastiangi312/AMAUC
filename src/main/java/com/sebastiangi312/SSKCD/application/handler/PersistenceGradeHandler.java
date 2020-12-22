package com.sebastiangi312.SSKCD.application.handler;

import com.sebastiangi312.SSKCD.persistence.adapter.GradeEntityAdapter;
import com.sebastiangi312.SSKCD.persistence.CourseRepositoryService;
import com.sebastiangi312.SSKCD.persistence.GradeRepositoryService;
import com.sebastiangi312.SSKCD.persistence.entity.GradeEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersistenceGradeHandler {
  
  private final GradeEntityAdapter gradeEntityAdapter;
  private final GradeRepositoryService gradeRepositoryService;
  private final CourseRepositoryService courseRepositoryService;
  
  public PersistenceGradeHandler(GradeEntityAdapter gradeEntityAdapter,
                                 GradeRepositoryService gradeRepositoryService,
                                 CourseRepositoryService courseRepositoryService) {
    this.gradeEntityAdapter = gradeEntityAdapter;
    this.gradeRepositoryService = gradeRepositoryService;
    this.courseRepositoryService = courseRepositoryService;
  }
  
  public void saveGrade(String code, String approved, String grade, String semester) {
    gradeRepositoryService.addGrade(gradeEntityAdapter.adaptToGradeEntity(
      courseRepositoryService.getCourse(code), approved, grade, semester));
  }
  
  public List<Object> getCourses(){
    return Arrays.asList(gradeRepositoryService.getAll().toArray());
  }
  
  public List<Object> getApprovedCourses() {
    return gradeRepositoryService.getAll().stream().filter(GradeEntity::isApproved)
                                 .filter(i -> i.getGrade() != null).collect(Collectors.toList());
  }
  
  public List<Object> getGradedCourses() {
    return gradeRepositoryService.getAll().stream().filter(i -> i.getGrade() != null)
                                 .collect(Collectors.toList());
  }
}
