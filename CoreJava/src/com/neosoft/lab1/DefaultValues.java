package com.neosoft.lab1;

public class DefaultValues {
	int a;
	boolean b;
	char c;
	float f;
	double d;
	byte bb;
	long l;
	short s;
	
	public void printV() {
		System.out.println("Default value of Integer = "+a);
		System.out.println("Default value of Boolean = "+b);
		System.out.println("Default value of Character = "+c);
		System.out.println("Default value of Float = "+f);
		System.out.println("Default value of Double = "+d);
		System.out.println("Default value of Byte = "+bb);
		System.out.println("Default value of Long = "+l);
		System.out.println("Default value of Short = "+s);
	}
	
	public static void main(String args[]) {
		DefaultValues dv = new DefaultValues();
		dv.printV();
		
	}
}
