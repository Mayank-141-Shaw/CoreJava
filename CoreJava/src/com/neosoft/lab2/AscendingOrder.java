package com.neosoft.lab2;

public class AscendingOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {20, 56, 89, 10, 8, 97, 101, 3, 14, 30, 26, 55};
		
		// sort in ascending order
		int temp = 0;  
        for(int i=0; i < arr.length; i++){  
            for(int j=1; j < (arr.length-i); j++){  
                if(arr[j-1] > arr[j]){  
                     //swap elements  
                     temp = arr[j-1];  
                     arr[j-1] = arr[j];  
                     arr[j] = temp;  
                }
            }         
        }
        
        System.out.println("The sorted array is");
        for(int i=0; i<arr.length; i++) {
        	System.out.print(arr[i]+" ");
        }
	}

}
