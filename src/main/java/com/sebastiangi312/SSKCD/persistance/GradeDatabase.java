package com.sebastiangi312.SSKCD.persistance;

import com.sebastiangi312.SSKCD.persistance.entity.GradeEntity;
import com.sebastiangi312.SSKCD.persistance.repository.GradeEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class GradeDatabase {
  
  private final GradeEntityRepository repository;
  
  public GradeDatabase(GradeEntityRepository repository) {
    this.repository = repository;
  }
  
  public void addGrade(GradeEntity grade){
    repository.save(grade);
  }
  
  public void getGrade(GradeEntity grade){
  
  }
}
