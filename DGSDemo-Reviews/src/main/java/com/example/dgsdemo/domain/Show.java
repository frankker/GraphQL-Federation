package com.example.dgsdemo.domain;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class Show {
  private String id;

  private List<Review> reviews;

  public Show() {
  }

  public Show(String id, List<Review> reviews) {
    this.id = id;
    this.reviews = reviews;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  @Override
  public String toString() {
    return "Show{" + "id='" + id + "'," +"reviews='" + reviews + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show that = (Show) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(reviews, that.reviews);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, reviews);
  }

}
