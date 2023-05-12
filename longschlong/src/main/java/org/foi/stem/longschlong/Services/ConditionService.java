package org.foi.stem.longschlong.Services;

import org.foi.stem.longschlong.Entities.Condition;
import org.foi.stem.longschlong.Repositories.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionService {

  @Autowired
  private ConditionRepository conditionRepository;

  public List<Condition> findAll() {
    return conditionRepository.findAll();
  }

  public Condition findById(Integer id) {
    return (Condition) conditionRepository.findById(id).orElse(null);
  }

  public Condition save(Condition condition) {
    return conditionRepository.save(condition);
  }

  public void deleteById(Integer id) {
    conditionRepository.deleteById(id);
  }
}
