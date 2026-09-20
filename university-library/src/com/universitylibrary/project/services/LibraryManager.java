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
  private final List<Book> booksInStock = new ArrayList<>();

  private LibraryManager() {
    this.library = new Library.Builder()
        .name("Libreria Floricienta")
        .address("Calle 1N #2-30")
        .penaltyPercentage(40.000)
        .schedule("From 8am to 6pm")
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

  public Book addBook(String isbn, String name, String publishingHouse, Integer totalPages) {
    Book book = new Book.Builder()
        .isbn(isbn)
        .name(name)
        .publishingHouse(publishingHouse)
        .totalPages(totalPages)
        .build();

    booksInStock.add(book);
    return book;
  }


  public List<Book> getBooksInStock() {
    return Collections.unmodifiableList(booksInStock);
  }

  public Book searchBookByName(String name) {
    Book searchedBook = null;

    for (Book book: booksInStock) {
      if (book.getTitle().equals(name)) {
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
