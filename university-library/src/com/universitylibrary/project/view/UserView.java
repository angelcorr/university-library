package com.universitylibrary.project.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class UserView {
  private final TextField idField = new TextField();
  private final TextField fullNameField = new TextField();
  private final TextField addressField = new TextField();
  private final TextField phoneField = new TextField();
  private final Button addButton = new Button("Add user");
  private final Label messageLabel = new Label();

  private final VBox root;

  public UserView() {
    root = new VBox(8,
        new Label("ID:"), idField,
        new Label("Full Name:"), fullNameField,
        new Label("Address:"), addressField,
        new Label("Phone number:"), phoneField,
        addButton, messageLabel
    );
    root.setPadding(new Insets(20));
  }

  public VBox getRoot() { return root; }
  public TextField getIdField() { return idField; }
  public TextField getFullNameField() { return fullNameField; }
  public TextField getAddressField() { return addressField; }
  public TextField getPhoneField() { return phoneField; }
  public Button getAddButton() { return addButton; }
  public Label getMessageLabel() { return messageLabel; }

}
