package boot;

import bookup.APIHelper;
import bookup.Book;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Arrays;

@Controller
public class BookController {

	@GetMapping("/welcome")
	public String welcome(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "welcome";
	}

}
