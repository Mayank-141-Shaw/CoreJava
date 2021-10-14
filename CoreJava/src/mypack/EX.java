package mypack;
import p1.*;

public class EX {
	
	private int val=0;
	
	public void display() {
		System.out.println("EX was created");
		Ex1 e=new Ex1();
		e.display();
	}
	
	protected void show() {
		System.out.println("This is a protected method which was called inside getVal method");
	}
	
	public int getVal() {
		this.show();
		return this.val;
	}

}
