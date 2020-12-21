package com.sebastiangi312.SSKCD.application.handler;

import com.sebastiangi312.SSKCD.application.adapter.GradeEntityAdapter;
import com.sebastiangi312.SSKCD.persistance.CourseRepositoryService;
import com.sebastiangi312.SSKCD.persistance.GradeRepositoryService;
import com.sebastiangi312.SSKCD.persistance.entity.GradeEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PersistanceGradeHandler {
  
  private final GradeEntityAdapter gradeEntityAdapter;
  private final GradeRepositoryService gradeRepositoryService;
  private final CourseRepositoryService courseRepositoryService;
  
  public PersistanceGradeHandler(GradeEntityAdapter gradeEntityAdapter,
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
  
  public List<Object> getGradedCourses(){
    return Arrays.asList(gradeRepositoryService.getAll().toArray());
  }
}
