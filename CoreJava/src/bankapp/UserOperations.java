package bankapp;

import java.util.*;
public class UserOperations {
	
	public UserOperations(){}

	public Account getAccountIfExists(AccountHolders acc, String name, String pass) {
		// wiil return the account if it exists else null
		Iterator<Account> itr = acc.getMembers().listIterator();
		while(itr.hasNext()) {
			Account temp = itr.next();
			if(temp.getUsername().equals(name) && temp.getPassword().equals(pass)) {
				return temp;
			}
		}
		return null;
		
	}
	
	public Account getAccountByUsernameIfExists(AccountHolders acc, String username) {
		Iterator<Account> itr = acc.getMembers().listIterator();
		while(itr.hasNext()) {
			Account temp = itr.next();
			if(temp.getUsername().equals(username)) {
				return temp;
			}
		}
		return null;
	}

	public void transferIfPayeeExists(Account ourAcc, AccountHolders acc, String payee, int amtToPay) {
		// TODO Auto-generated method stub
		if(ourAcc.getBalance() < amtToPay) {
			System.out.println("<<   Balance not sufficient   >>");
		}else {
			Account payeeAcc = this.getAccountByUsernameIfExists(acc, payee);
			if(payeeAcc == null) {
				System.out.println("<<   Payee does not exist   >>");
			}else {
				// first debit from user account
				this.debitAmt(ourAcc, acc, amtToPay);
				// deposit through depositAmt only
				this.depositAmt(payeeAcc, acc, amtToPay);
				System.out.println("<<   Transfered to "+payee+" account   >>");
			} 
		}
	}

	public void getLast5Transactions(Account ourAcc) {
		// print the last 5 transactions
		
		int len = ourAcc.getTransactions().size();
		int lastIndex = len - 1;
	
		System.out.println("<<  Last 5 Transactions  >>");
		if(len >=5) {
			for(int i=0; i<5; i++) {
				System.out.println(ourAcc.getTransactions().get(lastIndex - i));
			}
		}else {
			for(int i=0; i<len; i++) {
				System.out.println(ourAcc.getTransactions().get(lastIndex - i));
			}
		}
	}
	
	public void updateAccountInfo(Account ourAcc, AccountHolders acc) {
		
		// get the account from acc by checking its username and password
		// then update that with ourAcc
		// serialize 
		ArrayList<Account> accounts = acc.getMembers();
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getUsername().equals(ourAcc.getUsername()) && 
					accounts.get(i).getPassword().equals(ourAcc.getPassword())) {
				// accounts 
				accounts.set(i, ourAcc);
				break;
			}
		};
		// now as the list is updated we will replace old list with this new accounts list
		acc.setMembers(accounts);
		// the updated account is replaced and now its done
	}

	public void depositAmt(Account ourAcc, AccountHolders acc, int amt) {
		
		// use deposit() of account
		// and then updateAccountInfo()
		ourAcc.deposit(amt);
		this.updateAccountInfo(ourAcc, acc);
		
	}
	
	
	public void debitAmt(Account ourAcc, AccountHolders acc, int amt) {
		// use deposit() of account with -ve amount
		// and then updateAccountInfo()
		ourAcc.deposit(-amt);
		this.updateAccountInfo(ourAcc, acc);
	}

	

	
	
}
