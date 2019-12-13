package bookup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/** Main Bookup Application */
class Main {
	public static void main(String[] args) {

		System.out.println("Success!!!!!!!!!!");

		URL test = null;
		try {
			test = new URL("https://www.youtube.com/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println(test);
		try {
			System.out.println(test.getContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(test.getAuthority());

		Book book = new Book("1234567890");
		book.setTitle("this is a book");
		book.setAuthor(new Author("aharon maghen"));
		book.setPages(345);
		book.setYear(2020);
		try {
			book.setImageURL(new URL("https://www.linkedin.com/in/aharonmaghen"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		SQLHelper.add(book);

		System.out.println(SQLHelper.getBook("1234567890"));
		System.out.println(SQLHelper.getBook("111111111"));

		List<Book> list = SQLHelper.getAllBooks();
		System.out.println(list);


	}
}