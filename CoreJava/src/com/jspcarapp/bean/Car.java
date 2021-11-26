package com.jspcarapp.bean;

public class Car {
	
	private int carid;
	private String model;
	private int price;
	private boolean lentStatus;
	
	public Car(int carid, String model, int price, boolean lentStatus) {
		super();
		this.carid = carid;
		this.model = model;
		this.price = price;
		this.lentStatus = lentStatus;
	}
	public Car() {}
	
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isLentStatus() {
		return lentStatus;
	}
	public void setLentStatus(boolean lentStatus) {
		this.lentStatus = lentStatus;
	}
	
	
	
}
