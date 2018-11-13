import java.io.File;
import java.sql.Time;
import java.util.Date;

public class Book {
    private int id;
    private File file;
    private String name;
    private String author;
    private Mood mood;
    private Genre genre;
    private int rate;
    private Date creationTime;

    Book(int id, File file, String name, String author, Mood mood, Genre genre, int rate) {
        this.id = id;
        this.file = file;
        this.name = name;
        this.author = author;
        this.mood = mood;
        this.genre = genre;
        this.rate = rate;
        creationTime = new Date();
    }

    Book(int id, File file, String name, String author, Mood mood, Genre genre, int rate, Time datetime) {
        this.id = id;
        this.file = file;
        this.name = name;
        this.author = author;
        this.mood = mood;
        this.genre = genre;
        this.rate = rate;
        creationTime = new Date();
    }

    @Override
    public String toString() {
        return name + ", " + author;
    }

    public int getId() {
        return id;
    }

    public File getFile() {
        return file;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Mood getMood() {
        return mood;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getRate() {
        return rate;
    }

    public Date getCreationTime() {
        return creationTime;
    }
}
