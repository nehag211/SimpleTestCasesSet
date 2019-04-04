package com.training.bean;

public class ELTC_068Bean {
	private String fieldsName,firstName,lastName,eMail,phone,login,password; 
	private String driver; 
	
	public ELTC_068Bean(){}
	
	public ELTC_068Bean(String fieldsName,String driver, String firstName, String lastName, String eMail, String phone,String login, String password) {
		super();
		this.fieldsName = fieldsName;
		this.driver = driver;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.phone = phone;
		this.login = login;
		this.password = password;
	}

	public String getFieldsName() {
		return fieldsName;
	}

	public void setFieldsName(String fieldsName) {
		this.fieldsName = fieldsName;
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}


	
	
}
