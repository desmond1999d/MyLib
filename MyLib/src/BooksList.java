import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class BooksList {

    private LinkedList<Book> books;

    public BooksList(LinkedList<Book> books) {
        DatabaseInteract databaseInteract = new DatabaseInteract();
        books = new LinkedList<>();
        books = databaseInteract.getBooks();
    }

    public ObservableList<Book> search(String request) {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            if (Collator.getInstance().compare(books.get(i).getName(), request) == 0 ||
                    Collator.getInstance().compare(books.get(i).getAuthor(), request) == 0) {
                result.add(books.get(i));
            }
        }
        return FXCollections.observableList(result);
    }

    public ObservableList<Book> getByMood(Mood mood) {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getMood() == mood) {
                result.add(books.get(i));
            }
        }
        return FXCollections.observableList(result);
    }

    public ObservableList<Book> getByGenre(Genre genre) {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getGenre() == genre) {
                result.add(books.get(i));
            }
        }
        return FXCollections.observableList(result);
    }

    public ObservableList<Book> sortByRate() {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getRate() > o2.getRate())
                    return 1;
                else if (o1.getRate() == o2.getRate())
                    return 0;
                else
                    return -1;
            }
        });
        return FXCollections.observableList(books);
    }

    public ObservableList<Book> sortByDate() {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getCreationTime().before(o2.getCreationTime()))
                    return 1;
                else if (o1.getCreationTime().after(o2.getCreationTime()))
                    return -1;
                else
                    return 0;
            }
        });
        return FXCollections.observableList(books);
    }

    public ObservableList<Book> sortByName() {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Collator.getInstance().compare(o1.getName(), o2.getName());
            }
        });
        return FXCollections.observableList(books);
    }

    public ObservableList<Book> sortByAuthor() {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Collator.getInstance().compare(o1.getAuthor(), o2.getAuthor());
            }
        });
        return FXCollections.observableList(books);
    }

}
