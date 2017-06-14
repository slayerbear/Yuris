package ua.com.library.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import ua.com.library.service.CustomerService;
import ua.com.library.service.BookService;

@Controller
public class CookieController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/buyBook/{id}", method = RequestMethod.GET)
	public String buyBook(@PathVariable String id,  HttpServletRequest request, HttpServletResponse response) {

		customerService.intoBasket(id,request,response);

		return "redirect:/";
	}

	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
	public String getOrder(Principal principal, @PathVariable String id, HttpServletRequest request,
			HttpServletResponse response) {

		customerService.getOrder(principal, id, request, response);
		

		return "redirect:/profile";
	}

	@RequestMapping(value = "/deleteFromOrder/{id}", method = RequestMethod.GET)
	public String deleteCookie(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {

		customerService.deleteCookieFromOrder(id, request, response);

		return "redirect:/basket";
	}

	@RequestMapping(value = "/basket", method = RequestMethod.GET)
	public String basket(HttpServletRequest request, Model model) {

		model.addAttribute("books", customerService.userBooksCookie(request));

		return "basket";
	}
}