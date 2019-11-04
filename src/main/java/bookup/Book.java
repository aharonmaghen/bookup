package bookup;

/** Represents a single Book */
class Book {
	private String ISBN;
	private String title;
	Author author;
	private int pages;
	private int year;

	public Book(String ISBN) {
		this.ISBN = ISBN;
	}

	// ISBN getter/setter
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	// title getter/setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	// author getter/setter
	public Author getAuthor() {
		return author;
	}
	public void setAuthor() {
		this.author = new Author();
	}
	public void setAuthor(String firstName, String lastName, String middleInitial) {
		this.author = new Author(firstName, lastName, middleInitial);
	}

	// pages getter/setter
	public int getPages() {
		return pages;
	}
	public void setPages() {
		this.pages = pages;
	}

	// year getter/setter
	public int getYear() {
		return year;
	}
	public void setYear() {
		this.year = year;
	}

	@Override
	public String toString() {
		return "ISBN: " + ISBN + "\nTITLE: " + title + "\nAUTHOR: " + author.toString() + 
		"\nPAGES: " + pages + "\nYEAR: " + year;
	}

}