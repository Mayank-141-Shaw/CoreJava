package com.neosoft.lab16;

public class Consumer implements Runnable {
	Stock s;
	Thread t;
	Consumer(Stock s){
		this.s = s;
		t = new Thread(this, "Consumer Thread");
		t.start();
	}
	
	public void run() {
		while(true) {
			try {
				t.sleep(750);
			}catch(InterruptedException e) {}
				s.getStock((int)(Math.random()*100));
		}
	}
	
	@SuppressWarnings("deprecation")
	void stop() {
		t.stop();
	}
}
