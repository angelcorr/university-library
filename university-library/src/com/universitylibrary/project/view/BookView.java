package com.universitylibrary.project.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BookView {
  private final TextField isbnField = new TextField();
  private final TextField titleField = new TextField();
  private final TextField publisherField = new TextField();
  private final TextField pagesField = new TextField();
  private final Button addButton = new Button("Add book");

  private final TextField cloneSourceIsbnField = new TextField();
  private final TextField cloneNewIsbnField = new TextField();
  private final Button cloneButton = new Button("Clone book");

  private final Label messageLabel = new Label();

  private final VBox root;

  public BookView() {
    root = new VBox(8,
        new Label("ISBN:"), isbnField,
        new Label("Title:"), titleField,
        new Label("Publisher:"), publisherField,
        new Label("Total pages:"), pagesField,
        addButton,
        new Label("Clone an existing book!"),
        new Label("Existing ISBN:"), cloneSourceIsbnField,
        new Label("New ISBN:"), cloneNewIsbnField,
        cloneButton,
        messageLabel
    );
    root.setPadding(new Insets(20));
  }

  public VBox getRoot() { return root; }
  public TextField getIsbnField() { return isbnField; }
  public TextField getTitleField() { return titleField; }
  public TextField getPublisherField() { return publisherField; }
  public TextField getPagesField() { return pagesField; }
  public Button getAddButton() { return addButton; }
  public TextField getCloneSourceIsbnField() { return cloneSourceIsbnField; }
  public TextField getCloneNewIsbnField() { return cloneNewIsbnField; }
  public Button getCloneButton() { return cloneButton; }
  public Label getMessageLabel() { return messageLabel; }
}
