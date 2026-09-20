package com.universitylibrary.project.models;

import java.util.ArrayList;

public class Book {
  private String isbn;
  private String name;
  private String publishingHouse;
  private Integer totalPages;
  private boolean isLoaned = false;

  public Book(Builder builder) {
    this.isbn = builder.isbn;
    this.name = builder.name;
    this.publishingHouse = builder.publishingHouse;
    this.totalPages = builder.totalPages;
  }

  public String getIsbn() {
    return isbn;
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

  public void setLoanedStatus(Boolean status) {
    this.isLoaned = status;
  }

  public void updateLoanedState(Boolean loanedState) {
    this.isLoaned = loanedState;
  }

  @Override
  public String toString() {
    return "Book title" + name + ". Was published by " + publishingHouse + " and has " + totalPages + " pages.";
  }

  public static class Builder {
    private String isbn;
    private String name;
    private String publishingHouse;
    private Integer totalPages;

    public Builder isbn(String isbn) {
      this.isbn = isbn;
      return this;
    }

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

    public Book build() {
      if (isbn == null || name == null || publishingHouse == null) {
        throw new IllegalStateException("Isbn, name and publish house are mandatory");
      }

      return new Book(this);
    }
  }

}
