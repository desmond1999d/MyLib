import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

import java.util.LinkedList;

public class SortChoise extends Pane {

    private ComboBox<String> sortCategories;
    private ComboBox<String> sortCriterion;

    public SortChoise() {
        super();
        LinkedList<String> categories = new LinkedList<>();
        sortCategories = new ComboBox<String>();
        sortCriterion = new ComboBox<String>();
        sortCategories.setMaxSize(300, 25);
        sortCategories.setMinWidth(300);
        sortCriterion.setMaxSize(300, 25);
        sortCriterion.setMinWidth(300);
        sortCriterion.relocate(0, 50);
        categories.add("Alphabet");
        categories.add("Genre");
        categories.add("Mood");
        categories.add("Rate");
        categories.add("Date");
        sortCategories.setPromptText("Categories");
        sortCriterion.setPromptText("Criterion");
        sortCategories.setItems(FXCollections.observableList(categories));
        setActions();
        this.getChildren().addAll(sortCategories, sortCriterion);
    }

    public ComboBox<String> getSortCategories() {
        return sortCategories;
    }

    public ComboBox<String> getSortCriterion() {
        return sortCriterion;
    }

    private void setActions() {
        sortCategories.valueProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        LinkedList<String> criterions = new LinkedList<>();
                        switch (newValue) {
                            case "Alphabet":
                                criterions.add("Up");
                                criterions.add("Down");
                                sortCriterion.setItems(FXCollections.observableList(criterions));
                                break;
                            case "Genre":
                                for(int i = 0; i < Genre.values().length; i++)
                                    criterions.add(Genre.values()[i].toString());
                                sortCriterion.setItems(FXCollections.observableList(criterions));
                                break;
                            case "Mood":
                                for(int i = 0; i < Mood.values().length; i++)
                                    criterions.add(Mood.values()[i].toString());
                                sortCriterion.setItems(FXCollections.observableList(criterions));
                                break;
                            case "Rate":
                                criterions.add("Up");
                                criterions.add("Down");
                                sortCriterion.setItems(FXCollections.observableList(criterions));
                                break;
                            case "Date":
                                criterions.add("Up");
                                criterions.add("Down");
                                sortCriterion.setItems(FXCollections.observableList(criterions));
                                break;
                        }
                    }
                }
        );
    }

}
