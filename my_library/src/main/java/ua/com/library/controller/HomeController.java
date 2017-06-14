package ua.com.library.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.dto.BookDTO;
import ua.com.library.entity.Customer;
import ua.com.library.entity.Book;
import ua.com.library.service.CustomerService;
import ua.com.library.service.BookService;

@Controller
public class HomeController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("books", DtoUtilMapper.booksToBooksDTO(bookService.findAll()));
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String loginprocessing() {

		return "redirect:/";
	}

	@RequestMapping(value = "/loginpage")
	public String login(@ModelAttribute Customer customer, Model model) throws Exception {
		try {

		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
			return "loginpage";
		}
		return "loginpage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {

		return "redirect:/";
	}

	@RequestMapping(value = "/sortbooks", method = RequestMethod.POST)
	public @ResponseBody List<BookDTO> sortBooks(@RequestBody String value) {

		List<Book> books = bookService.sortBooks(Integer.parseInt(value));

		return DtoUtilMapper.booksToBooksDTO(books);
	}

}
