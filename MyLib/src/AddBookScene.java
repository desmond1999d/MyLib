import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.File;

public class AddBookScene extends Scene {

    private Pane pane;
    private Stage primaryStage;
    private Label fileLabel;
    private Label nameLabel;
    private Label authorLabel;
    private Label genreLabel;
    private Label moodLabel;
    private Label rateLabel;
    private Label addLabel;
    private Button addButton;
    private Button backToMainScene;
    private Button chooseFile;
    private TextField name;
    private TextField author;
    private ComboBox<String> moods;
    private ComboBox<String> genres;
    final StarRating starRating = new StarRating(150, 300);
    final FileChooser fileChooser = new FileChooser();
    private File file;

    AddBookScene(final Stage stage, final Pane constructorPane, int sizeX, int sizeY) {
        super(constructorPane, sizeX, sizeY);
        primaryStage = stage;
        pane = constructorPane;
        fileLabel = new Label("File");
        nameLabel = new Label("Name");
        authorLabel = new Label("Author");
        genreLabel = new Label("Genre");
        moodLabel = new Label("Mood");
        rateLabel = new Label("Rate");
        addLabel = new Label("Add");
        addButton = new Button("+");
        backToMainScene = new Button("<-");
        chooseFile = new Button("Choose file");
        name = new TextField();
        author = new TextField();
        moods = new ComboBox<>();
        genres = new ComboBox<>();
        sceneSetup();
        setActions();
    }

    private void setActions() {
        chooseFile.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        file = fileChooser.showOpenDialog(primaryStage);
                    }
                });
        backToMainScene.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(new MainScene(primaryStage, new Pane(), 800, 500));
                    }
                }
        );
    }

        private void sceneSetup () {

            backToMainScene.relocate(0, 0);
            fileLabel.relocate(50, 50);
            chooseFile.relocate(150, 50);
            nameLabel.relocate(50, 100);
            authorLabel.relocate(50, 150);
            genreLabel.relocate(50, 200);
            moodLabel.relocate(50, 250);
            rateLabel.relocate(50, 300);
            name.relocate(150, 100);
            name.setMinWidth(600);
            author.setMinWidth(600);
            genres.setMinWidth(600);
            moods.setMinWidth(600);
            author.relocate(150, 150);
            genres.relocate(150, 200);
            moods.relocate(150, 250);
            addLabel.relocate(650, 400);
            addButton.relocate(700, 400);

            pane.getChildren().addAll(fileLabel, nameLabel, genreLabel, moodLabel, rateLabel, name,
                    addLabel, addButton, backToMainScene, author, moods, genres, authorLabel, chooseFile, starRating);
        }

    }
