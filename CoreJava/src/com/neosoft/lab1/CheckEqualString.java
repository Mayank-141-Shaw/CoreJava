package com.neosoft.lab1;

public class CheckEqualString {
	public static void main(String args[]) {
		String s1 = "Mayank", s2 = "mayank";
		if(s1.equals(s2)) System.out.println("Strings are exactly equal");
		else System.out.println("Strings are not exactly equal");
		
		if(s1.equalsIgnoreCase(s2)) System.out.println("Strings are identical");
		else System.out.println("Strings are not identical");
		
		if(s1==s2) System.out.println("Strings are equal by == operator");
		else System.out.println("Strings are not equal by == operator");
	}
}
