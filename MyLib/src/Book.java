import java.io.File;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class Book {
    public File file;
    public String name;
    public String author;
    public Mood mood;
    public Genre genre;
    public int rate;
    public Date creationTime;

    Book(File file, String name, String author, Mood mood, Genre genre, int rate) {
        this.file = file;
        this.name = name;
        this.author = author;
        this.mood = mood;
        this.genre = genre;
        this.rate = rate;
        creationTime = new Date();
    }

    Book(File file, String name, String author, Mood mood, Genre genre, int rate, Time datetime) {
        this.file = file;
        this.name = name;
        this.author = author;
        this.mood = mood;
        this.genre = genre;
        this.rate = rate;
        creationTime = new Date();
    }
}
