package org.foi.stem.longschlong.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "samples", schema = "public", catalog = "postgres")
public class Sample {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String family_name;
  private String product_name;
  private String name;

  public Sample() {
  }

  public Sample(int id, String family_name, String product_name, String name) {
    this.id = id;
    this.family_name = family_name;
    this.product_name = product_name;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFamily_name() {
    return family_name;
  }

  public void setFamily_name(String family_name) {
    this.family_name = family_name;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
