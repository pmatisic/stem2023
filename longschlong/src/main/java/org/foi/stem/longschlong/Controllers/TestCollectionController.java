package org.foi.stem.longschlong.Controllers;

import org.foi.stem.longschlong.Entities.TestCollection;
import org.foi.stem.longschlong.Services.TestCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcollections")
public class TestCollectionController {

  @Autowired
  private TestCollectionService testCollectionService;

  @GetMapping
  public ResponseEntity<List<TestCollection>> getAllTestCollections() {
    List<TestCollection> testCollections = testCollectionService.findAll();
    return ResponseEntity.ok(testCollections);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TestCollection> getTestCollectionById(@PathVariable Integer id) {
    TestCollection testCollection = testCollectionService.findById(id);
    if (testCollection == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(testCollection);
  }

  @PostMapping
  public ResponseEntity<TestCollection> createTestCollection(
      @RequestBody TestCollection testCollection) {
    TestCollection savedTestCollection = testCollectionService.save(testCollection);
    return ResponseEntity.ok(savedTestCollection);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTestCollectionById(@PathVariable Integer id) {
    TestCollection testCollection = testCollectionService.findById(id);
    if (testCollection == null) {
      return ResponseEntity.notFound().build();
    }
    testCollectionService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
