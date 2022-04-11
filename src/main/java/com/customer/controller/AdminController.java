package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.customer.dto.CustomerDto;
import com.customer.repository.CustomerGroupRepository;

@Controller
public class AdminController {
	
	@Autowired
	private CustomerGroupRepository groupRepository;

	// login page
	@GetMapping("/Adminlogin")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("AdminLogin");
		CustomerDto customerDto = new CustomerDto();
		mav.addObject("customer", customerDto);
		return mav;
	}

	// login page authorization
	@PostMapping("/authAdmin")
	public String AuthEmployee(@ModelAttribute CustomerDto dto) {
		// employeeService.save(employee);
		if (dto.getEmail().equals("admin") && dto.getPassword().equals("admin")) {
			return "redirect:/login/customers";
		}
		return "redirect:/login?error";
	}

	// admin page list of employees

	@GetMapping("/login/customers")
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView("list-customers");
		mav.addObject("customers", groupRepository.findAll(Sort.by(Sort.Direction.ASC,"group")));
		return mav;
	}

}
