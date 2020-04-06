package com.boot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BookController {

	@RequestMapping("/")
	public String index() {
		return "<h1>Welcome to bookup</h1>";
	}

}
