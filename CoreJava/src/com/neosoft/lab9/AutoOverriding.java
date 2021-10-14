package com.neosoft.lab9;

public class AutoOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10234;
		byte b = 98;
		short s = b;
		long l = i;
		float f = l;
		double d = f;
		System.out.println("Integer : "+i);
		System.out.println("Byte : "+b);
		System.out.println("SHort : "+s);
		System.out.println("Long : "+l);
		System.out.println("Float : "+f);
		System.out.println("DOuble : "+d);
		System.out.println();
		System.out.println("Overiding Types");
		System.out.println("DOuble to float : "+(float)d);
		System.out.println("DOuble to long : "+(long)d);
		System.out.println("Double to integer : "+(int)d);
		System.out.println("Double to short : "+(short)d);
		System.out.println("Double to byte : "+(byte)d);
		System.out.println("DOuble to char : "+(char)d);
		System.out.println("Integer to short : "+(short)i);
		System.out.println("Integer to byte : "+(byte)i);
	}

}
