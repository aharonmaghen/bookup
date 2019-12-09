package bookup;
import javax.xml.transform.Result;
import java.sql.*;

/** Provides helper methods for interacting with the database */
class SQLHelper {

    /** Adds specified book to database */
    public void add(Book book) {
        Connection con = connect();
        try {
            Statement statement = con.createStatement();
            String SQLAddStatement = String.format("insert into books values(%s, '%s', '%s', %s, %s, %s);", book.getISBN(), book.getTitle(), book.getAuthor(),book.getPages(), book.getYear(), book.getImageURL());
            System.out.println(SQLAddStatement);
            statement.executeUpdate(SQLAddStatement);
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /** Returns a Book with the specified isbn or null if the book does not exist in the database */
    public Book getBook(String isbn) {
        Connection con = connect();
        ResultSet results = null;
        try {
            Statement statement = con.createStatement();
            results = statement.executeQuery(String.format("select * from books where isbn = %s", isbn));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return createBook(results);
    }

    /** Creates a Book object form the first row of a ResultSet */
    private static Book createBook(ResultSet results) {
        if (results == null) return null;
        Book book = null;
        try {
            results.next();
            book = new Book(results.getString(1));
            book.setTitle(results.getString(2));
            book.setAuthor(new Author(results.getString(3)));
            book.setPages(results.getInt(4));
            book.setYear(results.getInt(5));
            book.setImageURL(results.getURL(6));
        } catch (SQLException e) {
            System.out.println(e);
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
            System.out.println(e);
        }
        return con;
    }
}