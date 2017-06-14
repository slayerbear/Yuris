package ua.com.library.controller;

import java.beans.PropertyEditor;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.dto.BookDTO;
import ua.com.library.editor.AuthorEditor;
import ua.com.library.editor.BookEditor;
import ua.com.library.entity.Author;
import ua.com.library.entity.Book;
import ua.com.library.service.AuthorService;
import ua.com.library.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Book.class, (PropertyEditor) new BookEditor(bookService));
		binder.registerCustomEditor(Author.class, (PropertyEditor) new AuthorEditor(authorService));
		binder.registerCustomEditor(Author.class, (PropertyEditor) new AuthorEditor(authorService));
	}

	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public String newauthor(Model model, Author departureAuthor) {
		model.addAttribute("books", DtoUtilMapper.booksToBooksDTO(bookService.findAll()));
		model.addAttribute("authors", DtoUtilMapper.authorsToAuthorsDTO(authorService.findAll()));

		model.addAttribute("book", new Book());
        
		return "newBook";
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String savebook(@ModelAttribute Book book, @RequestParam String some
			

	) {
		
		LocalDate date = LocalDate.parse(some);
		;
		
	
		
		bookService.create(book);

		return "redirect:/newBook";
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
	public String newbook(@PathVariable String id) {
		bookService.delete(Integer.parseInt(id));
		return "redirect:/newBook";
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public @ResponseBody BookDTO updateBook(@RequestBody String id) {

		Book book = bookService.findOne(Integer.parseInt(id));

		return new BookDTO(book.getNumber(), book.getArrivalAuthor(), book.getDepartureAuthor());
	}

}
