package com.customer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_groups")
public class CustomerGroup implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String contactNumber;
	private String group;
	private int age;
	private String Gender;
	
	public CustomerGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerGroup(String name, String email, String contactNumber, String group, int age, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.group = group;
		this.age = age;
		Gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return "CustomerGroup [id=" + id + ", name=" + name + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", group=" + group + ", age=" + age + ", Gender=" + Gender + "]";
	}
	
}
