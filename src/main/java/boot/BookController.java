package boot;

import bookup.APIHelper;
import bookup.Book;
import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Arrays;

@Controller
public class BookController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/bookInfo")
	public String test(@RequestParam(name="isbn", required=true) String isbn, Model model) {
		String jsonResult = null;
		try {
			jsonResult = APIHelper.getJson(isbn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		Book book = gson.fromJson(jsonResult, Book.class);
		book.setISBN(isbn);

		model.addAttribute("book", book);

		return "bookInfo";
	}

}
