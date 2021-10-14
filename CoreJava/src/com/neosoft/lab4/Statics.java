package com.neosoft.lab4;

public class Statics {
	static int a;
	static {
		a = 100;
		System.out.println("Static block was called");
	}
	public static final double PI = 3.14178;
	
	static void display(String st) {
		System.out.println("A static method belongs to the class rather than the object");
		System.out.println("The message is "+st);
	}
	
	void show() {
		System.out.println("Non static method");
		System.out.println(a+" is a value of static variable");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// static variables will have only one copy each class
		Statics sc = new Statics();
		Statics.display("Hello World!");
		sc.show();
	}

}
