package com.neosoft.lab10;

import java.util.*;
public class ArraySizeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of array");
		try {
			int n = sc.nextInt();
			if(n<=0) {
				throw new ArrayIndexNegative("Array length cannot be negative");
			}
			int ar[] = new int[n];
			for(int i=0; i<n;i++) {
				ar[i] = i;
			}
			System.out.println("Array elements");
			for(int i=0; i<n; i++) {
				System.out.println(ar[i]);
			}
		}catch(ArrayIndexNegative e) {
			System.out.println(e.getMessage());
		}
		
	}

}

class ArrayIndexNegative extends Exception{
	String msg;
	
	ArrayIndexNegative(String msg){
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "ArrayIndexException : "+this.msg;
	}
}
