package bookup;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;

/** Provides helper methods for interacting with the database */
public class SQLHelper {

    /** Adds specified book to database */
    public static void add(Book book) {
        try {
            Connection con = connect();
            Statement statement = con.createStatement();
            String SQLAddStatement =
                String.format(
                    "insert into books values('%s', '%s', '%s', %s, '%s', '%s', %d, '%s');",
                    book.getISBN(),
                    book.getTitle(),
                    Arrays.toString(book.getAuthors()),
                    book.getPages(),
                    book.getPublishDate(),
                    book.getImageURL(),
                    7,
                    "unlisted");
            statement.executeUpdate(SQLAddStatement);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** Returns a Book with the specified isbn or null if the book does not exist in the database */
    public static Book getBook(String isbn) {
        Book book = null;
        try {
            Connection con = connect();
            ResultSet results;
            Statement statement = con.createStatement();
            results = statement.executeQuery(String.format("select * from books where isbn = %s;", isbn));
            book = createBook(results);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    /** Returns all the books in the database */
    static List<Book> getAllBooks(){
        Connection con = connect();
        ResultSet results;
        List<Book> list = null;
        try {
            Statement statement = con.createStatement();
            results = statement.executeQuery("select * from books;");
            if (results == null) { return null; }
            list = new ArrayList<>();
            while(results.next()) {
                list.add(createBook(results));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /** Returns a List of books by the specified author */
    static List<Book> getBooks(Author author){
        Connection con = connect();
        ResultSet results;
        List<Book> list = null;
        try {
            Statement statement = con.createStatement();
            results = statement.executeQuery(String.format("select * from books where author = '%s';", author.getName()));
            if (results == null) { return null; }
            list = new ArrayList<>();
            while(results.next()) {
                list.add(createBook(results));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /** Change the list status of a book */
    public static void changeListStatus(String isbn) {
        try {
            Connection con = connect();
            Statement statement = con.createStatement();
            String SQLAddStatement =
                    String.format("update books set listStatus = 'listed' where isbn = '%s'", isbn);
            statement.executeUpdate(SQLAddStatement);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** Creates a Book object form the first row of a ResultSet */
    private static Book createBook(ResultSet results) {
        if (results == null) return null;
        Book book = null;
        try {
            if (results.isBeforeFirst()) results.next();
            book = new Book(results.getString(1));
            book.setTitle(results.getString(2));
            book.setAuthors(getAuthorsArray(results.getString(3)));
            book.setPages(results.getInt(4));
            book.setPublishDate(results.getString(5));
            book.setImageURL(results.getURL(6));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    /** Returns a Connection that connects to database */
    private static Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDatabase?useSSL=false", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    private static Author[] getAuthorsArray(String authorString) {
        authorString = authorString.replace("[\\[\\]]", "");
        String[] stringAuthors = authorString.split(",");
        Author[] newAuthors = new Author[stringAuthors.length];
        for (int i = 0; i < stringAuthors.length; i++) {
            newAuthors[i] = new Author(stringAuthors[i]);
        }
        return newAuthors;
    }
}