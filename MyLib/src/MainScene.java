import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainScene extends Scene {

    final private Stage primaryStage;
    private Pane pane;
    private Button addBook;
private Button deleteBook;
    private ComboBox<String> sortCategories;
    private TextField searchRequest;
    private Button search;
    private ComboBox<String> sortCriterion;
    private ListView<Book> booksListRepresentation;
    private ObservableList<Book> booksList;

    MainScene(final Stage stage, final Pane constructorPane, final int sizeX, final int sizeY) {
        super(constructorPane, sizeX, sizeY);
        primaryStage = stage;
        pane = constructorPane;
        addBook = new Button("+");
        deleteBook = new Button("-");
        search = new Button("Search");
        searchRequest = new TextField();
        sortCategories = new ComboBox<>();
        sortCriterion = new ComboBox<>();
        booksList = FXCollections.observableArrayList();
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
        sortCategories.setMaxSize(300, 25);
        sortCategories.setMinWidth(300);
        sortCategories.relocate(50, 150);
        sortCriterion.setMaxSize(300, 25);
        sortCriterion.setMinWidth(300);
        sortCriterion.relocate(50, 200);
        booksListRepresentation.relocate(500, 50);
        booksListRepresentation.setMinSize(300, 450);
        pane.getChildren().addAll(addBook, deleteBook, search, searchRequest, sortCategories, sortCriterion, booksListRepresentation);
    }

}
