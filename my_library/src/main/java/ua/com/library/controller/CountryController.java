package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;
import ua.com.library.service.CountryService;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/newCountry", method = RequestMethod.GET)
	public String newCountry(Model model) {
		model.addAttribute("countries", DtoUtilMapper.countriesToCountriesDTO(countryService.findAll()));
		model.addAttribute("country", new Country());
		return "newCountry";
	}

	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute Country country, @RequestParam String name, Model model)
			throws Exception {
	
		try {
			country.setName(name);
			countryService.create(country);

		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
			model.addAttribute("countries", DtoUtilMapper.countriesToCountriesDTO(countryService.findAll()));
			//model.addAttribute("country", new Country());
			return "newCountry";
		}

		return "redirect:/newCountry";
	}

	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.GET)
	public String newCountry(@PathVariable String id) {
		countryService.delete(Integer.parseInt(id));
		return "redirect:/newCountry";
	}

}
