package org.foi.stem.longschlong.Entities;

import jakarta.persistence.*;

@Entity
public class TestVector {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int index;
  private float temperature;
  private float humidity;
  private float input_voltage;
  private float frequency;

  public TestVector() {
  }

  public TestVector(int index, float temperature, float humidity, float input_voltage, float frequency) {
    this.index = index;
    this.temperature = temperature;
    this.humidity = humidity;
    this.input_voltage = input_voltage;
    this.frequency = frequency;
  }

  // Getters and setters for all fields

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public float getTemperature() {
    return temperature;
  }

  public void setTemperature(float temperature) {
    this.temperature = temperature;
  }

  public float getHumidity() {
    return humidity;
  }

  public void setHumidity(float humidity) {
    this.humidity = humidity;
  }

  public float getInput_voltage() {
    return input_voltage;
  }

  public void setInput_voltage(float input_voltage) {
    this.input_voltage = input_voltage;
  }

  public float getFrequency() {
    return frequency;
  }

  public void setFrequency(float frequency) {
    this.frequency = frequency;
  }
}
