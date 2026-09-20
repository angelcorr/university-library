package com.universitylibrary.project;

import com.universitylibrary.project.models.Book;
import com.universitylibrary.project.models.Loan;
import com.universitylibrary.project.models.User;
import com.universitylibrary.project.services.LibraryManager;
import com.universitylibrary.project.services.LoanService;
import com.universitylibrary.project.services.UserManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
  private final LibraryManager manager = LibraryManager.getInstance();
  private final UserManager userManager = UserManager.getInstance();
  private final LoanService loanService = new LoanService(manager);

  @Override
  public void start(Stage stage) {
    TabPane tabPane = new TabPane();
    tabPane.getTabs().addAll(
        new Tab("Books", buildBookForm()),
        new Tab("Users", buildUserForm()),
        new Tab("Book loans", buildLoanForm())
    );
    tabPane.getTabs().forEach(tab -> tab.setClosable(false));

    stage.setScene(new Scene(tabPane, 450, 400));
    stage.setTitle("University Library");
    stage.show();
  }

  private VBox buildBookForm() {
    TextField isbnField = new TextField();
    TextField titleField = new TextField();
    TextField publisherField = new TextField();
    TextField pagesField = new TextField();
    Button addButton = new Button("Add book");
    Label messageLabel = new Label();

    addButton.setOnAction(e -> {
      try {
        int pages = Integer.parseInt(pagesField.getText());
        Book book = manager.addBook(
            isbnField.getText(),
            titleField.getText(),
            publisherField.getText(),
            pages
        );
        messageLabel.setText("Book added: " + book.getTitle());
        isbnField.clear();
        titleField.clear();
        publisherField.clear();
        pagesField.clear();
      } catch (NumberFormatException ex) {
        messageLabel.setText("Error: total pages must be a number");
      } catch (Exception ex) {
        messageLabel.setText("Error: " + ex.getMessage());
      }
    });

    VBox box = new VBox(8,
        new Label("ISBN:"), isbnField,
        new Label("Title:"), titleField,
        new Label("Publisher:"), publisherField,
        new Label("Total pages:"), pagesField,
        addButton, messageLabel
    );
    box.setPadding(new Insets(20));
    return box;
  }

  private VBox buildUserForm() {
    TextField idField = new TextField();
    TextField fullName = new TextField();
    TextField addressField = new TextField();
    TextField phoneField = new TextField();
    Button addButton = new Button("Add user");
    Label messageLabel = new Label();

    addButton.setOnAction(e -> {
      try {
        User user = userManager.addUser(
            idField.getText(),
            fullName.getText(),
            addressField.getText(),
            phoneField.getText()
        );
        messageLabel.setText("User added: " + user.getFullName());
        idField.clear();
        fullName.clear();
        addressField.clear();
        phoneField.clear();
      } catch (Exception ex) {
        messageLabel.setText("Error: " + ex.getMessage());
      }
    });

    VBox box = new VBox(8,
        new Label("ID:"), idField,
        new Label("Full Name:"), fullName,
        new Label("Address:"), addressField,
        new Label("Phone number:"), phoneField,
        addButton, messageLabel
    );
    box.setPadding(new Insets(20));
    return box;
  }

  private VBox buildLoanForm() {
    TextField isbnField = new TextField();
    TextField userIdField = new TextField();
    Button loanButton = new Button("Loan a book");
    Label messageLabel = new Label();

    loanButton.setOnAction(e -> {
      try {
        Loan loan = loanService.loanBook(isbnField.getText(), userIdField.getText());
        messageLabel.setText("Loan created: " + loan.toString());
        isbnField.clear();
        userIdField.clear();
      } catch (Exception ex) {
        messageLabel.setText("Error: " + ex.getMessage());
      }
    });

    VBox box = new VBox(8,
        new Label("Book ISBN:"), isbnField,
        new Label("User ID:"), userIdField,
        loanButton, messageLabel
    );
    box.setPadding(new Insets(20));
    return box;
  }

  public static void main(String args[]) {
    launch(args);
  }
}
