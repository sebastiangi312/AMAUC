package com.sebastiangi312.SSKCD.application.handler;

import com.sebastiangi312.SSKCD.application.factory.CourseFactory;
import com.sebastiangi312.SSKCD.domain.Course;
import com.sebastiangi312.SSKCD.domain.services.CourseService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseHandler {
  
  private final CourseService courseService;
  private final CourseFactory courseFactory;
  
  public CourseHandler(CourseService courseService, CourseFactory courseFactory) {
    this.courseService = courseService;
    this.courseFactory = courseFactory;
  }
  
  public void saveCourses(List<String[]> courses) {
    for (String[] course : courses) {
      String[] idAndName = separateIdAndName(course[0]);
      String id = idAndName[0];
      String name = idAndName[1];
      int units = Integer.parseInt(course[1]);
      double grade;
      Course.typeCourse isGradable;
      try{
        grade = Double.parseDouble(course[4]);
        isGradable = Course.typeCourse.gradable;
      }catch (Exception e){
        grade = 0;
        isGradable = Course.typeCourse.noGradable;
      }
      courseService.addCourse(courseFactory.createCourse(id,name,units,grade, isGradable));
    }
  }
  
  private String[] separateIdAndName(String idAndName) {
    
    String name = idAndName.split("\\s\\(\\d+\\)")[0];
    StringBuilder id = new StringBuilder();
    boolean aux = false;
    for (int i = idAndName.length() - 1; i >= 0; i--) {
      if (idAndName.charAt(i) == '(')
        break;
      if (aux)
        id.insert(0, idAndName.charAt(i));
      if (idAndName.charAt(i) == ')')
        aux = true;
    }
    return new String[]{id.toString(), name};
  }
  
  public List<Course> getAll() {
    return courseService.getAllCourses();
  }
  
  public Course get(String code) { return courseService.getCourseByCode(code);}
  
  public void deleteCourseByCode(String code){
    courseService.deleteCourseByCode(code);
  }
  
  public List<Course> getGradableCourses(){ return courseService.getGradableCourses(); }
  
  public List<Course> getApprovedCourses(){ return courseService.getApprovedCourses(); }
  
  public Double getGradeAverage(List<Course> courses){
    if(courses.isEmpty())
      return 0.0;
    double sumatoryGradesperUnits = courses.stream().map(i -> i.getUnits()*i.getGrade()).reduce(0.0, Double::sum);
    double totalUnits = courses.stream().map(Course::getUnits).reduce(0, Integer::sum);
    return sumatoryGradesperUnits / totalUnits;
  }
}
