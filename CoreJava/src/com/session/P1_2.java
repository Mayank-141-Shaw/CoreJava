package com.session;

import java.util.*;
public class P1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int row = sc.nextInt();
		int k = 1;
		for(int i=1; i<=row; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(k++ +" ");
			}
			System.out.println();
		}
	}

}
