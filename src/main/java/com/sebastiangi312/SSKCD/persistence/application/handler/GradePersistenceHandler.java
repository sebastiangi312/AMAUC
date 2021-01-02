package com.sebastiangi312.SSKCD.persistence.application.handler;

import com.sebastiangi312.SSKCD.persistence.application.pdu.GradeData;
import com.sebastiangi312.SSKCD.persistence.database.adapter.GradeEntityAdapter;
import com.sebastiangi312.SSKCD.persistence.database.service.CourseRepositoryService;
import com.sebastiangi312.SSKCD.persistence.database.service.GradeRepositoryService;
import com.sebastiangi312.SSKCD.persistence.database.entity.GradeEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GradePersistenceHandler {
  
  private final GradeEntityAdapter gradeEntityAdapter;
  private final GradeRepositoryService gradeRepositoryService;
  private final CourseRepositoryService courseRepositoryService;
  
  public GradePersistenceHandler(GradeEntityAdapter gradeEntityAdapter,
                                 GradeRepositoryService gradeRepositoryService,
                                 CourseRepositoryService courseRepositoryService) {
    this.gradeEntityAdapter = gradeEntityAdapter;
    this.gradeRepositoryService = gradeRepositoryService;
    this.courseRepositoryService = courseRepositoryService;
  }
  
  
  public void saveGrade(String code, GradeData gradeData) {
    if(courseRepositoryService.getCourse(code) != null){
      gradeRepositoryService.addGrade(
        gradeEntityAdapter.gradeDataToGradeEntity(courseRepositoryService.getCourse(code),gradeData));
    }
  }
  
  public List<Object> getAllGrades(){
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
  
  public void deleteAll(){ gradeRepositoryService.deleteAll(); }
  
}
