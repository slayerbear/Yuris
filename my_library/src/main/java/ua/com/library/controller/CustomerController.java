package ua.com.library.controller;

import java.beans.PropertyEditor;
import java.security.Principal;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;

import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.editor.CustomerEditor;
import ua.com.library.entity.Customer;
import ua.com.library.service.CustomerService;
import ua.com.library.service.MailSenderService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private MailSenderService mailSenderService;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Customer.class, (PropertyEditor) new CustomerEditor(customerService));
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String newCustomer(Model model) {
		model.addAttribute("customerDTOs", DtoUtilMapper.customersToCustomersDTO(customerService.findAll()));
		model.addAttribute("customer", new Customer());

		return "registration";
	}
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String customers(Model model) {
		model.addAttribute("customerDTOs", DtoUtilMapper.customersToCustomersDTO(customerService.findAll()));
		

		return "customers";
	}

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute Customer customer, Model model) throws Exception {
		String uuid = UUID.randomUUID().toString();
		customer.setUuid(uuid);
		try {
			customerService.create(customer);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
			return "registration";
		}

		String theme = "Thank you for registration!!!and Welcome to the infierno";
		String message = "http://localhost:8080/mazahaka_bla bla bla/confirm/" + uuid;
		mailSenderService.sendMail(theme, message, customer.getEmail());
		return "registrationCompleted";
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET)
	public String newCustomer(@PathVariable int id) {
		customerService.delete(id);
		return "redirect:/registration";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {

		System.out.println(principal);

		Customer customer = customerService.findOne(Integer.parseInt(principal.getName()));

		model.addAttribute("customer", customer);

		return "profile";
	}

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal, @RequestParam MultipartFile image) {

		try {
			customerService.saveImage(principal, image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "profile";
		}

		return "redirect:/profile";
	}

	@RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
	public String newCustomer(@PathVariable String uuid) {
		Customer customer = customerService.findByUUID(uuid);
		customer.setEnabled(true);
		customerService.update(customer);
		return "redirect:/";
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
	public String updateProfile(Principal principal, Model model) {
		Customer customer = customerService.findOne(Integer.parseInt(principal.getName()));
		model.addAttribute("customer", customer);
		return "updateProfile";
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String updateProfile(Principal principal, @RequestParam String name, @RequestParam String email,
			@RequestParam String phone, @RequestParam String password) {
		Customer customer = customerService.findOne(Integer.parseInt(principal.getName()));

		customer.setName(name);
		customer.setEmail(email);
		customer.setTelephone(phone);
		customer.setPassword(password);

		customerService.updateProfile(customer);

		return "redirect:/profile";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public void updateProfile(@RequestBody Customer customer) throws Exception {
		System.out.println(customer);
		customerService.create(customer);
	}
}
