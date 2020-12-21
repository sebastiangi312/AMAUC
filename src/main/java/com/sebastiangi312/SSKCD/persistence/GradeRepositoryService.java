package com.sebastiangi312.SSKCD.persistence;

import com.sebastiangi312.SSKCD.persistence.entity.GradeEntity;
import com.sebastiangi312.SSKCD.persistence.repository.GradeEntityRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class GradeRepositoryService {
  
  private final GradeEntityRepository repository;
  
  public GradeRepositoryService(GradeEntityRepository repository) {
    this.repository = repository;
  }
  
  public void addGrade(GradeEntity grade){
    repository.save(grade);
  }
  
  public List<GradeEntity> getAll(){
    return StreamSupport.stream(repository.findAll().spliterator(), false).
      collect(Collectors.toList());
  }
}
