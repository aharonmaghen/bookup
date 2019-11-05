package bookup;

/** Main Bookup Application */
class Main {
	public static void main(String[] args) {
		System.out.println("Success!!!!!!!!!!");
		Book book = new Book("1234567890");
		book.setAuthor(new Author("Aharon Maghen"));
		book.setPages(250);
		System.out.println(book);
	}
}