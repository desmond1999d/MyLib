import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * This is the main class that preloads first scene
 */

public class Main extends Application {

    static final int sizeX = 800;
    static final int sizeY = 500;

    @Override
    public void start(final Stage primaryStage) throws Exception{
        primaryStage.setTitle("MyLib");
        primaryStage.setScene(new MainScene(primaryStage, new Pane(), sizeX, sizeY));

        primaryStage.setWidth(sizeX);
        primaryStage.setHeight(sizeY);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    /**
     * auto-generated method
     * @param args command line arguments
     */

    public static void main(final String[] args) {
        launch(args);
    }
}
