package com.universitylibrary.project.exceptions;

public class BookNotFound extends LibraryException {
  public BookNotFound(String isbn) {
    super("The book with isbn " + isbn + " you searched for is not found");
  }
}
