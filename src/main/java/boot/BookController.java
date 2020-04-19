package boot;

import bookup.APIHelper;
import bookup.Book;
import bookup.SQLHelper;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class BookController {

	@GetMapping("/home")
	public String home(@RequestParam(value = "message", required=false) String message, Model model) {
		model.addAttribute("message", message);
		return "home";
	}

	@GetMapping("/bookInfo")
	public ModelAndView bookInfo(@RequestParam(name="isbn", required=true) String isbn, Model model, RedirectAttributes redAttributes) {
		String jsonResult = null;
		try {
			jsonResult = APIHelper.getJson(isbn);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		if (jsonResult.equals("{}")) {
			redAttributes.addAttribute("message", "THE BOOK WAS NOT FOUND. PLEASE MARK IT AND PUT IT IN A SEPERATE BOX");
			return new ModelAndView("redirect:/home");
		}
		Gson gson = new Gson();
		Book book = gson.fromJson(jsonResult, Book.class);
		book.setISBN(isbn);

		try {
			SQLHelper.add(book);
		} catch (SQLException e) {
			redAttributes.addAttribute("message", "THIS BOOK IS ALREADY IN THE DATABASE");
			return new ModelAndView("redirect:/home");
		}

		model.addAttribute("book", book);

		return new ModelAndView("bookInfo");
	}

	@GetMapping("/addBookToDB")
	public ModelAndView addBookToDB(@RequestParam(name="isbn", required=true) String isbn, Model model) {
		SQLHelper.changeListStatus(isbn);
		return new ModelAndView("redirect:/home");
	}

}
