package com.universitylibrary.project;

import com.universitylibrary.project.controller.BookController;
import com.universitylibrary.project.controller.LoanController;
import com.universitylibrary.project.controller.UserController;
import com.universitylibrary.project.services.LibraryManager;
import com.universitylibrary.project.services.LoanService;
import com.universitylibrary.project.services.UserManager;
import com.universitylibrary.project.view.BookView;
import com.universitylibrary.project.view.LoanView;
import com.universitylibrary.project.view.UserView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Main extends Application {
  private final LibraryManager manager = LibraryManager.getInstance();
  private final UserManager userManager = UserManager.getInstance();
  private final LoanService loanService = new LoanService(manager);

  @Override
  public void start(Stage stage) {
    BookView bookView = new BookView();
    new BookController(bookView, manager);

    UserView userView = new UserView();
    new UserController(userView, userManager);

    LoanView loanView = new LoanView();
    new LoanController(loanView, loanService);

    TabPane tabPane = new TabPane();
    tabPane.getTabs().addAll(
        new Tab("Books", bookView.getRoot()),
        new Tab("Users", userView.getRoot()),
        new Tab("Book loans", loanView.getRoot())
    );
    tabPane.getTabs().forEach(tab -> tab.setClosable(false));

    stage.setScene(new Scene(tabPane, 450, 400));
    stage.setTitle("University Library");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
