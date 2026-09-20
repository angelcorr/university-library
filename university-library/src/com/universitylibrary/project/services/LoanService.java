package com.universitylibrary.project.services;

import com.universitylibrary.project.exceptions.BookNotFound;
import com.universitylibrary.project.models.Book;
import com.universitylibrary.project.models.Loan;

import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class LoanService {
  private final LibraryManager manager;
  private final List<Loan> activeLoans = new ArrayList<>();

  public LoanService(LibraryManager manager) {
    this.manager = manager;
  }

  public Loan loanBook(String isbn, String userId) {
    Book book = manager.searchBookByIsbn(isbn);

    if (!book.isLoaned()) {
      throw new BookNotFound(book);
    }

    book.setLoanedStatus(true);

    Loan loan = new Loan.Builder()
        .book(book)
        .userId(userId)
        .loanDate(LocalDate.now())
        .returnDate(LocalDate.now().plusDays(20))
        .build();

    activeLoans.add(loan);
    return loan;
  }

  public void returnBook(String isbn, String userId) {
    Loan loan = searchActiveLoan(isbn, userId).orElseThrow(() -> new IllegalStateException("There is non active loan for this book and user"));

    loan.registerReturnDate(LocalDate.now());
    loan.getBook().setLoanedStatus(false);
    activeLoans.remove(loan);
  }

  public List<Loan> listExpiredLoans() {
    LocalDate today = LocalDate.now();
    return activeLoans.stream()
        .filter(loan -> loan.expiredReturnDate(today))
        .toList();
  }

  private java.util.Optional<Loan> searchActiveLoan(String isbn, String userId) {
    return activeLoans.stream()
        .filter(loan -> loan.getBook().getIsbn().equals(isbn) && loan.getUserId().equals(userId))
        .findFirst();
  }
}
