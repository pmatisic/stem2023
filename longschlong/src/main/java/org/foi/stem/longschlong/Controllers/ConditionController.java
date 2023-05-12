package org.foi.stem.longschlong.Controllers;

import org.foi.stem.longschlong.Entities.Condition;
import org.foi.stem.longschlong.Services.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conditions")
public class ConditionController {

  @Autowired
  private ConditionService conditionService;

  @GetMapping
  public ResponseEntity<List<Condition>> getAllConditions() {
    List<Condition> conditions = conditionService.findAll();
    return ResponseEntity.ok(conditions);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Condition> getConditionById(@PathVariable Integer id) {
    Condition condition = conditionService.findById(id);
    if (condition == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(condition);
  }

  @PostMapping
  public ResponseEntity<Condition> createCondition(@RequestBody Condition condition) {
    Condition savedCondition = conditionService.save(condition);
    return ResponseEntity.ok(savedCondition);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteConditionById(@PathVariable Integer id) {
    Condition condition = conditionService.findById(id);
    if (condition == null) {
      return ResponseEntity.notFound().build();
    }
    conditionService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
