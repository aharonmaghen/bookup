package boot;

import bookup.APIHelper;
import bookup.Book;
import bookup.SQLHelper;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BookController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/bookInfo")
	public String bookInfo(@RequestParam(name="isbn", required=true) String isbn, Model model) {
		String jsonResult = null;
		try {
			jsonResult = APIHelper.getJson(isbn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		Book book = gson.fromJson(jsonResult, Book.class);
		book.setISBN(isbn);

		SQLHelper.add(book);

		model.addAttribute("book", book);

		return "bookInfo";
	}

	@GetMapping("/addBookToDB")
	public ModelAndView addBookToDB(@RequestParam(name="isbn", required=true) String isbn, Model model) {
		SQLHelper.changeListStatus(isbn);
		return new ModelAndView("redirect:/home");
	}

}
