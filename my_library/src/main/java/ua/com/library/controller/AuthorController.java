package ua.com.library.controller;

import java.beans.PropertyEditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import ua.com.library.service.RegionService;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.editor.AuthorEditor;
import ua.com.library.editor.CityEditor;
import ua.com.library.editor.CountryEditor;
import ua.com.library.entity.Author;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;
import ua.com.library.service.AuthorService;
import ua.com.library.service.CityService;
import ua.com.library.service.CountryService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	@Autowired
	private CityService cityService;


	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(City.class, (PropertyEditor) new CityEditor(cityService));
		binder.registerCustomEditor(Author.class, (PropertyEditor) new AuthorEditor(authorService));
	}

	
	

	@RequestMapping(value = "/newAuthor", method = RequestMethod.GET)
	public String newAuthor(Model model) {
		model.addAttribute("authors", DtoUtilMapper.authorsToAuthorsDTO(authorService.findAll()));
		model.addAttribute("author", new Author());
		model.addAttribute("cities", DtoUtilMapper.citiesToCitiesDTO(cityService.findAll()));
		model.addAttribute("city", new City());
		return "newAuthor";
	}

	@RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
	public String saveAuthor(@ModelAttribute Author author,@RequestParam String name,Model model

	) throws Exception {
		author.setName(name);;
		try {
		
		authorService.create(author);
		} catch (Exception e) {
			model.addAttribute("authors", DtoUtilMapper.authorsToAuthorsDTO(authorService.findAll()));
			model.addAttribute("cities", DtoUtilMapper.citiesToCitiesDTO(cityService.findAll()));
			model.addAttribute("exception", e.getMessage());
		return "newAuthor";
	}

		return "redirect:/newAuthor";
	}

	@RequestMapping(value = "/deleteAuthor/{id}", method = RequestMethod.GET)
	public String newAuthor(@PathVariable String id) {
		authorService.delete(Integer.parseInt(id));
		return "redirect:/newAuthor";
	}

}
