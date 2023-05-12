package org.foi.stem.longschlong.Repositories;

import org.foi.stem.longschlong.Entities.TestCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestCollectionRepository extends JpaRepository<TestCollection, Integer> {
  Optional<TestCollection> findById(Integer id);

  TestCollection save(TestCollection testCollection);

  void deleteById(Integer id);
}
