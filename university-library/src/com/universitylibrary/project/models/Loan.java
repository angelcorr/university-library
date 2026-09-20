package com.universitylibrary.project.models;

import java.time.LocalDate;

public class Loan {
  private final Book book;
  private final String userId;
  private final LocalDate loanDate;
  private final LocalDate limitDate;
  private LocalDate returnDate;

  private Loan(Builder builder) {
    this.book = builder.book;
    this.userId = builder.userId;
    this.loanDate = builder.loanDate;
    this.limitDate = builder.limitDate;
    this.returnDate = builder.returnDate;
  }

  public void registerReturnDate(LocalDate date) {
    this.returnDate = date;
  }

  public boolean expiredReturnDate(LocalDate date) {
    return returnDate == null && date.isAfter(limitDate);
  }

  public Book getBook() {
    return book;
  }

  public String getBookName() {
    return book.getTitle();
  }

  public String getUserId() {
    return userId;
  }

  public LocalDate getLoanDate() {
    return loanDate;
  }

  public LocalDate getLimitDate() {
    return limitDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  @Override
  public String toString() {
    return "Book loaned: " + getBookName() + ", and was loaned by user: " + getUserId();
  }

  public static class Builder {
    private Book book;
    private String userId;
    private LocalDate loanDate;
    private LocalDate limitDate;
    private LocalDate returnDate;

    public Builder book(Book book) {
      this.book = book;
      return this;
    }

    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }

    public Builder loanDate(LocalDate loanDate) {
      this.loanDate = loanDate;
      return this;
    }

    public Builder returnDate(LocalDate returnDate) {
      this.returnDate = returnDate;
      return this;
    }

    public Loan build() {
      if (book == null || userId == null) {
        throw new IllegalStateException("Book and user are mandatory");
      }

      return new Loan(this);
    }
  }
}
