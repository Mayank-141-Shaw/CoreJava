package com.neosoft.lab3;

public class CallBy {
	int val;
	
	CallBy(){
		this.val = 100;
	}

	public int call(int val) {
		return val*val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CallBy cb = new CallBy();
		System.out.println("Call by value "+cb.call(200));
		System.out.println("Call by reference "+cb.call(cb.val));
	}

}
