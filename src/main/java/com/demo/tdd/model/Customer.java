package com.demo.tdd.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private String username;
	private String firstName;
	private String lastName;
	private String gender;

	public Customer() {
	}

	public Customer(String username, String firstName, String lastName, String gender) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer{" + "username='" + username + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", gender='" + gender + '\''
				+ '}';
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}
}
