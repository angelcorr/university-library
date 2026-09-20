package com.universitylibrary.project.models;

public class Book implements Cloneable {
  private String isbn;
  private String title;
  private String publishingHouse;
  private Integer totalPages;
  private boolean isLoaned = false;

  public Book(Builder builder) {
    this.isbn = builder.isbn;
    this.title = builder.name;
    this.publishingHouse = builder.publishingHouse;
    this.totalPages = builder.totalPages;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getTitle() {
    return title;
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
    return "Book title" + title + ". Was published by " + publishingHouse + " and has " + totalPages + " pages.";
  }

  public Book cloneWithNewIsbn(String newIsbn) {
    try {
      Book copy = (Book) super.clone();
      copy.isbn = newIsbn;   // cada copia necesita su propio ISBN único
      copy.isLoaned = false; // una copia nueva siempre arranca disponible
      return copy;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError("Book should be cloneable", e);
    }

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

