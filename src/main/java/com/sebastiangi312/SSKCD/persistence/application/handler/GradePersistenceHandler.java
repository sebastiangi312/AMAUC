package com.sebastiangi312.SSKCD.persistence.application.handler;

import com.sebastiangi312.SSKCD.persistence.application.pdu.GradeData;
import com.sebastiangi312.SSKCD.persistence.database.adapter.GradeEntityAdapter;
import com.sebastiangi312.SSKCD.persistence.database.service.CourseEntityRepositoryService;
import com.sebastiangi312.SSKCD.persistence.database.service.GradeEntityRepositoryService;
import com.sebastiangi312.SSKCD.persistence.database.entity.GradeEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GradePersistenceHandler {
  
  private final GradeEntityAdapter gradeEntityAdapter;
  private final GradeEntityRepositoryService gradeEntityRepositoryService;
  private final CourseEntityRepositoryService courseEntityRepositoryService;
  
  public GradePersistenceHandler(GradeEntityAdapter gradeEntityAdapter,
                                 GradeEntityRepositoryService gradeEntityRepositoryService,
                                 CourseEntityRepositoryService courseEntityRepositoryService) {
    this.gradeEntityAdapter = gradeEntityAdapter;
    this.gradeEntityRepositoryService = gradeEntityRepositoryService;
    this.courseEntityRepositoryService = courseEntityRepositoryService;
  }
  
  
  public void saveGrade(String code, GradeData gradeData) {
    if(courseEntityRepositoryService.getCourse(code) != null){
      gradeEntityRepositoryService.addGrade(
        gradeEntityAdapter.gradeDataToGradeEntity(courseEntityRepositoryService.getCourse(code),gradeData));
    }
  }
  
  public List<Object> getAllGrades(){
    return Arrays.asList(gradeEntityRepositoryService.getAll().toArray());
  }
  
  public List<Object> getApprovedCourses() {
    return gradeEntityRepositoryService.getAll().stream().filter(GradeEntity::isApproved)
                                 .filter(i -> i.getGrade() != null).collect(Collectors.toList());
  }
  
  public List<Object> getGradedCourses() {
    return gradeEntityRepositoryService.getAll().stream().filter(i -> i.getGrade() != null)
                                 .collect(Collectors.toList());
  }
  
  public void deleteAll(){ gradeEntityRepositoryService.deleteAll(); }
  
}
