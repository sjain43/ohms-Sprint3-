package com.cg.ohms.dto;
/**
 * User data dto class
 * @author trainee
 *
 */
public class CustomerDataDTO {
	//All the attributes for getting user-data input
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String phone;
	private String state;
	private String city;
	private int pincode;
	private String homeno;

	public CustomerDataDTO(String firstname, String lastname, String password, String email, String phone,String state,String city, int pincode,String homeno) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.homeno = homeno;

	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public int getPincode() {
		return pincode;
	}

	public String getHomeno() {
		return homeno;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

}
