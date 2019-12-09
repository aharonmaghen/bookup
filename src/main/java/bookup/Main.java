package bookup;

import java.net.MalformedURLException;
import java.net.URL;

/** Main Bookup Application */
class Main {
	public static void main(String[] args) {
		System.out.println("Success!!!!!!!!!!");
		Book book = new Book("987654321");
		book.setTitle("Building Java Programs");
		book.setAuthor(new Author("John Doe"));
		book.setPages(267);
		book.setYear(1998);
		try {
			book.setImageURL(new URL("google.com"));
		} catch (MalformedURLException e) {
			System.out.println(e);
		}
		System.out.println(book);

		SQLHelper sqlHelper = new SQLHelper();

//		sqlHelper.add(book);
		System.out.println("Fetching book with isbn = " + book.getISBN() + " -- " + sqlHelper.getBook(book.getISBN()));
	}
}