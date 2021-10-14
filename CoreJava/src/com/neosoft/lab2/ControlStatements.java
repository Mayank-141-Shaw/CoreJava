package com.neosoft.lab2;

public class ControlStatements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=10,m=20,p=30;
		
		// if else
		if(m>n) System.out.println("M is greater");
		else System.out.println("N is greater");
		
		if(m>n) {
			if(m>p) {
				System.out.println("M is greatest");
			}else {
				System.out.println("P is greater");
			}
		}else {
			if(n>p) {
				System.out.println("N is greatesr");
			}else {
				System.out.println("P is greatest");
			}
		}
		
		if(m>n && m>p)System.out.println("M is greatest");
		else if(n>m && n>p)System.out.println("N is greatest");
		else System.out.println("P is greates");
		
		
		// Switch 
		
		switch(n) {
		case 10: System.out.println(m);
			break;
		case 20: System.out.println(n);
			break;
		case 30: System.out.println(p);
			break;
		default:
			System.out.println("Not matched");
		}
		
		
		
		// for loop
		int sum = 0;
		for(int i=1; i<=m; i++) {
			sum += i;
		}
		System.out.println("Total = "+sum);
		
		// foreach
		sum =0;
		int arr[] = {11,21,31,41,51,61,71,81,91,101};
		for(int item:arr) {
			sum += item;
		}
		System.out.println("Total of foreach loop is = "+sum);
		
		
		//while loop
		int i=0;
		while(i<10) {
			System.out.println(i);
			i++;
		}
		
		
		// do-while loop
		int j=10;
		do {
			System.out.println(j++);
		}while(j<=20);
	}

}
