import java.io.File;
import java.sql.Time;
import java.time.LocalDateTime;
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

    public void setId(int id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
