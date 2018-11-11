import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.LinkedList;

public class MainScene extends Scene {

    final private Stage primaryStage;
    private Pane pane;
    private Button addBook;
    private Button deleteBook;
    private TextField searchRequest;
    private Button search;
    private ListView<Book> booksListRepresentation;
    private ObservableList<Book> booksList;
    private DatabaseInteract databaseInteract;
    private SortChoise sortChoise;

    MainScene(final Stage stage, final Pane constructorPane, final int sizeX, final int sizeY) {
        super(constructorPane, sizeX, sizeY);
        sortChoise = new SortChoise();
        primaryStage = stage;
        pane = constructorPane;
        addBook = new Button("+");
        deleteBook = new Button("-");
        search = new Button("Search");
        searchRequest = new TextField();
        databaseInteract = new DatabaseInteract();
        booksList = FXCollections.observableList(databaseInteract.getBooks());
        booksListRepresentation = new ListView<>(booksList);
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
    }

    private void sceneSetup() {
        addBook.relocate(400, 50);
        deleteBook.relocate(350, 50);
        search.relocate(400, 100);
        addBook.setMaxSize(50, 25);
        addBook.setMinWidth(50);
        deleteBook.setMaxSize(50, 25);
        deleteBook.setMinWidth(50);
        search.setMaxSize(75, 25);
        searchRequest.relocate(50, 100);
        searchRequest.setMaxSize(300, 25);
        searchRequest.setMinWidth(300);
        sortChoise.relocate(50, 150);
        booksListRepresentation.relocate(500, 50);
        booksListRepresentation.setMinSize(300, 450);
        pane.getChildren().addAll(addBook, deleteBook, search, searchRequest,
                booksListRepresentation, sortChoise);
    }

}
