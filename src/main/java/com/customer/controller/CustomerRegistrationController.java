package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.dto.CustomerDto;
import com.customer.service.customer.CustomerService;

@Controller
@RequestMapping("/customerReg")
public class CustomerRegistrationController {
	
	@Autowired
	private CustomerService customerService;
	
	@ModelAttribute("customer")
	public CustomerDto studentDto()
	{
		return new CustomerDto();
	}
	
	
	@GetMapping
	public String form()
	{
		return "customer-Registration";
	}
	
	@PostMapping
	public String addCustomer(@ModelAttribute("customer") CustomerDto dto)
	{
		if(customerService.findCustomer(dto.getEmail()))
		{
			return "redirect:/customerReg?error";
		}
		customerService.save(dto);
		return "redirect:/customerReg?success";
	}

}
