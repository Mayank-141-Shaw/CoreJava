package com.neosoft.lab14;

public class ThreadIsAlive extends Thread{
	
	ThreadIsAlive(){
		System.out.println("Starting the Thread");
		this.start();
	}

	public void run() {
		System.out.println("Is Alive : "+Thread.currentThread().isAlive());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadIsAlive t1 = new ThreadIsAlive();
		ThreadIsAlive t2 = new ThreadIsAlive();
		
	}
}
