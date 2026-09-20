package com.universitylibrary.project.controller;

import com.universitylibrary.project.models.User;
import com.universitylibrary.project.services.UserManager;
import com.universitylibrary.project.view.UserView;

public class UserController {
  private final UserView view;
  private final UserManager userManager;

  public UserController(UserView view, UserManager userManager) {
    this.view = view;
    this.userManager = userManager;
    attachEvents();
  }

  private void attachEvents() {
    view.getAddButton().setOnAction(e -> handleAddUser());
  }

  private void handleAddUser() {
    try {
      User user = userManager.addUser(
          view.getIdField().getText(),
          view.getFullNameField().getText(),
          view.getAddressField().getText(),
          view.getPhoneField().getText()
      );
      view.getMessageLabel().setText("User added: " + user.getFullName());
      clearFields();
    } catch (Exception ex) {
      view.getMessageLabel().setText("Error: " + ex.getMessage());
    }
  }

  private void clearFields() {
    view.getIdField().clear();
    view.getFullNameField().clear();
    view.getAddressField().clear();
    view.getPhoneField().clear();
  }
}
