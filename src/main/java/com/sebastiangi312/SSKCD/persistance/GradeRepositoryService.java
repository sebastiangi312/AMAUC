package com.sebastiangi312.SSKCD.persistance;

import com.sebastiangi312.SSKCD.persistance.entity.GradeEntity;
import com.sebastiangi312.SSKCD.persistance.repository.GradeEntityRepository;
import org.springframework.stereotype.Component;

@Component
public class GradeRepositoryService {
  
  private final GradeEntityRepository repository;
  
  public GradeRepositoryService(GradeEntityRepository repository) {
    this.repository = repository;
  }
  
  public void addGrade(GradeEntity grade){
    repository.save(grade);
  }
  
}
