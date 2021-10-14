package com.neosoft.lab7;

import java.util.*;
public class RecursiveMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter array");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Max Value is "+findMax(arr, n-1));
		
	}
	
	static int findMax(int[] arr, int index) {
		if (index > 0) {
	        return Math.max(arr[index], findMax(arr, index-1));
	    } else {
	        return arr[0];
	    }
	}
}
