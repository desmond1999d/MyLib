import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class MainScene extends Scene {

    final private Stage primaryStage;
    private Pane pane;
    private Button addBook;
    private Button deleteBook;
    private SearchBar searchBar;
    private ListView<Book> booksListRepresentation;
    private ObservableList<Book> booksList;
    private DatabaseInteract databaseInteract;
    private SortChoise sortChoise;

    MainScene(final Stage stage, final Pane constructorPane, final int sizeX, final int sizeY) {
        super(constructorPane, sizeX, sizeY);
        primaryStage = stage;
        pane = constructorPane;
        addBook = new Button("+");
        deleteBook = new Button("-");
        databaseInteract = new DatabaseInteract();
        booksList = FXCollections.observableList(databaseInteract.getBooks());
        booksListRepresentation = new ListView<>(booksList);
        sortChoise = new SortChoise(booksListRepresentation);
        searchBar = new SearchBar(booksListRepresentation);
        sceneSetup();
        setActions();
    }

    private void setActions() {
        addBook.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(new AddBookScene(primaryStage, new Pane(), 800, 600));
                    }
                }
        );
        deleteBook.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        databaseInteract.deleteBook(booksListRepresentation.getSelectionModel().getSelectedItem());
                        booksListRepresentation.getItems().remove(booksListRepresentation.getSelectionModel().getSelectedItem());
                    }
                }
        );
        booksListRepresentation.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
                            Book currentItemSelected = booksListRepresentation.getSelectionModel()
                                    .getSelectedItem();
                            try {
                                if (currentItemSelected.getFile().exists()) {
                                    Desktop.getDesktop().open(currentItemSelected.getFile());
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Error");
                                    alert.setHeaderText("File not found");
                                    alert.setContentText(currentItemSelected.getFile() + " doesn't exist.");
                                    alert.showAndWait();
                                }
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
        );
    }

    private void sceneSetup() {
        addBook.relocate(400, 50);
        deleteBook.relocate(350, 50);
        searchBar.relocate(50, 100);
        addBook.setMaxSize(50, 25);
        addBook.setMinWidth(50);
        deleteBook.setMaxSize(50, 25);
        deleteBook.setMinWidth(50);
        sortChoise.relocate(50, 150);
        booksListRepresentation.relocate(500, 50);
        booksListRepresentation.setMinSize(300, 450);
        pane.getChildren().addAll(addBook, deleteBook, searchBar,
                booksListRepresentation, sortChoise);
    }

}
