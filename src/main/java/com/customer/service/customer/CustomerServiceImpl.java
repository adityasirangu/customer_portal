package com.customer.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.customer.dto.CustomerDto;
import com.customer.model.CustomerInfo;
import com.customer.repository.CustomerInfoRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerInfoRepository infoRepository;

	@Override
	public CustomerInfo save(CustomerDto customerDto) {
		CustomerInfo customerInfo = new CustomerInfo(customerDto.getName(), customerDto.getEmail(),
				customerDto.getContactNumber(), customerDto.getAddress(), customerDto.getPassword(),
				customerDto.getAge(), customerDto.getGender());
		return infoRepository.save(customerInfo);
	}
    
	
	
	@Override
	@Cacheable(value = "customers",key = "#email")
	public CustomerInfo getCustomer(String email) {
		
		System.out.println("fetching from db");
		//return infoRepository.findByEmail(email);
		CustomerInfo info=infoRepository.findByEmail(email);
		if(info!=null)
		{
			return info;
		}
		return null;
	}

	@Override
	public Boolean findCustomer(String email) {
		CustomerInfo info=getCustomer(email);
		if(info!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public Boolean Auth(String email, String password) {
		CustomerInfo info=getCustomer(email);
		if(info!=null &&info.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
