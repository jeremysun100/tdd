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
	private String displayName;

	public Customer() {
	}

	public Customer(String username, String firstName, String lastName, String gender, String displayName) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "Customer{" + "username='" + username + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", gender='" + gender
				+ '\'' + ", displayName='" + displayName + '\'' + '}';
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
