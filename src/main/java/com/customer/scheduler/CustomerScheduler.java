package com.customer.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.customer.repository.CustomerGroupRepository;

@Component
public class CustomerScheduler {
	
	@Autowired
	private CustomerGroupRepository groupRepository; 
	
	//update group-1
	@Scheduled(cron = "0 0 * * * *")
	public void updateGroup1()
	{
		Integer list=groupRepository.maleGroup("Female","group1");
	     System.out.println("working");
		System.out.println(list);
	}
	
	//update group-2
	@Scheduled(cron = "0 0 * * * *")
	public void updateGroup2()
	{
		Integer list=groupRepository.femaleGroup("male","group2");
	     System.out.println("working");
		System.out.println(list);
	}
	
	//update group-3
	@Scheduled(cron = "0 0 * * * *")
	public void updateGroup3()
	{
		Integer list=groupRepository.ageGroup("group3");
	     System.out.println("working");
		System.out.println(list);
	}

}
