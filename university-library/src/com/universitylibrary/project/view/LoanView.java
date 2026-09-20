package com.universitylibrary.project.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoanView {
  private final TextField isbnField = new TextField();
  private final TextField userIdField = new TextField();
  private final Button loanButton = new Button("Loan a book");
  private final Label messageLabel = new Label();

  private final VBox root;

  public LoanView() {
    root = new VBox(8,
        new Label("Book ISBN:"), isbnField,
        new Label("User ID:"), userIdField,
        loanButton, messageLabel
    );
    root.setPadding(new Insets(20));
  }

  public VBox getRoot() { return root; }
  public TextField getIsbnField() { return isbnField; }
  public TextField getUserIdField() { return userIdField; }
  public Button getLoanButton() { return loanButton; }
  public Label getMessageLabel() { return messageLabel; }
}
