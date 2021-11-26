package com.session.jsp;

public class Account {
	public static int acc_balance = 25000;
	
	public static String withdraw(int amount) {
		try {
			if(amount > acc_balance) {
				throw new WithdrawException("Withdrawal Amount cannot be less than balance");
			}else {
				acc_balance -= amount;
				return "<span>Amount withdrawn successfully</span>";
			}
		}catch(WithdrawException e){
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}
	
	public static String showBalance() {
		return "<span>Account Balance : "+acc_balance+"</span>";
	}
}
