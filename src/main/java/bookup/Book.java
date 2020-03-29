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
		return title;
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
		return pages;
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
		return String.format("ISBN: %s, Title: %s, Author: %s, Pages: %s, Year: %s, Image URL: %s",
				isbn, isbnObject.title, author, pages, year, imageURL);
	}


	private class IsbnObject {
		private String title;
	}

}