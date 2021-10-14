package com.neosoft.lab4;

public class MethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("First : "+sum(10,20));
		System.out.println("Second : "+sum(10,20, 50));
		System.out.println("Third : "+sum(60, 89.01, 56.93f));

	}
	
	static int sum(int a, int b) {
		return a+b;
	}
	
	static int sum(int a, int b, int c) {
		return a+b+c;
	}
	
	static double sum(int a, double b, float c) {
		return a+b+c;
	}

}
