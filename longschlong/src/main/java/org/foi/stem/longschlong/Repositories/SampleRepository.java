package org.foi.stem.longschlong.Repositories;

import org.foi.stem.longschlong.Entities.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Integer> {
  Optional<Sample> findById(Integer id);

  Sample save(Sample sample);

  void deleteById(Integer id);
}
