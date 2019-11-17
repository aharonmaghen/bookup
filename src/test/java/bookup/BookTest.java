package bookup;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private static final String ISBN = "isbn";
    private static final String TITLE = "title";
    private static final Author AUTHOR = new Author("author");
    private static final int PAGES = 20;
    private static final int YEAR = 1989;

    private static URL IMAGE_URL;

    @Before
    public void setUp() throws Exception {
        IMAGE_URL = new URL("http://www.example.com");
    }

    @Test
    public void bookWithISBNConstructor() {
        Book book = new Book(ISBN);

        assertEquals(ISBN, book.getISBN());
    }

    @Test
    public void book_toString() {
        Book book = new Book(ISBN);
        book.setTitle(TITLE);
        book.setAuthor(AUTHOR);
        book.setPages(PAGES);
        book.setYear(YEAR);
        book.setImageURL(IMAGE_URL);

        String actual = book.toString();

        String expected =
                "ISBN: isbn, Title: title, Author: author, Pages: 20, Year: 1989, Image URL: http://www.example.com";
        assertEquals(expected, actual);
    }
}
