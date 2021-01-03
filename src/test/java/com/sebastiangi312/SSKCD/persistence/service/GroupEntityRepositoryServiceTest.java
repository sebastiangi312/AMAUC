package com.sebastiangi312.SSKCD.persistence.service;

import com.sebastiangi312.SSKCD.persistence.database.entity.GroupEntity;
import com.sebastiangi312.SSKCD.persistence.database.fabric.GroupEntityFabric;
import com.sebastiangi312.SSKCD.persistence.database.service.GroupEntityRepositoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GroupEntityRepositoryServiceTest {
  
  @Autowired
  private GroupEntityRepositoryService repositoryService;
  
  @Autowired
  private GroupEntityFabric groupEntityFabric;
  
  @Test
  public void dontAddDuplicates(){
    GroupEntity groupEntity = groupEntityFabric.createGroupEntity("A","AComponent","IS",3);
    repositoryService.addGroup(groupEntity);
    repositoryService.addGroup(groupEntity);
    Assertions.assertEquals(1, repositoryService.getAll().size());
    repositoryService.deleteAll();
  }
  
  @Test
  public void getAnEmptyListIfThereIsNotGroups(){
    Assertions.assertEquals(0, repositoryService.getAll().size());
  }
  
  @Test
  public void getCorrectGroupByNameAndComponent(){
    GroupEntity groupEntity = groupEntityFabric.createGroupEntity("A","AComponent","IS",3);
    repositoryService.addGroup(groupEntity);
    Assertions.assertEquals("A", repositoryService.get("A","AComponent").getName());
    repositoryService.deleteAll();
  }
}
