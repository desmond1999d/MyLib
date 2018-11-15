import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.text.Collator;
import java.util.LinkedList;
import java.util.List;

class SearchBar extends Pane {

    private TextField searchRequest;
    private Button searchButton;
    private ListView<Book> booksListRepresentation;

    SearchBar(ListView<Book> booksListRepresentation) {
        super();
        this.booksListRepresentation = booksListRepresentation;
        searchRequest = new TextField();
        searchButton = new Button("Search");
        paneSetup();
        setActions();
    }

    private void setActions() {
        searchButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        booksListRepresentation.setItems(search(searchRequest.getText()));
                    }
                }
        );
    }

    private ObservableList<Book> search(String request) {
        DatabaseInteract databaseInteract = new DatabaseInteract();
        List<Book> books = databaseInteract.getBooks();
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            if (Collator.getInstance().compare(books.get(i).getName(), request) == 0 ||
                    Collator.getInstance().compare(books.get(i).getAuthor(), request) == 0) {
                result.add(books.get(i));
            }
        }
        return FXCollections.observableList(result);
    }

    private void paneSetup() {
        searchRequest.setMaxSize(300, 25);
        searchRequest.setMinWidth(300);
        searchButton.relocate(360, 0);
        this.getChildren().addAll(searchRequest, searchButton);
    }

}
