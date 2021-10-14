package com.neosoft.lab4;

public class B extends A{
	public int b;
	
	public B(int a, int b) {
		super(a);
		this.b = b;
	}
	
	public void display() {
		super.display();
		System.out.println("A is called as : "+super.a);
		System.out.println(b);
	}
}
