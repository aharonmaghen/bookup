package bookup;

import com.google.gson.annotations.SerializedName;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Arrays;

/** Represents a single Book */
public class Book {
	@SerializedName("ISBN") private IsbnObject isbnObject;
	private String isbn;
	private String title;
	private Author[] authors;
	private int pages;	
	private String publishDate;
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

	public Author[] getAuthors() {
		return isbnObject.authors;
	}

	public String getAuthorsString() {
		return Arrays.toString(isbnObject.authors);
	}

	public void setAuthors(Author[] authors) {
		this.authors = authors;
	}

	public int getPages() {
		return isbnObject.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPublishDate() {
		return isbnObject.publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public URL getImageURL() {
		if (isbnObject.cover == null) {
			return null;
		}
		try {
			return new URL(isbnObject.cover.imageUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
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
			+ "Publish date: %s\n"
			+ "imageURL: %s\n",
			getISBN(), getTitle(), Arrays.toString(getAuthors()), getPages(), getPublishDate(), getImageURL());
	}


	private class IsbnObject {
		@SerializedName("number_of_pages") private int pages;
		@SerializedName("authors") private Author[] authors;
		@SerializedName("publish_date") private String publishDate;
		private String title;
		private String subtitle;
		private Cover cover;
	}

	private static class Cover {
		@SerializedName("large") private String imageUrl;
	}

}