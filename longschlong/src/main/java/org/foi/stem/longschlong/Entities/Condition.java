package org.foi.stem.longschlong.Entities;

import jakarta.persistence.*;

@Entity
@Table (name = "conditions", schema = "public", catalog = "postgres")
public class Condition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String parameter;
  private float minimum;
  private float maximum;
  private float time_between_points;

  public Condition() {
  }

  public Condition(int id, String parameter, float minimum, float maximum,
      float time_between_points) {
    this.id = id;
    this.parameter = parameter;
    this.minimum = minimum;
    this.maximum = maximum;
    this.time_between_points = time_between_points;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getParameter() {
    return parameter;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  public float getMinimum() {
    return minimum;
  }

  public void setMinimum(float minimum) {
    this.minimum = minimum;
  }

  public float getMaximum() {
    return maximum;
  }

  public void setMaximum(float maximum) {
    this.maximum = maximum;
  }

  public float getTime_between_points() {
    return time_between_points;
  }

  public void setTime_between_points(float time_between_points) {
    this.time_between_points = time_between_points;
  }
}
