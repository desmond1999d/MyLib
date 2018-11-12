import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.text.Collator;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortChoise extends Pane {

    private ComboBox<String> sortCategories;
    private ComboBox<String> sortCriterion;
    private List<SortChoiseInit> sortChoiseInits;
    private ListView<Book> booksListRepresentation;

    public SortChoise(ListView<Book> booksListRepresentation) {
        super();
        this.booksListRepresentation = booksListRepresentation;
        sortCategories = new ComboBox<String>();
        sortCriterion = new ComboBox<String>();
        sortCategories.setMaxSize(300, 25);
        sortCategories.setMinWidth(300);
        sortCriterion.setMaxSize(300, 25);
        sortCriterion.setMinWidth(300);
        sortCriterion.relocate(0, 50);
        LinkedList<String> categories = new LinkedList<>();
        categories.add("Alphabet");
        categories.add("Genre");
        categories.add("Mood");
        categories.add("Rate");
        categories.add("Date");
        List<String> byUpDownCriterion = new LinkedList<>();
        List<String> byMoodCriterion = new LinkedList<>();
        List<String> byGenreCriterion = new LinkedList<>();
        byUpDownCriterion.add("Up");
        byUpDownCriterion.add("Down");
        for (int i = 0; i < Mood.values().length; i++)
            byMoodCriterion.add(Mood.values()[i].toString());
        for (int i = 0; i < Genre.values().length; i++)
            byGenreCriterion.add(Genre.values()[i].toString());
        Comparator<Book> nameComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Collator.getInstance().compare(o1.getName(), o2.getName());
            }
        };
        Comparator<Book> rateComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getRate() > o2.getRate())
                    return 1;
                else if (o1.getRate() == o2.getRate())
                    return 0;
                else
                    return -1;
            }
        };
        Comparator<Book> dateComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getCreationTime().before(o2.getCreationTime()))
                    return 1;
                else if (o1.getCreationTime().after(o2.getCreationTime()))
                    return -1;
                else
                    return 0;
            }
        };
        sortChoiseInits = new LinkedList<>();
        sortChoiseInits.add(new SortChoiseInit(categories.get(0), nameComparator, byUpDownCriterion));
        sortChoiseInits.add(new SortChoiseInit(categories.get(1), null, byGenreCriterion));
        sortChoiseInits.add(new SortChoiseInit(categories.get(2), null, byMoodCriterion));
        sortChoiseInits.add(new SortChoiseInit(categories.get(3), rateComparator, byUpDownCriterion));
        sortChoiseInits.add(new SortChoiseInit(categories.get(4), dateComparator, byUpDownCriterion));
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
                        for (int i = 0; i < sortChoiseInits.size(); i++) {
                            if (newValue.equals(sortChoiseInits.get(i).getCategory())) {
                                sortCriterion.setItems(FXCollections.observableList(sortChoiseInits.get(i).getCriterionValues()));
                            }
                        }
                    }
                }
        );
        sortCriterion.valueProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        DatabaseInteract databaseInteract = new DatabaseInteract();
                        List<Book> books = databaseInteract.getBooks();
                        for (int i = 0; i < sortChoiseInits.size(); i++) {
                            if (sortCategories.getSelectionModel().getSelectedItem().equals(sortChoiseInits.get(i).getCategory())) {
                                if (sortChoiseInits.get(i).getComparator() != null) {
                                    books.sort(sortChoiseInits.get(i).getComparator());
                                } else if(sortCategories.getSelectionModel().getSelectedItem().equals("Mood")) {
                                    LinkedList<Book> result = new LinkedList<>();
                                    for (int j = 0; j < books.size(); j++) {
                                        if (books.get(j).getMood().toString().equals(newValue)) {
                                            result.add(books.get(j));
                                        }
                                    }
                                    books = result;
                                } else if (sortCategories.getSelectionModel().getSelectedItem().equals("Genre")) {
                                    LinkedList<Book> result = new LinkedList<>();
                                    for (int j = 0; j < books.size(); j++) {
                                        if (books.get(j).getGenre().toString().equals(newValue)) {
                                            result.add(books.get(j));
                                        }
                                    }
                                    books = result;
                                }
                            }
                        }
                        booksListRepresentation.setItems(FXCollections.observableList(books));
                    }
                }
        );
    }

}
