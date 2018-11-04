import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Star extends ImageView {
    final int viewPortXEmpty = 378;
    final int viewPortXFull = 70;
    final int viewPortY = 223;
    final int width = 65;
    final int height = 60;

    Star() {
        super(new Image("star.png"));
        setViewport(new Rectangle2D(viewPortXEmpty, viewPortY, width, height));
    }

    public void choose() {
        setViewport(new Rectangle2D(viewPortXFull, viewPortY, width, height));
    }

    public void empty() {
        setViewport(new Rectangle2D(viewPortXEmpty, viewPortY, width, height));
    }

    public int getWidth() {
        return width;
    }
}
