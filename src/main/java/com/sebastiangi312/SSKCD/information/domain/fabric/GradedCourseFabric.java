package com.sebastiangi312.SSKCD.information.domain.fabric;

import com.sebastiangi312.SSKCD.information.domain.model.GradedCourse;
import org.springframework.stereotype.Component;

@Component
public class GradedCourseFabric {
  
  public GradedCourse createGradedCourse(String code, String name, int units,
                                                boolean isApproved, double grade, String date) {
    return new GradedCourse(code, name, units, isApproved, grade, date);
  }
}
