package com.neosoft.lab6;

interface Test{
	int square(int n);
}

class Arithmetic implements Test{
	public int square(int n) {
		return n*n;
	}
}

public class ToTestInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arithmetic at = new Arithmetic();
		System.out.println("Square is : "+at.square(10));
	}

}
