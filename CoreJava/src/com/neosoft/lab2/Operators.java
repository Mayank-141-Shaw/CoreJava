package com.neosoft.lab2;

public class Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10, b=20;
		
		// Increment and decrement operators
		// ++ and --
		System.out.println("a post-increment = "+ a++);
		System.out.println("a pre-increment = "+ ++a);
		
		System.out.println("b post-decrement = "+ b--);
		System.out.println("b pre-decrement = "+ --b);
		
		// Bitwise complement operator
		System.out.println("Bitwise complement of "+a+" is "+ ~a);
		
		
		// Arithmetic operations
		System.out.println("Sum of "+a+" and "+b+ " is "+(a+b));
		System.out.println("Subtract of "+a+" and "+b+ " is "+(a-b));
		System.out.println("Multiply of "+a+" and "+b+ " is "+(a*b));
		System.out.println("Division of "+a+" and "+b+ " is "+(a/b));
		System.out.println("Modulus of "+a+" and "+b+ " is "+(a%b));
		
		// Relational Operators
		if(a>b) System.out.printf("%d is greater than %d\n", a,b);
		if(a<b) System.out.printf("%d is lesser than %d\n", a,b);
		if(a>=b) System.out.printf("%d is greater or equal to %d\n", a,b);
		if(a<=b) System.out.printf("%d is lesser or equal to %d\n", a,b);
		if(a==b) System.out.printf("%d is equal to %d\n", a,b);
		if(a!=b) System.out.printf("%d is not equal to %d\n", a,b);
		
		
		// Bitwise operators
		System.out.println("Bitwise AND of "+a+" and "+b+" is "+(a&b));
		System.out.println("Bitwise OR of "+a+" and "+b+" is "+(a|b));
		System.out.println("Bitwise XOR of "+a+" and "+b+" is "+(a^b));
		System.out.println("Bitwise Left Shift of "+a+" is "+(a<<2));
		System.out.println("Bitwise Right Shift of "+a+" is "+(a>>2));
		System.out.println("Bitwise Zero fill right shift of "+a+" is "+(a>>>2));
		
		
		// Conditional operator
		boolean t=true, f=false;
		if(t && f) System.out.println("And condition");
		if(t || f) System.out.println("OR condition");
		if(!f) System.out.println("Not operation");
		
		// Ternary
		System.out.println("The greater number is "+ ( (a>b)?a:b) );
		
	}

}
