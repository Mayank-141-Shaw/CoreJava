package com.neosoft.lab7;

import java.util.*;

public class RecursiveFibonacci {
	
	static int n1=0,n2=1,n3=0;    
	 static void printFibonacci(int count){    
	    if(count>0){    
	         n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.print(" "+n3);   
	         printFibonacci(count-1);    
	     }    
	 }    

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number (must be greater than 2)");
		int n = sc.nextInt();
		System.out.print("0 1");
		printFibonacci(n-2);
	}

}
