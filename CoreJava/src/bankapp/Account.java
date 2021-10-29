package bankapp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String address;
	private String phone;
	private String username;
	private String password;
	private int balance;
	private String inputTime;
	
	private ArrayList<String> trans = new ArrayList<String>();
	public Account(String name, String address, String phone, String username, String password, int balance) {
		super();
		this.setName(name);
		this.setAddress(address);
		this.setPhone(phone);
		this.setUsername(username);
		this.setPassword(password);
		this.balance = balance;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		this.inputTime = dtf.format(now);
		this.trans.add("Initial deposit - Rs"+this.balance+" as on "+this.inputTime);
	}
	
	public void deposit(int amt) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		this.inputTime = dtf.format(now);
		this.balance += amt;
		this.trans.add("Rs "+amt+" credited to your account. Balance - Rs "+this.balance+" as on "+this.inputTime);
	}
	
	public int getBalance() {
		return balance;
	}
	
	public ArrayList<String> getTransactions(){
		return trans;
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
		Base64.Decoder decoder = Base64.getDecoder();
		return new String(decoder.decode(password));
		// return password;
	}

	public void setPassword(String password) {
		// use base64 encryption
		Base64.Encoder encoder = Base64.getEncoder();
		this.password = encoder.encodeToString(password.getBytes());;
	}
	
	public void show() {
		System.out.println("<<  NAME : "+this.name+" ADDRESS : "+this.address+" PHONE : "+this.phone+" USERNAME : "+this.username+" BALANCE : "+this.balance+"  >>");
	}
	
}
