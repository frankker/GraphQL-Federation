package com.example.dgsdemo.domain;

public class Show {
  private final int id;
  private final String title;
  private final Integer releaseYear;

  public Show(int id, String title, Integer releaseYear) {
    this.id = id;
    this.title = title;
    this.releaseYear = releaseYear;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }
}
