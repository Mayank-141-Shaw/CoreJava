package com.neosoft.lab2;
import java.util.Scanner;

public class MatrixOps {
	public static void main(String args[]) {
		int a[][] = new int[2][2];
		int b[][] = new int[2][2];
		int c[][] = new int[2][2];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first array elements");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter second array elements");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				b[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Addition");
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.print( (a[i][j] + b[i][j]) + " ");
			}
			System.out.println();
		}
		
		int sum=0;
		System.out.println("Multiplication");
		for (int i= 0 ; i < 2 ; i++ ){
			for (int j= 0 ; j <2;j++){
				sum=0;
				for (int k= 0 ; k <2;k++ ){
					sum +=a[i][k]*b[k][j] ;	 
				}
			c[i][j]=sum;
			}
		}
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				System.out.print( c[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
