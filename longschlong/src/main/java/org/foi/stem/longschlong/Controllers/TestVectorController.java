package org.foi.stem.longschlong.Controllers;

import org.foi.stem.longschlong.Entities.TestVector;
import org.foi.stem.longschlong.Services.TestVectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testvectors")
public class TestVectorController {

  @Autowired
  private TestVectorService testVectorService;

  @GetMapping
  public ResponseEntity<List<TestVector>> getAllTestVectors() {
    List<TestVector> testVectors = testVectorService.findAll();
    return ResponseEntity.ok(testVectors);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getTestVectorById(@PathVariable Integer id) {
    TestVector testVector = testVectorService.findById(id);
    if (testVector == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(testVector);
  }

  @PostMapping
  public ResponseEntity<Object> createTestVector(@RequestBody TestVector testVector) {
    TestVector savedTestVector = testVectorService.save(testVector);
    return ResponseEntity.ok(savedTestVector);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTestVectorById(@PathVariable Integer id) {
    TestVector testVector = testVectorService.findById(id);
    if (testVector == null) {
      return ResponseEntity.notFound().build();
    }
    testVectorService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
