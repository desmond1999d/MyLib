import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AddBookScene extends Scene {

    private Label fileLabel;
    private Label nameLabel;
    private Label authorLabel;
    private Label genreLabel;
    private Label moodLabel;
    private Label rateLabel;
    private Label addLabel;
    private Button addButton;
    private Button backToMainScene;
    private TextField name;
    private TextField author;
    private ComboBox<String> moods;
    private ComboBox<String> genres;

    AddBookScene(final Pane constructorPane) {
        super(constructorPane);
        fileLabel = new Label("File");
        nameLabel = new Label("Name");
        authorLabel = new Label("Author");
        genreLabel = new Label("Genre");
        moodLabel = new Label("Mood");
        rateLabel = new Label("Rate");
        addLabel = new Label("Add");
        addButton = new Button("+");
        backToMainScene = new Button("<-");
        name = new TextField();
        author = new TextField();
        moods = new ComboBox<>();
        genres = new ComboBox<>();
    }

    private void sceneSetup() {

    }

}
