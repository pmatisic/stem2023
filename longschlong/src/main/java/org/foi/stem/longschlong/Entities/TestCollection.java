package org.foi.stem.longschlong.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table (name = "testcollections", schema = "public", catalog = "postgres")
public class TestCollection {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int input_condition_id;
  private int sample_id;

  @Column(name = "test_points", columnDefinition = "float[]")
  @Type(type = "com.vladmihalcea.hibernate.type.array.FloatArrayType")
  private Float[] testPoints;

  public TestCollection() {
  }

  public TestCollection(int id, int input_condition_id, int sample_id, Float[] test_points) {
    this.id = id;
    this.input_condition_id = input_condition_id;
    this.sample_id = sample_id;
    this.test_points = test_points;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getInput_condition_id() {
    return input_condition_id;
  }

  public void setInput_condition_id(int input_condition_id) {
    this.input_condition_id = input_condition_id;
  }

  public int getSample_id() {
    return sample_id;
  }

  public void setSample_id(int sample_id) {
    this.sample_id = sample_id;
  }

  public Object getTest_points() {
    return test_points;
  }

  public void setTest_points(Float[] test_points) {
    this.test_points = test_points;
  }
}
