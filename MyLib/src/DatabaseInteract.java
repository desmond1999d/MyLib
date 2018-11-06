import javafx.scene.control.ListView;

import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

public class DatabaseInteract {

    private static final String URL = "jdbc:mysql://localhost:3306/mylib";
    private static final String username = "root";
    private static final String password = "root";
    private Connection connection;

    public DatabaseInteract() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } //catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public LinkedList<Book> getBooks() {
        Book book = null;
        LinkedList<Book> books = new LinkedList<Book>();
        try {
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT * FROM books");
            while (result.next()) {
                String name = result.getString("name");
                String author = result.getString("author");
                int genre = result.getInt("genre");
                int mood = result.getInt("mood");
                int rate = result.getInt("rate");
                Time dateTime = result.getTime("time");
                String filePath = result.getString("filepath");
                File file = new File(filePath);
                book = new Book(file, name, author, Mood.values()[mood], Genre.values()[genre], rate, dateTime);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void insertBook(Book book) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO books(name, author, genre, mood, rate, time, filepath) values(?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, book.name);
            preparedStatement.setString(2, book.author);
            preparedStatement.setInt(3, book.genre.ordinal());
            preparedStatement.setInt(4, book.mood.ordinal());
            preparedStatement.setInt(5, book.rate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = sdf.format(book.creationTime);
            preparedStatement.setString(6, time);
            preparedStatement.setString(7, book.file.getAbsolutePath());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
