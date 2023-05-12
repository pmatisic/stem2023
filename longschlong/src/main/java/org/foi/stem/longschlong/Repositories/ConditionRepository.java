package org.foi.stem.longschlong.Repositories;

import org.foi.stem.longschlong.Entities.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Integer> {
  Optional<Condition> findById(Integer id);

  Condition save(Condition condition);

  void deleteById(Integer id);
}
