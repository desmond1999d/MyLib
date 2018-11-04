import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class StarRating extends Pane {

    private Star[] stars;
    private int rate;
    final int gape = 10;
    final int starsNum = 5;

    StarRating(int baseX, int baseY) {
        super();
        rate = 0;
        resize(Star.width*starsNum + (starsNum-1)*gape, Star.height);
        relocate(baseX, baseY);
        stars = new Star[starsNum];
        int xPos = 0;
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
            stars[i].relocate(xPos, 0);
            xPos += Star.width + gape;
        }
        EventHandler<MouseEvent> mouseEnteredEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int indx = 0;
                for (int i = 0; i < stars.length; i++) {
                    if (stars[i] == event.getSource())
                        indx = i;
                }
                for (int i = 0; i <= indx; i++) {
                    stars[i].choose();
                }
            }
        };

        EventHandler<MouseEvent> mouseExitedEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (int i = 0; i < stars.length; i++)
                    stars[i].empty();
            }
        };

        EventHandler<MouseEvent> mouseClickEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int indx = 0;
                for (int i = 0; i < stars.length; i++) {
                    if (stars[i] == event.getSource())
                        indx = i;
                }
                indx++;
                for (int i = 0; i < indx; i++) {
                    stars[i].choose();
                }
                for (int i = 0; i < stars.length; i++) {
                    stars[i].setOnMouseExited(null);
                    stars[i].setOnMouseEntered(null);
                }
                rate = indx;
            }
        };

        for (int i = 0; i < stars.length; i++) {
            stars[i].setOnMouseEntered(mouseEnteredEventHandler);
            stars[i].setOnMouseExited(mouseExitedEventHandler);
            stars[i].setOnMouseClicked(mouseClickEventHandler);
        }

        getChildren().addAll(stars);
    }

    public int getRate() {
        return rate;
    }

}
