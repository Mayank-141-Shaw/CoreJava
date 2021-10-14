package com.session;

import java.util.*;
import java.io.*;
import java.util.regex.*;
public class P19 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		final String VALID_PHONE_REGEX = "(0/91)?[7-9][0-9]{9}";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Student> students = new ArrayList<Student>();
		
		for(int i=0; i<5; i++) {
			System.out.println("Enter name of student "+(i+1));
			String name = br.readLine();
			System.out.println("Enter id of student "+(i+1));
			int id = Integer.parseInt(br.readLine());
			String mail, phone;
			while(true) {
				System.out.println("Enter correct student email");
				mail = br.readLine();
				if(!mail.matches(VALID_EMAIL_ADDRESS_REGEX))	{
					System.out.println("Wrong email");
				}else {
					break;
				}
			}
			while(true) {
				System.out.println("Enter correct student phone");
				phone = br.readLine();
				if(phone.matches(VALID_PHONE_REGEX)) {
					break;
				}else {
					System.out.println("Wrong phone");
				}
			}
			
			students.add(new Student(id, name, phone, mail));
		}
		
		// students whose phone starts with 98
		Iterator<Student> itr = students.iterator();
		System.out.println("Students whose mobile number starts with 98");
		while(itr.hasNext()) {
			Student st = itr.next();
			if(st.mobile.startsWith("98")) {
				st.display();
			}
		}
		System.out.println();
		
		itr = students.iterator();
		System.out.println("Students whose email is gmail");
		int notGmail = 0;
		while(itr.hasNext()) {
			Student st = itr.next();
			if(st.email.contains("gmail")) {
				st.display();
			}
			else {
				notGmail++;
			}
		}
		
		System.out.println("Total people who does not have gmail accounts = "+notGmail);
	}

}

class Student{
	int id;
	String name;
	String mobile;
	String email;
	public Student(int id, String name, String mobile, String email) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}
	
	public void display() {
		System.out.println("ID : "+this.id+" Name : "+this.name+" Phone : "+this.mobile+" Email : "+this.email);
	}
}