package bookup;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/** Main Bookup Application */
class Main {
	public static void main(String[] args) {
		try {
			String isbn = "9781942788331";
			String jsonResult = APIHelper.getJson(isbn);
			Gson gson = new Gson();
			Book book = gson.fromJson(jsonResult, Book.class);
			book.setISBN(isbn);
			System.out.println(book.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}