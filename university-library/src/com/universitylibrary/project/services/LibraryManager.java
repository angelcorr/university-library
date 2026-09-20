package com.universitylibrary.project.services;

import com.universitylibrary.project.exceptions.BookNotFound;
import com.universitylibrary.project.models.Book;
import com.universitylibrary.project.models.Library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryManager {
  private static LibraryManager instance;
  private final Library library;
  private final List<Book> booksInStock;

  private LibraryManager() {
    this.booksInStock = new ArrayList<>();
    this.library = new Library.Builder()
        .name("Libreria Floricienta")
        .address("Calle 1N #2-30")
        .penaltyPercentage(40.000)
        .build();
  }

  public static synchronized LibraryManager getInstance() {
    if (instance == null) {
      instance = new LibraryManager();
    }
    return instance;
  }

  public Library getLibrary() {
    return library;
  }
  public void addBook(Book book) {
    booksInStock.add(book);
  }

  public List<Book> getBooksInStock() {
    return Collections.unmodifiableList(booksInStock);
  }

  public Book searchBookByName(String name) {
    Book searchedBook = null;

    for (Book book: booksInStock) {
      if (book.getName().equals(name)) {
        searchedBook = book;
      } else {
        throw new BookNotFound(book);
      }
    }

    return searchedBook;
  }

  public Book searchBookByIsbn(String isbn) {
    Book searchedBookByIsbn = null;

    for (Book book: booksInStock) {
      if (book.getIsbn().equals(isbn)) {
        searchedBookByIsbn = book;
      } else {
        throw new BookNotFound(book);
      }
    }

    return searchedBookByIsbn;
  }
}
