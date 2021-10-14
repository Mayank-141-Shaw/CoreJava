package com.neosoft.lab2;

public class Triangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1; i<=9; i+=2) {
			for(int j=1; j<=i; j++) {
				if(j==i || j==1) {
					System.out.print(1);
				}else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		for(int i=5;i>=0;i--) {
			for(int j=i;j<=5;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		
		
		System.out.println();
		
		for(int i=1;i<=5;i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

}
