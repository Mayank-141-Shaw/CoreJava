package com.session;

public class P6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}

class Thread1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		StringBuilder str = new StringBuilder("Java is nice");
		str.reverse();
		for(int i=0; i<str.length(); i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(str.charAt(i)+"");
		}
		System.out.println();
	}
}

class Thread2 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		StringBuilder str = new StringBuilder("Java is nice");
		for(int i=0; i<str.length(); i+=2) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(str.charAt(i)+" ");
		}
		System.out.println();
	}
}