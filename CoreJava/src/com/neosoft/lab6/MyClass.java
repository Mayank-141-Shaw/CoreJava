package com.neosoft.lab6;

interface A{
	void meth1();
	void meth2();
}

public class MyClass implements A{
	public void meth1() {
		System.out.println("This is Meth 1");
	}
	
	public void meth2() {
		System.out.println("This is Meth 2");
	}
}
