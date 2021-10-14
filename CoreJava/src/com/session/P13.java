package com.session;
import java.util.*;
public class P13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentP13 students[] = {
				new StudentP13(1, "Akshay", Subject.JAVA, 90),
				new StudentP13(2, "Akansha", Subject.C, 90),
				new StudentP13(3, "Arif", Subject.PYTHON, 90),
				new StudentP13(4, "Vivek", Subject.JAVA, 80),
				new StudentP13(5, "Mohan", Subject.JAVA, 70),
		};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a subject name");
		String sub = sc.nextLine();
		
		for(StudentP13 student: students) {
			if(student.subject.equals(Subject.valueOf(sub))) {
				student.display();
			}
		}
	}

}

class StudentP13{
	int id;
	String name;
	Subject subject;
	int marks;
	public StudentP13(int id, String name, Subject subject, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.marks = marks;
	}
	
	void display() {
		System.out.println("ID : "+this.id+" Name : "+this.name+" Subject : "+this.subject+" Marks : "+this.marks);
	}
}