package bookup;

import com.google.gson.annotations.SerializedName;
import java.net.URL;

/** Represents a single Book */
class Book {
	@SerializedName("ISBN") private IsbnObject isbnObject;
	private String isbn;
	private String title;
	private Author author;
	private int pages;
	private int year;
	private URL imageURL;

	public Book(String isbn) {
		this.isbn = isbn;
	}

	public String getISBN() {
		return isbn;
	}

	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return isbnObject.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPages() {
		return isbnObject.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public URL getImageURL() {
		return imageURL;
	}

	public void setImageURL(URL url) {
		this.imageURL = url;
	}

	@Override
	public String toString() {
		return String.format(
			"ISBN: %s\n"
			+ "Title: %s\n"
			+ "Author: %s\n"
			+ "Pages %d\n"
			+ "Year: %s\n"
			+ "imageURL: %s\n",
			getISBN(), getTitle(), getAuthor(), getPages(), getYear(), getImageURL());
	}


	private class IsbnObject {
		private String title;
		private String subtitle;
		@SerializedName("number_of_pages") private int pages;
	}

}