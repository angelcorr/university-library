package com.universitylibrary.project.exceptions;

import com.universitylibrary.project.models.Book;

public class BookNotFound extends LibraryException {
  public BookNotFound(Book book) {
    super("The book " + book.getTitle() + " you searched for is not found");
  }
}
