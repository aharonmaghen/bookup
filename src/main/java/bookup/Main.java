package bookup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/** Main Bookup Application */
class Main {
	public static void main(String[] args) {

		System.out.println("Success!!!!!!!!!!");

		Book book = new Book("111111111");
		book.setTitle("cool beans");
		book.setAuthor(new Author("John Doe"));
		book.setPages(150);
		book.setYear(2017);

		System.out.println(SQLHelper.getBook("1234567890"));

		List<Book> list = SQLHelper.getBooks(book.getAuthor());
		System.out.println(list);


	}
}