package com.neosoft.lab13;

public class ThreadRunner {
	public static void main(String args[]) {
		new MyThread();
		try {
			for(int k=5; k>0; k--) {
				System.out.println("Running main Thread : "+k);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			System.out.println("Exiting main thread .. ");
		}
	}
	
}

class MyThread extends Thread{
	MyThread(){
		super("Using Thread Class");
		System.out.println("Child Thread "+ this);
		start();
	}
	
	public void run() {
		try {
			for(int i=5; i>=0; i--) {
				System.out.println("Child Thread "+i);
				Thread.sleep(500);
			}
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
