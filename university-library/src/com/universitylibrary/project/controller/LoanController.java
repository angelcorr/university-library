package com.universitylibrary.project.controller;

import com.universitylibrary.project.models.Loan;
import com.universitylibrary.project.services.LoanService;
import com.universitylibrary.project.view.LoanView;

public class LoanController {
  private final LoanView view;
  private final LoanService loanService;

  public LoanController(LoanView view, LoanService loanService) {
    this.view = view;
    this.loanService = loanService;
    attachEvents();
  }

  private void attachEvents() {
    view.getLoanButton().setOnAction(e -> handleLoan());
    view.getReturnButton().setOnAction(e -> handleReturn());
  }

  private void handleLoan() {
    try {
      Loan loan = loanService.loanBook(
          view.getIsbnField().getText(),
          view.getUserIdField().getText()
      );
      view.getMessageLabel().setText("Loan created: " + loan.toString());
      clearFields();
    } catch (Exception ex) {
      view.getMessageLabel().setText("Error: " + ex.getMessage());
    }
  }

  private void handleReturn() {
    try {
      loanService.returnBook(
          view.getIsbnField().getText(),
          view.getUserIdField().getText()
      );
      view.getMessageLabel().setText("Book returned successfully");
      clearFields();
    } catch (Exception ex) {
      view.getMessageLabel().setText("Error: " + ex.getMessage());
    }
  }

  private void clearFields() {
    view.getIsbnField().clear();
    view.getUserIdField().clear();
  }
}
