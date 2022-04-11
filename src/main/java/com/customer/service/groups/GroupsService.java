package com.customer.service.groups;

import com.customer.model.CustomerGroup;

public interface GroupsService {
	public CustomerGroup save(CustomerGroup customerGroup);
	public Boolean findCustomer(String email,String grp);

}
