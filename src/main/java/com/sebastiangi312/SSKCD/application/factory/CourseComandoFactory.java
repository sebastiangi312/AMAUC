package com.sebastiangi312.SSKCD.application.factory;

import com.sebastiangi312.SSKCD.application.comando.CourseComando;
import com.sebastiangi312.SSKCD.domain.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseComandoFactory {
  
  public CourseComando createCourseComando(String[] course){
    String[] idAndName = separateIdAndName(course[0]);
    int units = Integer.parseInt(course[1]);
    double grade;
    Course.typeCourse isGradable;
    try {
      grade = Double.parseDouble(course[4]);
      isGradable = Course.typeCourse.gradable;
    } catch (Exception e) {
      grade = 0;
      isGradable = Course.typeCourse.noGradable;
    }
    return new CourseComando(idAndName[0],idAndName[1],units,grade, isGradable);
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
}
