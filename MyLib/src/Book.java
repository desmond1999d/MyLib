import java.io.File;
import java.time.LocalDateTime;

public class Book {
    public File file;
    public String name;
    public String author;
    public Mood mood;
    public Genre genre;
    public int rate;
    public LocalDateTime creationTime;

    Book(File file, String name, String author, Mood mood, Genre genre, int rate) {
        this.file = file;
        this.name = name;
        this.author = author;
        this.mood = mood;
        this.genre = genre;
        this.rate = rate;
        creationTime = LocalDateTime.now();
    }
}
