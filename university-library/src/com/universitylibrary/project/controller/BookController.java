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
    view.getCloneButton().setOnAction(e -> handleCloneBook());
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

  private void handleCloneBook() {
    try {
      Book original = manager.searchBookByIsbn(view.getCloneSourceIsbnField().getText());
      Book clone = original.cloneWithNewIsbn(view.getCloneNewIsbnField().getText());
      manager.addExistingBook(clone);
      view.getMessageLabel().setText("Cloned: " + clone.getTitle() + " (new ISBN: " + clone.getIsbn() + ")");
      view.getCloneSourceIsbnField().clear();
      view.getCloneNewIsbnField().clear();
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
