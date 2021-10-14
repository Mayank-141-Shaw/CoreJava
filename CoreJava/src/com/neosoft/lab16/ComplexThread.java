package com.neosoft.lab16;

public class ComplexThread extends Thread{

	private int delay;
	
	ComplexThread(String name, float seconds){
		super(name);
		this.delay = (int)seconds*1000;
		start();
	}
	
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(this.delay);
			}catch(InterruptedException e) {
				return;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ComplexThread("One Potato", 1.1f);
		new ComplexThread("Two Potato", 1.3f);
		new ComplexThread("Three Potato", 0.5f);
		new ComplexThread("Four Potato", 0.7f);
		
	}

}
