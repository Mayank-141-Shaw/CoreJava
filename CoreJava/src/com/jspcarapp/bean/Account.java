package com.jspcarapp.bean;

import java.util.Base64;

public class Account {
	
	private int id;
	private String name;
	private String address;
	private String phone;
	private String username;
	private String password;
	private int carsRented;
	
	String latestTrans="";
	public Account(int id, String name, String address, String phone, String username, String password, int carsRented) {
		super();
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
		this.setPhone(phone);
		this.setUsername(username);
		this.setPassword(password);
		this.setCarsRented(carsRented);
	}
	
	public Account() {}
	
	
	public String getTransactions(){
		return this.latestTrans;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password; 
		// return password;
	}

	public void setPassword(String password) {
		// use base64 encryption
		this.password = password;
	}
	
	public void show() {
		System.out.println("<<  NAME : "+this.name+" ADDRESS : "+this.address+" PHONE : "+this.phone+" USERNAME : "+this.username+" BALANCE :   >>");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarsRented() {
		return carsRented;
	}

	public void setCarsRented(int carsRented) {
		this.carsRented = carsRented;
	}
	
}
