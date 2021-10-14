package com.neosoft.lab6;

interface AA{
	void med1();
}

interface B{
	void med2();
}

interface C{
	void med3();
}

public class MultiInherits implements AA,B,C{
	@Override
	public void med1() {
		System.out.println("This is MEthod 1");
	}
	
	@Override
	public void med2() {
		System.out.println("This is MEthod 2");
	}
	
	@Override
	public void med3() {
		System.out.println("This is MEthod 3");
	}
}
