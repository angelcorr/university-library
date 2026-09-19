package com.universitylibrary.project.models;

import java.util.ArrayList;

public class Book {
  private String name;
  private String publishingHouse;
  private Integer totalPages;
  private boolean isLoaned;

  public Book(Builder builder) {
    this.name = builder.name;
    this.publishingHouse = builder.publishingHouse;
    this.totalPages = builder.totalPages;
    this.isLoaned = builder.isLoaned;
  }

  public String getName() {
    return name;
  }

  public String getPublishingHouse() {
    return publishingHouse;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public boolean isLoaned() {
    return isLoaned;
  }

  public void updateLoanedState(Boolean loanedState) {
    this.isLoaned = loanedState;
  }

  public static class Builder {
    private String name;
    private String publishingHouse;
    private Integer totalPages;
    private boolean isLoaned;

    public Builder name(String name) {
      this.name = name;
          return this;
    }

    public Builder publishingHouse(String publishingHouse) {
      this.publishingHouse = publishingHouse;
      return this;
    }

    public Builder totalPages(Integer totalPages) {
      this.totalPages = totalPages;
      return this;
    }

    public Builder isLoaned(boolean isLoaned) {
      this.isLoaned = isLoaned;
      return this;
    }

    public Book build() {
      return new Book(this);
    }
  }

}
