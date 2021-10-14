package com.session;

import java.util.*;
public class P1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int dig, rev=0, n1=num;
		while(n1!=0) {
			dig = n1%10;
			rev = rev*10 + dig;
			n1 = Math.round(n1/10);
		}
		if(rev == num) System.out.println(num+" is palindrome");
		else System.out.println(num+" is not a palindrome");
	}

}
