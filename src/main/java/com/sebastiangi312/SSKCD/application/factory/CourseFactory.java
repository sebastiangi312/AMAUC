package com.sebastiangi312.SSKCD.application.factory;

import com.sebastiangi312.SSKCD.application.comando.CourseComando;
import com.sebastiangi312.SSKCD.domain.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseFactory {
  
  public Course createCourse(CourseComando comando){
    return new Course(comando.getId(), comando.getName(), comando.getUnits(),
                      comando.getGrade(),comando.getIsGradable());
  }
}
