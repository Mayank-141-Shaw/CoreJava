package com.neosoft.lab3;

public class Room {
	int isroomno;
	String roomtype;
	String roomArea;
	boolean acMachine;
	
	public void setData(int room, String type, String area, boolean ac) {
		this.isroomno = room;
		this.roomtype = type;
		this.roomArea = area;
		this.acMachine = ac;
	}
	
	public void displayData() {
		System.out.println("Room No: "+this.isroomno+"\nRoom Type : "+this.roomtype+"\nRoom Area : "+this.roomArea);
		
		if(this.acMachine) System.out.println("AC Machine : Available");
		else System.out.println("AC Machine : Not Available");
	}
}
