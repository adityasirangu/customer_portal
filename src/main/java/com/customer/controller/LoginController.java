package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.customer.dto.CustomerDto;
import com.customer.model.CustomerGroup;
import com.customer.model.CustomerInfo;
import com.customer.service.customer.CustomerService;
import com.customer.service.groups.GroupsService;

@Controller
public class LoginController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private GroupsService groupsService;

	@GetMapping("/login")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("customer-login");
		CustomerDto customerDto = new CustomerDto();
		mav.addObject("customer", customerDto);
		return mav;
	}

	@PostMapping("/authCustomer")
	public String check(@ModelAttribute CustomerDto dto) {
		if (customerService.Auth(dto.getEmail(), dto.getPassword())) {
			return "redirect:/login/Home/" + dto.getEmail();
		}

		return "redirect:/login?error";
	}

	@GetMapping("/login/Home/{email}")
	public ModelAndView home(@PathVariable String email) {
		ModelAndView mav = new ModelAndView("customer-home");
		mav.addObject("customers", customerService.getCustomer(email));
		return mav;
	}

	@GetMapping("/group1")
	public String group1Add(@RequestParam("customerEmail") String email) {

		System.out.println(email + " ");
		if(groupsService.findCustomer(email,"group1"))
		{
			return "group1";
		}
		CustomerInfo info = customerService.getCustomer(email);
		CustomerGroup group = new CustomerGroup(info.getName(), info.getEmail(), info.getContactNumber(), "group1",
				info.getAge(), info.getGender());
		groupsService.save(group);
		return "group1";
	}

	@GetMapping("/group2")
	public String group2Add(@RequestParam("customerEmail") String email) {

		System.out.println(email + " ");
		if(groupsService.findCustomer(email,"group2"))
		{
			return "group2";
		}
		CustomerInfo info = customerService.getCustomer(email);
		CustomerGroup group = new CustomerGroup(info.getName(), info.getEmail(), info.getContactNumber(), "group2",
				info.getAge(), info.getGender());
		groupsService.save(group);
		return "group2";
	}

	@GetMapping("/group3")
	public String group3Add(@RequestParam("customerEmail") String email) {

		System.out.println(email + " ");
		if(groupsService.findCustomer(email,"group3"))
		{
			return "group3";
		}
		CustomerInfo info = customerService.getCustomer(email);
		CustomerGroup group = new CustomerGroup(info.getName(), info.getEmail(), info.getContactNumber(), "group3",
				info.getAge(), info.getGender());
		groupsService.save(group);
		return "group3";
	}

}
