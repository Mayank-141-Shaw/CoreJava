package com.neosoft.lab13;

public class ThreadMaker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IntThread();
	}

}

class IntThread extends Thread{
	Thread t;
	IntThread(){
		t = new Thread(this, "Test Thread");
		System.out.println("Child thread : "+t);
		t.start();
	}
	
	public void run() {
		try {
			for(int i=5; i>=0; i--) {
				System.out.println("Main Thread : "+i);
				Thread.sleep(500);
			}
		}catch(InterruptedException e) {
			System.out.println("Main Thread Exiting");
		}
	}
}