package com.sebastiangi312.SSKCD.application.handler;

import com.sebastiangi312.SSKCD.application.adapter.CourseEntityAdapter;
import com.sebastiangi312.SSKCD.application.adapter.GradeEntityAdapter;
import com.sebastiangi312.SSKCD.persistance.CourseDatabase;
import com.sebastiangi312.SSKCD.persistance.GradeDatabase;
import com.sebastiangi312.SSKCD.persistance.entity.CourseEntity;
import com.sebastiangi312.SSKCD.persistance.entity.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class PersistanceHandler {
  
  private final CourseEntityAdapter courseEntityAdapter;
  private final GradeEntityAdapter gradeEntityAdapter;
  private final CourseDatabase courseDatabase;
  private final GradeDatabase gradeDatabase;
  
  public PersistanceHandler(CourseEntityAdapter courseEntityAdapter, GradeEntityAdapter gradeEntityAdapter,
                            CourseDatabase courseDatabase, GradeDatabase gradeDatabase) {
    this.courseEntityAdapter = courseEntityAdapter;
    this.gradeEntityAdapter = gradeEntityAdapter;
    this.courseDatabase = courseDatabase;
    this.gradeDatabase = gradeDatabase;
  }
  
  public void saveGradedCourses(String[] courseArray) {
    CourseEntity course = courseEntityAdapter.transformSringArraytoEntities(courseArray[0], courseArray[1]);
    courseDatabase.addCourse(course);
    GradeEntity grade = gradeEntityAdapter.adaptToGradeEntity(course, courseArray[5], courseArray[4], courseArray[3]);
    gradeDatabase.addGrade(grade);
  }
  
  
}
