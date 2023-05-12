package org.foi.stem.longschlong.Services;

import org.foi.stem.longschlong.Entities.TestVector;
import org.foi.stem.longschlong.Repositories.TestVectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestVectorService {

  @Autowired
  private TestVectorRepository testVectorRepository;

  public List<TestVector> findAll() {
    return testVectorRepository.findAll();
  }

  public TestVector findById(Integer id) {
    return testVectorRepository.findById(id).orElse(null);
  }

  public TestVector save(TestVector testVector) {
    return testVectorRepository.save(testVector);
  }

  public void deleteById(Integer id) {
    testVectorRepository.deleteById(id);
  }
}
