package com.session;
import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 5 student details");
		Movies st[] = new Movies[5]; 
		
		for(int i=0; i<5;i++) {
			System.out.println("Enter name of student "+(i+1));
			String name = sc.next();
			System.out.println("Enter ID of student "+(i+1));
			int stid = sc.nextInt();
			System.out.println("Enter course of student "+(i+1));
			String course = sc.next();
			System.out.println("Enter marks of student "+(i+1));
			int marks = sc.nextInt();
			
			st[i] = new Movies(stid, name, course, marks);
		}
		
		// after saving array check
		// if marks more than 60 and course is BCA
		for(Movies student : st) {
			if(student.marks >60 && student.course.equalsIgnoreCase("BCA")) {
				student.show();
			}
		}
	}

}

class Movies{
	int stid;
	String name;
	String course;
	int marks;
	
	public Movies(int stid, String name, String course, int marks) {
		super();
		this.stid = stid;
		this.name = name;
		this.course = course;
		this.marks = marks;
	}
	
	public void show() {
		System.out.println("Student ID : "+this.stid+" Name : "+this.name
				+" Course : "+this.course+" Marks : "+this.marks);
	}
}