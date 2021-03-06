import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Star extends ImageView {
    final int viewPortXEmpty = 378;
    final int viewPortXFull = 70;
    final int viewPortY = 223;
    static final int width = 65;
    static final int height = 60;

    Star() {
        super(new Image("star.png"));
        setViewport(new Rectangle2D(viewPortXEmpty, viewPortY, width, height));
    }

    void choose() {
        setViewport(new Rectangle2D(viewPortXFull, viewPortY, width, height));
    }

    void empty() {
        setViewport(new Rectangle2D(viewPortXEmpty, viewPortY, width, height));
    }
}
