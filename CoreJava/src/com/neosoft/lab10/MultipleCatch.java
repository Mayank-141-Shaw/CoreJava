package com.neosoft.lab10;
import com.neosoft.lab8.*;
import com.neosoft.lab8.Number;

public class MultipleCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Number num = new Number(20);
			int arr[] = new int[5];
			for(int i=0; i<5; i++) {
				System.out.println(num.getNum()/arr[i]);
			}
			System.out.println(num.isNegative()?"Number is negative":"Number not negative");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("The program will terminate");
		}
	}

}
