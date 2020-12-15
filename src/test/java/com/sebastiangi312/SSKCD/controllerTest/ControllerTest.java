package com.sebastiangi312.SSKCD.controllerTest;

import com.sebastiangi312.SSKCD.infraestructure.controller.CourseController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
public class ControllerTest {
  
  @Autowired
  private CourseController courseController;
  
  
  @Test
  public void isGettingCorrectGeneralInformation(){
    String courses = "BASE DE DATOS II (3007848) \t3\tDISCIPLINAR OPTATIVA\t2019-2S Ordinaria\t4.3\n" +
      "APROBADA\n" +
      "ESTADÍSTICA II (3006915) \t4\tFUND. OPTATIVA\t2019-2S Ordinaria\t3.5\n" +
      "APROBADA\n" +
      "TEORÍA DE LA GESTIÓN (3007333) \t3\tDISCIPLINAR OBLIGATORIA\t2017-2S Ordinaria\t2.5\n" +
      "REPROBADA";
    
    courseController.uploadCourses(courses);
  
    Map<String,Double> expected = new HashMap<>();
    expected.put("PAPA",3.44);
    expected.put("PA",3.84);
    
    Assert.assertEquals(expected.get("PAPA"), courseController.getGradeAverage().get("PAPA"),0.01);
    Assert.assertEquals(expected.get("PA"), courseController.getGradeAverage().get("PA"), 0.01);
    
    courseController.deleteAll();
  }
}
