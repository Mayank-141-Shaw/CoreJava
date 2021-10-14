package com.neosoft.lab6;


class Outer{
	void display() {
		System.out.println("This is outer method");
	}
	
	static class Inner{
		void display() {
			System.out.println("This is inner method");
		}
	}
}

public class InnerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer o = new Outer();
		o.display();
		Outer.Inner i = new Outer.Inner();
		i.display();
		
		
	}

}
