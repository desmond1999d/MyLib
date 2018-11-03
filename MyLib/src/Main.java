import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * This is the main class that preloads first scene
 */

public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception{
        primaryStage.setTitle("MyLib");
        primaryStage.setScene(new MainScene(new Pane(), 1000, 800));

        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    /**
     * auto-generted method
     * @param args command line arguments
     */

    public static void main(final String[] args) {
        launch(args);
    }
}
