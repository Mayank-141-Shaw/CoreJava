package com.session;

public class P5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account ac = new Account(25000);
		
		ac.withdraw(30000);
		ac.withdraw(20000);
		ac.showBalance();
		ac.withdraw(10000);
		ac.showBalance();
	}

}

class Account{
	private int acc_balance;
	
	Account(int val){
		this.acc_balance = val;
	}
	
	// withdraw money
	void withdraw(int amount) {
		try {
			if(amount > this.acc_balance) {
				throw new WithdrawException("Insufficient Balance");
			}
			this.acc_balance -= amount;
			
		}catch(WithdrawException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// show the balance
	void showBalance() {
		System.out.println("Current Balance = Rs"+this.acc_balance);
	}
	
	// add money
	void deposit(int amount) {
		this.acc_balance += amount;
	}
}

@SuppressWarnings("serial")
class WithdrawException extends Exception{
	String msg;
	
	public WithdrawException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String toString() {
		return "Withdraw Exception : "+this.msg;
	}
}