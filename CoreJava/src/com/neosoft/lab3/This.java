package com.neosoft.lab3;

public class This {
	
	int val;
	
	This(int val){
		this.val = val;
	}
	
	int giveDetails(int a) {
		return this.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		This th = new This(100);
		System.out.println("Output is : "+th.giveDetails(200));
	}

}
