package com.neosoft.lab2;
import java.util.Scanner;

public class PrimeAndSum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();
		
		// check if prime
		boolean flag = false;
		for(int i=2; i<=Math.floor(num/2); i++) {
			if(num%i == 0) {
				flag = true;
				break;
			}
		}
		if(flag) System.out.println(num+" is not a prime number");
		else System.out.println(num + " is a prime number");
		
		
		// sum of its digits
		int dig, sum=0;
		while(num!=0) {
			dig = num%10;
			sum+=dig;
			num = num/10;
		}
		System.out.println("Sum of the digits is "+sum);
	}
}
