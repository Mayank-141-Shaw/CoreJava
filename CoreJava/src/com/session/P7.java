package com.session;

public class P7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t1 = new MyThread(2,5);
		MyThread t2 = new MyThread(3,7);
		t1.start();
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		t2.start();
	}

}

class SharedResource{
	
	synchronized void doPrint(int i, int j) {
		for(int k=i; k<=j+i; k++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" "+k+" ");
		}
		System.out.println();
	}
}

class MyThread extends Thread{
	int i,j;
	MyThread(int i, int j){
		this.i = i;
		this.j = j;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		SharedResource s = new SharedResource();
		s.doPrint(this.i, this.j);
		
	}
}