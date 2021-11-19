package com.servletcarapp.model;

public class CarLent {
	private int carid;
	private int uid;
	
	public CarLent(int carid, int uid) {
		super();
		this.carid = carid;
		this.uid = uid;
	}
	public CarLent() {}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
