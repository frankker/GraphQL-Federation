package com.example.dgsdemo.domain;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Review {
  private Integer starRating;

  public Review() {
  }

  public Review(Integer starRating) {
    this.starRating = starRating;
  }

  public Integer getStarRating() {
    return starRating;
  }

  public void setStarRating(Integer starRating) {
    this.starRating = starRating;
  }

  @Override
  public String toString() {
    return "Review{" + "starRating='" + starRating + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review that = (Review) o;
        return java.util.Objects.equals(starRating, that.starRating);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(starRating);
  }



}
