package org.foi.stem.longschlong.Services;

import org.foi.stem.longschlong.Entities.TestCollection;
import org.foi.stem.longschlong.Repositories.TestCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCollectionService {

  @Autowired
  private TestCollectionRepository testCollectionRepository;

  public List<TestCollection> findAll() {
    return testCollectionRepository.findAll();
  }

  public TestCollection findById(Integer id) {
    return (TestCollection) testCollectionRepository.findById(id).orElse(null);
  }

  public TestCollection save(TestCollection testCollection) {
    return testCollectionRepository.save(testCollection);
  }

  public void deleteById(Integer id) {
    testCollectionRepository.deleteById(id);
  }
}
