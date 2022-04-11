package com.customer.service.customer;

import com.customer.dto.CustomerDto;
import com.customer.model.CustomerInfo;

public interface CustomerService {
	public CustomerInfo save(CustomerDto customerDto);
	public CustomerInfo getCustomer(String email);
	public Boolean findCustomer(String email);
	public Boolean Auth(String email,String password);

}
