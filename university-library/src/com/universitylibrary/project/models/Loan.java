package com.universitylibrary.project.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Loan {
  private final Book book;
  private final UUID userId;
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

  public String getBookName() {
    return book.getName();
  }

  public UUID getUserId() {
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

  public static class Builder {
    private Book book;
    private UUID userId;
    private LocalDate loanDate;
    private LocalDate limitDate;
    private LocalDate returnDate;

    public Builder book(Book book) {
      this.book = book;
      return this;
    }

    public Builder userId(UUID userId) {
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
      return new Loan(this);
    }
  }
}
