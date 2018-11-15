import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class SortChoice extends Pane {

    private ComboBox<String> sortCategories;
    private ComboBox<String> sortCriterion;
    private List<SortChoiseInit> sortChoiceInits;
    private ListView<Book> booksListRepresentation;

    SortChoice(ListView<Book> booksListRepresentation) {
        super();
        this.booksListRepresentation = booksListRepresentation;
        sortCategories = new ComboBox<String>();
        sortCriterion = new ComboBox<String>();
        sceneSetup();
        createSortChoices();
        setActions();
        this.getChildren().addAll(sortCategories, sortCriterion);
    }

    private void setActions() {
        sortCategories.valueProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        for (int i = 0; i < sortChoiceInits.size(); i++) {
                            if (newValue.equals(sortChoiceInits.get(i).getCategory())) {
                                sortCriterion.setItems(FXCollections.observableList(sortChoiceInits.get(i).getCriterionValues()));
                            }
                        }
                    }
                }
        );
        sortCriterion.valueProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        try {
                            DatabaseInteract databaseInteract = new DatabaseInteract();
                            List<Book> books = databaseInteract.getBooks();
                            for (int i = 0; i < sortChoiceInits.size(); i++) {
                                if (sortCategories.getSelectionModel().getSelectedItem().equals(sortChoiceInits.get(i).getCategory())) {
                                    if (sortChoiceInits.get(i).getComparator() != null) {
                                        books.sort(sortChoiceInits.get(i).getComparator());
                                        if (newValue.equals(sortChoiceInits.get(i).getCriterionValues().get(1)))
                                            Collections.reverse(books);
                                    } else if (sortCategories.getSelectionModel().getSelectedItem().equals("Mood")) {
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
                        } catch (NullPointerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
        );
    }

    private void createSortChoices() {
        LinkedList<String> categories = new LinkedList<>();
        for (int i = 0; i < SortCategories.values().length; i++)
            categories.add(SortCategories.values()[i].toString());
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
                if (o1.getRate() < o2.getRate())
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
        sortChoiceInits = new LinkedList<>();
        sortChoiceInits.add(new SortChoiseInit(categories.get(0), nameComparator, byUpDownCriterion));
        sortChoiceInits.add(new SortChoiseInit(categories.get(1), null, byGenreCriterion));
        sortChoiceInits.add(new SortChoiseInit(categories.get(2), null, byMoodCriterion));
        sortChoiceInits.add(new SortChoiseInit(categories.get(3), rateComparator, byUpDownCriterion));
        sortChoiceInits.add(new SortChoiseInit(categories.get(4), dateComparator, byUpDownCriterion));
        sortCategories.setItems(FXCollections.observableList(categories));
    }

    private void sceneSetup() {
        sortCategories.setMaxSize(300, 25);
        sortCategories.setMinWidth(300);
        sortCriterion.setMaxSize(300, 25);
        sortCriterion.setMinWidth(300);
        sortCriterion.relocate(0, 50);
        sortCategories.setPromptText("Categories");
        sortCriterion.setPromptText("Criterion");
    }

}
