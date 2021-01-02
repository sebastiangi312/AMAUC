package com.sebastiangi312.SSKCD.persistence.database.service;

import com.sebastiangi312.SSKCD.persistence.application.adapter.GradeDataAdapter;
import com.sebastiangi312.SSKCD.persistence.database.entity.GradeEntity;
import com.sebastiangi312.SSKCD.persistence.database.repository.GradeEntityRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class GradeRepositoryService {
  
  private final GradeEntityRepository repository;
  private final GradeDataAdapter adapter;
  
  public GradeRepositoryService(GradeEntityRepository repository,
                                GradeDataAdapter adapter) {
    this.repository = repository;
    this.adapter = adapter;
  }
  
  public void addGrade(GradeEntity grade){
    repository.save(grade);
  }
  
  public List<GradeEntity> getAll(){
    return StreamSupport.stream(repository.findAll().spliterator(), false).
      collect(Collectors.toList());
  }
  
  public void deleteAll(){
    repository.deleteAll();
  }
  
}
