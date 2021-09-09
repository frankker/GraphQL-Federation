package com.example.dgsdemo.domain;

public class Rating {
  private final int avgStars;

  public Rating(int avgStars) {
    this.avgStars = avgStars;
  }

  public int getAvgStars() {
    return avgStars;
  }

}
