package com.session2;

public class User {
	
	private int uid;
	private String email;
	private String mobile;
	private String name;
	private String pass;
	public User(int uid, String email, String mobile, String name, String pass) {
		this.setUid(uid);
		this.setEmail(email);
		this.setMobile(mobile);
		this.setName(name);
		this.setPass(pass);
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
