package com.session;

import java.util.Scanner;
public class P1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scs = new Scanner(System.in);
		int arr[] = new int[5];
		System.out.println("Enter 5 elements");
		for(int i=0;i<5;i++) {
			arr[i] = scs.nextInt();
		}
		
		int min=99999999, max=-99999999, p=-1, q=-1;
		for(int i=0; i<5;i++) {
			if(arr[i] < min) {
				min = arr[i];
				p=i;
			}
			if(arr[i] > max) {
				max = arr[i];
				q = i;
			}
		}
		
		// now swapping;
		int temp = arr[p];
		arr[p] = arr[q];
		arr[q] = temp;
		
		System.out.println("Modified array is");
		
		for(int i=0; i<5; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
