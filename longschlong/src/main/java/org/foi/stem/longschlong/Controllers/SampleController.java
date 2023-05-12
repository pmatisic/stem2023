package org.foi.stem.longschlong.Controllers;

import org.foi.stem.longschlong.Entities.Sample;
import org.foi.stem.longschlong.Services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/samples")
public class SampleController {

  @Autowired
  private SampleService sampleService;

  @GetMapping
  public ResponseEntity<Object> getAllSamples() {
    List<Sample> samples = sampleService.findAll();
    return ResponseEntity.ok(samples);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Sample> getSampleById(@PathVariable Integer id) {
    Sample sample = sampleService.findById(id);
    if (sample == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(sample);
  }

  @PostMapping
  public ResponseEntity<Sample> createSample(@RequestBody Sample sample) {
    Sample savedSample = sampleService.save(sample);
    return ResponseEntity.ok(savedSample);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSampleById(@PathVariable Integer id) {
    Sample sample = sampleService.findById(id);
    if (sample == null) {
      return ResponseEntity.notFound().build();
    }
    sampleService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
