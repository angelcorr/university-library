package com.universitylibrary.project.exceptions;

public class BookAlreadyLoaned extends LibraryException {
  public BookAlreadyLoaned(String isbn) {
    super("The book with isbn " + isbn + " is already loaned and not available");
  }
}
