package com.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customer.model.CustomerGroup;
import com.customer.model.CustomerInfo;

@Repository
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup, Long> {
	
	
	public CustomerGroup findByEmail(String email);

   //Group-1(contains only male)
	@Transactional
	@Modifying
	@Query("DELETE FROM CustomerGroup cmp WHERE cmp.Gender=:gender and cmp.group=:group")
	Integer maleGroup(@Param("gender") String gen, @Param("group") String grp);

	@Query("SELECT  emp FROM CustomerGroup emp WHERE emp.Gender=:gender and emp.group=:group")
	List<CustomerGroup> findgroup1(@Param("gender") String gen, @Param("group") String grp);

	
	//Group-2(contains only female)
	@Transactional
	@Modifying
	@Query("DELETE FROM CustomerGroup cmp WHERE cmp.Gender=:gender and cmp.group=:group")
	Integer femaleGroup(@Param("gender") String gen, @Param("group") String grp);
	
	
	//Group-3(conatins age group btwn 18-30)
	@Transactional
	@Modifying
	@Query("DELETE FROM CustomerGroup cmp WHERE (cmp.age BETWEEN 16 AND 30) and cmp.group=:group")
	Integer ageGroup(@Param("group") String grp);
	
}
