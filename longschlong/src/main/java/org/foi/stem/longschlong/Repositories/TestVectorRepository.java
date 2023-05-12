package org.foi.stem.longschlong.Repositories;

import org.foi.stem.longschlong.Entities.Sample;
import org.foi.stem.longschlong.Entities.TestVector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestVectorRepository extends JpaRepository<TestVector, Integer> {
}
