package com.session.jsp;

public class WithdrawException extends Exception {

	private static final long serialVersionUID = 1L;
	
	String msg;
	public WithdrawException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
