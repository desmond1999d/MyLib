import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainScene extends Scene {

    private Pane pane;
    private Button addBook;
private Button deleteBook;
    private ComboBox<String> sortCategories;
    private TextField searchRequest;
    private Button search;
    private ComboBox<String> sortCriterion;
    private ListView<Book> booksListRepresentation;
    private ObservableList<Book> booksList;

    MainScene(final Pane constructorPane, final int sizeX, final int sizeY) {
        super(constructorPane, sizeX, sizeY);
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
        pane.getChildren().addAll(addBook, deleteBook, search, searchRequest, sortCategories, sortCriterion, booksListRepresentation);
    }

}
