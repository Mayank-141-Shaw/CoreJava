package bankapp;

import java.io.*;
import java.util.Iterator;



public class BankOperations {
	
	String name, address, phone, username, password;
	int deposit;
	
	public BankOperations() {
		// TODO Auto-generated constructor stub
	}
	
	public void registerNewAccount(AccountHolders acc) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter name : ");
		name = br.readLine();
		System.out.print("Enter address : ");
		address = br.readLine();
		System.out.print("Enter contact number : ");
		phone = br.readLine();
		System.out.print("Set username : ");
		username = br.readLine();
		
		System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 "
				+ "uppercase, 1 special character[!@#$%^&*_]) : ");
		while(true) {
			password = br.readLine();
			if(password.matches("[0-9a-zA-Z\\!@#%\\^&\\*_]{8,}")) {
				break;
			}else {
				System.out.println("Invalid password condition. Set again :");
			}
		}
		System.out.println("Enter initial deposit : ");
		deposit = Integer.parseInt(br.readLine());
		
		acc.addNewMember(new Account(name, address, phone, username, password, deposit));
		
	
	}
	
	
	public void loginUser(AccountHolders acc) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter username : ");
		name = br.readLine();
		System.out.println("Enter password : ");
		String pass = br.readLine();
		// check details
		UserOperations uops = new UserOperations();
		
		Account ourAcc = uops.getAccountIfExists(acc, name, pass);
		
		// use this account to update or do any changes in this object
		// and then update the list with this account whenevr the change is made
		
		if(ourAcc == null){
			System.out.println("Account does not exists");
		}else {
			int ch;
			boolean keepLoop = true;
			while(keepLoop) {
				System.out.println("-----------------------------");
				System.out.println("           WELCOME           ");
				System.out.println("-----------------------------");
				System.out.println();
				System.out.println("1. Deposit");
				System.out.println("2. Transfer");
				System.out.println("3. Last 5 transactions");
				System.out.println("4. User Information");
				System.out.println("5. Show Balance");
				System.out.println("6. Log out");
				System.out.print("Enter your choice: ");
				ch = Integer.parseInt(br.readLine());
				switch(ch) {
				case 1:
					// add amount
					System.out.println("\nEnter amount : ");
					int amt = Integer.parseInt(br.readLine());
					
					uops.depositAmt(ourAcc, acc, amt);
					
					break;
				case 2:
					// transfer to an existing account
					// amount must not be greater than balance
					
					System.out.println("\nEnter payee username : ");
					String payee = br.readLine();
					System.out.println("Enter amount : ");
					int amountToPay = Integer.parseInt(br.readLine());
					
					uops.transferIfPayeeExists(ourAcc, acc, payee, amountToPay);
					
					break;
				case 3:
					// last 5  transactions 
					
					uops.getLast5Transactions(ourAcc);
					break;
				case 4:
					// holder details
					System.out.println("\n<<   Account Holder Details   >>");
					System.out.println("Account holder name : "+ourAcc.getName());
					System.out.println("Account holder address : "+ourAcc.getAddress());
					System.out.println("Account holder contact : "+ourAcc.getPhone());
					break;
				case 5:
					// show balance
					System.out.println("Account Balance : "+ourAcc.getBalance());
					break;
				case 6:
					// log out by changing keepLoop to false
					// update ourAcc before exiting the loop
					uops.updateAccountInfo(ourAcc, acc);
					keepLoop = false;
					break;
				default:
					System.out.println("<<   Wrong choice   >>");
				}
			}
		}
		
	}
	
	
	public void updateExistingAccount(AccountHolders accounts) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\nEnter username : ");
		name = br.readLine();
		System.out.println("Enter password : ");
		password = br.readLine();
		// check details
		
		UserOperations uops = new UserOperations();
		
		Account ourAcc = uops.getAccountIfExists(accounts, name, password);
		
		if(ourAcc == null) {
			System.out.println("<<   Account does not exist   >>");
		}else {
			// update user account
			System.out.println("Enter name to update");
			ourAcc.setName(br.readLine());
			System.out.println("Enter address to update");
			ourAcc.setAddress(br.readLine());
			System.out.print("Enter contact number to update ");
			ourAcc.setPhone(br.readLine());
			System.out.print("Enter username to update ");
			
			String password1, user;
			boolean userSet = false;
			while(!userSet) {
				user = br.readLine();
				Iterator<Account> iter = accounts.getMembers().listIterator();
				while(iter.hasNext() && !userSet) {
					if(iter.next().getUsername().equals(user)) {
						System.out.println("<<<  Username already exists. Try another username   >>");
						userSet = false;
						break;
					}else {
						userSet = true;
					}
				}
				if(userSet==true) ourAcc.setUsername(user);
			}
			
			System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 "
					+ "uppercase, 1 special character[!@#$%^&*_]) : ");
			while(true) {
				password1 = br.readLine();
				if(password1.matches("[0-9a-zA-Z\\!@#%\\^&\\*_]{8,}")) {
					break;
				}else {
					System.out.println("<<  Invalid password condition. Set again >>");
				}
			}
			ourAcc.setPassword(password1);
			
			// after all new changes are made update the account
			uops.updateAccountInfo(ourAcc, accounts);
		}

	}
	public void showAllHolderDetails(AccountHolders accounts) {
		// TODO Auto-generated method stub
		accounts.displayHolders();
	}
}
