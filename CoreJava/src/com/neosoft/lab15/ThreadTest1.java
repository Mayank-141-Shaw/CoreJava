package com.neosoft.lab15;

public class ThreadTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 t1 = new MyThread1("Thread 1: ");
		MyThread1 t2 = new MyThread1("Thread 2: ");
		
		t1.start();
		t2.start();
		
		boolean thread1IsAlive = true;
		boolean thread2IsAlive = true;
		
		do {
			if(thread1IsAlive && !t1.isAlive()) {
				thread1IsAlive = false;
				System.out.println("Thread 1 is dead");
			}
			if(thread2IsAlive && !t2.isAlive()) {
				thread2IsAlive = false;
				System.out.println("Thread 2 is dead");
			}
		}while(thread1IsAlive || thread2IsAlive);
	}

}

class MyThread1 extends Thread{
	static String message[] = {"java", "is", "hot", "aromatic", "and", "invigorating"};
	public MyThread1(String id) {
		super(id);
	}
	
	public void run() {
		String name = getName();
		for(int i=0; i<message.length; i++) {
			randomWait();
			System.out.println(name+message[i]);
		}
	}
	void randomWait() {
		try {
			sleep((long)(3000*Math.random()));
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted!");
		}
	}
}