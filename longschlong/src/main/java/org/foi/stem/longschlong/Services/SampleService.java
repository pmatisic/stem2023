package org.foi.stem.longschlong.Services;

import org.foi.stem.longschlong.Entities.Sample;
import org.foi.stem.longschlong.Repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

  @Autowired
  private SampleRepository sampleRepository;

  public List<Sample> findAll() {
    return sampleRepository.findAll();
  }

  public Sample findById(Integer id) {
    return sampleRepository.findById(id).orElse(null);
  }

  public Sample save(Sample sample) {
    return sampleRepository.save(sample);
  }

  public void deleteById(Integer id) {
    sampleRepository.deleteById(id);
  }
}
