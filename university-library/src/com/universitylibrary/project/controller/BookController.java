package com.universitylibrary.project.controller;

import com.universitylibrary.project.models.Book;
import com.universitylibrary.project.services.LibraryManager;
import com.universitylibrary.project.view.BookView;

public class BookController {
  private final BookView view;
  private final LibraryManager manager;

  public BookController(BookView view, LibraryManager manager) {
    this.view = view;
    this.manager = manager;
    attachEvents();
  }

  private void attachEvents() {
    view.getAddButton().setOnAction(e -> handleAddBook());
  }

  private void handleAddBook() {
    try {
      int pages = Integer.parseInt(view.getPagesField().getText());
      Book book = manager.addBook(
          view.getIsbnField().getText(),
          view.getTitleField().getText(),
          view.getPublisherField().getText(),
          pages
      );
      view.getMessageLabel().setText("Book added: " + book.getTitle());
      clearFields();
    } catch (NumberFormatException ex) {
      view.getMessageLabel().setText("Error: total pages must be a number");
    } catch (Exception ex) {
      view.getMessageLabel().setText("Error: " + ex.getMessage());
    }
  }

  private void clearFields() {
    view.getIsbnField().clear();
    view.getTitleField().clear();
    view.getPublisherField().clear();
    view.getPagesField().clear();
  }
}
