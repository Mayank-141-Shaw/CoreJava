package com.neosoft.lab14;

public class CurrentThreadExp extends Thread {
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CurrentThreadExp t1 = new CurrentThreadExp();
		CurrentThreadExp t2 = new CurrentThreadExp();
		
		t1.start();
		t2.start();
	}

}
