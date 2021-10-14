package com.neosoft.lab10;

public class UserDefExceptions {

	public static void main(String args[]) {
		int[] arr = {10, 11, 34, 78, 91, 50};
		try {
			for(int i=0; i<arr.length; i++) {
				if(arr[i]%2!=0) throw new OddNumberFoundException("Found at position "+i);
				else System.out.println(arr[i]);
			}
		}catch(OddNumberFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}

class OddNumberFoundException extends Exception{
	
	String msg;
	public OddNumberFoundException(String msg){
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "OddNumberFoundException : "+this.msg;
	}
}