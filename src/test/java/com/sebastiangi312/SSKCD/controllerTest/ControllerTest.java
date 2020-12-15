package com.sebastiangi312.SSKCD.controllerTest;

import com.sebastiangi312.SSKCD.infraestructure.controller.CourseController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class ControllerTest {
  
  @Autowired
  private CourseController courseController;
  
  @Test
  public void verifyParse(){
    
    String courses = "BASE DE DATOS II (3007848) \t3\tDISCIPLINAR OPTATIVA\t2019-2S Ordinaria\t4.3\n" +
      "APROBADA\n" +
      "ESTADÍSTICA II (3006915) \t4\tFUND. OPTATIVA\t2019-2S Ordinaria\t3.5\n" +
      "APROBADA\n";
    
    List<String[]> obtained = courseController.parseToList(courses);
    
    String[] first = {"BASE DE DATOS II (3007848) ", "3", "DISCIPLINAR OPTATIVA",
                    "2019-2S Ordinaria", "4.3", "APROBADA"};
    String[] second = {"ESTADÍSTICA II (3006915) ", "4", "FUND. OPTATIVA",
      "2019-2S Ordinaria", "3.5", "APROBADA"};
    List<String[]> expected = new LinkedList<>();
    expected.add(first);
    expected.add(second);
    
    for(int i = 0; i < obtained.size();i++){
      for (int j = 0; j < obtained.get(i).length; j++) {
        Assert.assertEquals(expected.get(i)[j],obtained.get(i)[j]);
      }
    }
  }
  @Test
  public void isGettingCorrectGeneralInformation(){
    String courses = "BASE DE DATOS II (3007848) \t3\tDISCIPLINAR OPTATIVA\t2019-2S Ordinaria\t4.3\n" +
      "APROBADA\n" +
      "ESTADÍSTICA II (3006915) \t4\tFUND. OPTATIVA\t2019-2S Ordinaria\t3.5\n" +
      "APROBADA\n" +
      "TEORÍA DE LA GESTIÓN (3007333) \t3\tDISCIPLINAR OBLIGATORIA\t2017-2S Ordinaria\t2.5\n" +
      "REPROBADA";
    
    courseController.uploadCourses(courses);
    
    double PAPA = 3.44;
    double PA = 3.84;
    String expected = "{ PAPA: +"+String.format("%.2g%n", PAPA)+
      ",\nPA: "+String.format("%.2g%n", PA)+"\n }";
    
    Assert.assertEquals(expected,courseController.getPAPA());
  }
}
