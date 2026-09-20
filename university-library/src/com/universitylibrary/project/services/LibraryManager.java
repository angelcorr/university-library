package com.universitylibrary.project.services;

import com.universitylibrary.project.exceptions.BookNotFound;
import com.universitylibrary.project.models.Book;
import com.universitylibrary.project.models.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

  public void addExistingBook(Book book) {
    verifyIfBookExists(book.getIsbn());
    booksInStock.add(book);
  }

  public void verifyIfBookExists(String isbn) {
    if (findByIsbn(isbn).isPresent()) {
      throw new IllegalStateException("A book with this ISBN already exists: " + isbn);
    }
  }

  public Book searchBookByIsbn(String isbn) {
    return findByIsbn(isbn).orElseThrow(() -> new BookNotFound(isbn));
  }

  private Optional<Book> findByIsbn(String isbn) {
    return booksInStock.stream()
        .filter(book -> book.getIsbn().equals(isbn))
        .findFirst();
  }
}
