package com.neosoft.lab16;

public class Producer implements Runnable{
	Stock s;
	Thread t;
	Producer(Stock s){
		this.s = s;
		t = new Thread(this, "Producer Thread");
		t.start();
	}
	
	public void run() {
		while(true) {
			try {
				t.sleep(750);
			}catch(InterruptedException e) {}
				s.addStock((int)(Math.random()*100));
		}
	}
	@SuppressWarnings("deprecation")
	void stop() {
		t.stop();
	}
}
