package com.neosoft.lab2;

public class ArrayOps {
	public static void main(String args[]) {
		int arr[] = new int[10];
		
		// a 1D array
		for(int i=0; i<arr.length; i++) {
			arr[i] = i*10;
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		// a 2D array
		int a2[][] = new int[5][5];
		for(int i=0; i<a2.length; i++) {
			for(int j=0; j<a2[i].length; j++) {
				a2[i][j] = i*i + j*j;
			}
		}
		
		for(int i=0; i<a2.length; i++) {
			for(int j=0; j<a2[i].length; j++) {
				System.out.print(a2[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		// a n-d array
		int a3[][][] = new int[5][5][5];
		for(int i=0; i<a3.length; i++) {
			for(int j=0; j<a3[i].length; j++) {
				for(int k=0; k<a3[i][j].length; k++) {
					a3[i][j][k] = i*i + j*j + k*k;
				}
			}
		}
		
		for(int i=0; i<a3.length; i++) {
			for(int j=0; j<a3[i].length; j++) {
				for(int k=0; k<a3[i][j].length; k++) {
					System.out.print(a3[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
