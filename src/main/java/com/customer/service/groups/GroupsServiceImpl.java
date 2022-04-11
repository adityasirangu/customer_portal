package com.customer.service.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.CustomerGroup;
import com.customer.model.CustomerInfo;
import com.customer.repository.CustomerGroupRepository;
@Service
public class GroupsServiceImpl implements GroupsService {
	
	@Autowired
	private CustomerGroupRepository repository;

	@Override
	public CustomerGroup save(CustomerGroup customerGroup) {
		return repository.save(customerGroup);
	}

	@Override
	public Boolean findCustomer(String email,String grp) {
		CustomerGroup info=repository.findByEmail(email);
		if(info!=null && info.getGroup().equals(grp))
		{
			return true;
		}
		return false;
	}
	

}
