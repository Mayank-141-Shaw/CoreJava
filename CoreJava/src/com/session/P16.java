package com.session;

import java.io.*;
import java.util.*;

public class P16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "res/emp.db";
		Emp[] emps = {
				new Emp(1, "Jacob", 20000, 10),
				new Emp(2, "Zhong Xina", 30000, 5),
				new Emp(3, "Jenny", 20000, 6),
				new Emp(4, "Aman", 25000, 10),
				new Emp(5, "Beth", 17000, 10),
		};
		ArrayList<Emp> empList = new ArrayList<Emp>();
		// serialization
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			// write the array by making it byte stream to file
			for(int i=0; i<5; i++) {
				empList.add(emps[i]);
			}
			out.writeObject(empList);
			out.close();
			file.close();
			System.out.println("Objects have been serialized");
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		ArrayList<Emp> empsFromd10 = new ArrayList<Emp>();
		int maxSal = -999;
		
		empList.clear();
		// deserialization
		try {
			//reading the object from the file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			empList = (ArrayList<Emp>)in.readObject();
			
			// check if dno is 10
			System.out.println("Employees with Dno 10");
			for(int i=0; i<empList.size(); i++) {
				if(empList.get(i).dno == 10) {
					empList.get(i).display();
				}
				if(empList.get(i).esal > maxSal) {
					maxSal = empList.get(i).esal;
				}
			}
			
			System.out.println("Maximum salary = "+maxSal);
		
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}

class Emp implements Serializable{
	int eid;
	String ename;
	int esal;
	int dno;
	public Emp(int eid, String ename, int esal, int dno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.dno = dno;
	}
	
	public void display() {
		System.out.println("ID : "+this.eid+" Name : "+this.ename+" Salary : "+this.esal+" Dno: "+this.dno);
	}
}