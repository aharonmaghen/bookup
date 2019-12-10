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


		SQLHelper sqlHelper = new SQLHelper();

		List<Book> list = sqlHelper.getBooks(book.getAuthor());
		System.out.println(list);


	}
}