import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;

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
    private ComboBox<Mood> moods;
    private ComboBox<Genre> genres;
    final StarRating starRating = new StarRating(150, 300);
    final FileChooser fileChooser = new FileChooser();
    private File file;
    private DatabaseInteract databaseInteract;

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
        databaseInteract = new DatabaseInteract();
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
                        primaryStage.setScene(new MainScene(primaryStage, new Pane(), Main.sizeX, Main.sizeY));
                    }
                }
        );
        addButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            databaseInteract.insertBook(buildTheBook());
                            Pane pane1 = new Pane();
                            MainScene mainScene = null;
                            mainScene = new MainScene(primaryStage, pane1, Main.sizeX, Main.sizeY);
                            int i = 0;
                            primaryStage.setScene(mainScene);
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

    private void sceneSetup() {

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
        ObservableList<Mood> moodsValues = FXCollections.observableArrayList(Arrays.asList(Mood.values()));
        moods.setItems(moodsValues);
        ObservableList<Genre> genresValues = FXCollections.observableArrayList(Arrays.asList(Genre.values()));
        genres.setItems(genresValues);
        genres.getSelectionModel().select(0);
        moods.getSelectionModel().select(0);
        pane.getChildren().addAll(fileLabel, nameLabel, genreLabel, moodLabel, rateLabel, name,
                addLabel, addButton, backToMainScene, author, moods, genres, authorLabel, chooseFile, starRating);
    }


    private Book buildTheBook() {

        if (name.getText().isEmpty()) {
            return null;
        }
        if (author.getText().isEmpty()) {
            return null;
        }
        if (file == null) {
            return null;
        }
        Book book = new Book(0, file, name.getText(), author.getText(), moods.getValue(), genres.getValue(), starRating.getRate());
        return book;
    }
}
