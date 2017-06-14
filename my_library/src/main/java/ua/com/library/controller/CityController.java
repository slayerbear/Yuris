package ua.com.library.controller;

import java.beans.PropertyEditor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.editor.CountryEditor;
import ua.com.library.entity.City;
import ua.com.library.entity.Country;
import ua.com.library.service.CityService;
import ua.com.library.service.CountryService;

@Controller
public class CityController {
	@Autowired
	private CityService cityService;

	@Autowired
	private CountryService countryService;

	@InitBinder
	public void InitBinder1(WebDataBinder binder) {
		binder.registerCustomEditor(Country.class, (PropertyEditor) new CountryEditor(countryService));
	}

	@RequestMapping(value = "/newCity", method = RequestMethod.GET)
	public String newCity(Model model) {

		model.addAttribute("cities", DtoUtilMapper.citiesToCitiesDTO(cityService.findAll()));
		model.addAttribute("city", new City());
		model.addAttribute("countries", DtoUtilMapper.countriesToCountriesDTO(countryService.findAll()));

		return "newCity";
	}

	@RequestMapping(value = "/saveCity", method = RequestMethod.POST)
	public String saveCity(@ModelAttribute City city, @RequestParam String city_name, Model model) {
		try {
			city.setCity_name(city_name);

			cityService.create(city);

		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
			model.addAttribute("countries", DtoUtilMapper.countriesToCountriesDTO(countryService.findAll()));
			model.addAttribute("cities", DtoUtilMapper.citiesToCitiesDTO(cityService.findAll()));
			return "newCity";
		}

		return "redirect:/newCity";
	}

	@RequestMapping(value = "/deleteCity/{id}", method = RequestMethod.GET)
	public String newCity(@PathVariable String id) {
		cityService.delete(Integer.parseInt(id));
		return "redirect:/newCity";
	}

}
