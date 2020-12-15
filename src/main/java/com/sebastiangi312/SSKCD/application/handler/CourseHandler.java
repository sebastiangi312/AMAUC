package com.sebastiangi312.SSKCD.application.handler;

import com.sebastiangi312.SSKCD.application.comando.CourseComando;
import com.sebastiangi312.SSKCD.application.factory.CourseFactory;
import com.sebastiangi312.SSKCD.domain.Course;
import com.sebastiangi312.SSKCD.domain.services.CourseService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseHandler {
  
  private final CourseService courseService;
  private final CourseFactory courseFactory;
  
  public CourseHandler(CourseService courseService, CourseFactory courseFactory) {
    this.courseService = courseService;
    this.courseFactory = courseFactory;
  }
  
  public void saveCourse(CourseComando courseComando) {
    courseService.addCourse(courseFactory.createCourse(courseComando));
  }
  
  public List<Course> getAll() {
    return courseService.getAllCourses();
  }
  
  public Course get(String code) {
    return courseService.getCourseByCode(code);
  }
  
  public void deleteCourseByCode(String code) {
    courseService.deleteCourseByCode(code);
  }
  
  public List<Course> getGradableCourses() {
    return courseService.getGradableCourses();
  }
  
  public List<Course> getApprovedCourses() {
    return courseService.getApprovedCourses();
  }
  
  public void deleteAll() {
    courseService.deleteAll();
  }
  
  public Double getGradeAverage(List<Course> courses) {
    if (courses.isEmpty())
      return 0.0;
    double sumatoryGradesPerUnits = courses.stream().map(i -> i.getUnits() * i.getGrade())
                                           .reduce(0.0, Double::sum);
    double totalUnits = courses.stream().map(Course::getUnits).reduce(0, Integer::sum);
    return sumatoryGradesPerUnits / totalUnits;
  }
  
}
