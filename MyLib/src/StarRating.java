import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class StarRating extends Pane {

    private Star[] stars;
    private int rate;

    StarRating(int baseX, int baseY) {
        super();
        stars = new Star[5];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
            stars[i].relocate(baseX, baseY);
            baseX += stars[i].getWidth() + 10;
        }
        EventHandler<MouseEvent> mouseEnteredEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int indx = 0;
                for (int i = 0; i < stars.length; i++) {
                    if(stars[i] == event.getSource())
                        indx = i;
                }
                for(int i = 0; i <= indx; i++) {
                    stars[i].choose();
                }
            }
        };

        EventHandler<MouseEvent> mouseExitedEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for(int i = 0; i < stars.length; i++)
                    stars[i].empty();
            }
        };

        EventHandler<MouseEvent> mouseClickEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int indx = 0;
                for (int i = 0; i < stars.length; i++) {
                    if(stars[i] == event.getSource())
                        indx = i;
                }
                indx++;
                for(int i = 0; i < indx; i++) {
                    stars[i].choose();
                }
                for(int i = 0; i < stars.length; i++) {
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
