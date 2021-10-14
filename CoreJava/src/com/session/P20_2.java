package com.session;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.io.*;
public class P20_2 {
	
	static void serializeList(List<Account2> accounts) throws IOException {
		FileOutputStream file = new FileOutputStream("res/accounts.txt");
		ObjectOutputStream oos = new ObjectOutputStream(file);
		
		oos.writeObject(accounts);
		
		oos.close();
		file.close();
	}
	
	@SuppressWarnings("unchecked")
	static ArrayList<Account2> deserializeList() throws IOException{
		FileInputStream file = new FileInputStream("res/accounts.txt");
		ObjectInputStream ois = new ObjectInputStream(file);
		
		try {
			return (ArrayList<Account2>)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// every time you want to update or access the array list use the methods
		Scanner sc = new Scanner(System.in);
		List<Account2> accounts = new ArrayList<Account2>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		serializeList(accounts);
		int ch;
		while(true) {
			System.out.println("-----------------------------");
			System.out.println("       BANK OF MYBANK        ");
			System.out.println("-----------------------------");
			System.out.println();
			System.out.println("1. Register Account");
			System.out.println("2. Login");
			System.out.println("3. Update Account");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			ch = Integer.parseInt(br.readLine());
			switch(ch) {
			case 1:
				// registering a new account
				System.out.print("Enter name : ");
				String name = br.readLine();
				System.out.print("Enter address : ");
				String address = br.readLine();
				System.out.print("Enter contact number : ");
				String phone = br.readLine();
				System.out.print("Set username : ");
				String username = br.readLine();
				String password;
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
				int deposit = Integer.parseInt(br.readLine());
				
				accounts = deserializeList();
				accounts.add(new Account2(name, address, phone, username, password, deposit));
				serializeList(accounts);
				break;
				
			case 2:
				System.out.println("Enter username : ");
				String name1 = br.readLine();
				System.out.println("Enter password : ");
				String pass = br.readLine();
				// check details
				// get the list
				accounts = deserializeList();
				Iterator<Account2> itr = accounts.iterator();
				Account2 ourAcc = null;
				while(itr.hasNext()) {
					Account2 temp = itr.next();
					if(temp.username.equals(name1) && temp.password.equals(pass)) {
						ourAcc = temp;
						break;
					}
				}
				if(ourAcc == null){
					System.out.println("Account does not exists");
				}else {
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
						System.out.println("5. Log out");
						System.out.print("Enter your choice: ");
						ch = Integer.parseInt(br.readLine());
						switch(ch) {
						case 1:
							// add amount
							System.out.println("Enter amount : ");
							int amt = Integer.parseInt(br.readLine());
							ourAcc.deposit(amt);
							break;
						case 2:
							// transfer to an existing account
							// amount must not be greater than balance
							
							System.out.println("Enter payee username : ");
							String payee = br.readLine();
							System.out.println("Enter amount : ");
							int amountToPay = Integer.parseInt(br.readLine());
							
							if(ourAcc.balance < amountToPay) {
								System.out.println("Balance not sufficient");
							}else {
								boolean payeeExists = false;
								Iterator<Account2> itr1 = accounts.iterator();
								while(itr1.hasNext()) {
									Account2 temp = itr1.next();
									if(temp.username.equals(payee)) {
										payeeExists = true;
										temp.deposit(amountToPay);
										break;
									}
								}
								if(!payeeExists) System.out.println("Username does not exist");
							}
							break;
						case 3:
							// last 5  transactions 
							int len = ourAcc.trans.size();
							int lastIndex = len - 1;
						
							if(len >=5) {
								for(int i=0; i<5; i++) {
									System.out.println(ourAcc.trans.get(lastIndex - i));
								}
							}else {
								for(int i=0; i<len; i++) {
									System.out.println(ourAcc.trans.get(lastIndex - i));
								}
							}
							break;
						case 4:
							// holder details
							System.out.println("Account holder name : "+ourAcc.name);
							System.out.println("Account holder address : "+ourAcc.address);
							System.out.println("Account holder contact : "+ourAcc.phone);
							break;
						case 5:
							// log out by changing keepLoop to false
							keepLoop = false;
							break;
						default:
							System.out.println("Wrong choice");
						}
					}
				}
				
				serializeList(accounts);
				break;
			case 3:
				// update your account details
				System.out.println("Enter username : ");
				String name2 = br.readLine();
				System.out.println("Enter password : ");
				String pass1 = br.readLine();
				// check details
				accounts = deserializeList();
				Iterator<Account2> itr2 = accounts.iterator();
				Account2 ourAcct = null;
				while(itr2.hasNext()) {
					Account2 temp = itr2.next();
					if(temp.username.equals(name2) && temp.password.equals(pass1)) {
						ourAcct = temp;
						break;
					}
				}
				if(ourAcct == null) {
					System.out.println("Account does not exist");
				}else {
					System.out.println("Enter name to update");
					ourAcct.name = br.readLine();
					System.out.println("Enter address to update");
					ourAcct.address = br.readLine();
					System.out.print("Enter contact number to update ");
					ourAcct.phone = br.readLine();
					System.out.print("Enter username to update ");
					
					String password1, user;
					boolean userSet = false;
					while(!userSet) {
						user = br.readLine();
						Iterator<Account2> iter = accounts.iterator();
						while(iter.hasNext() && !userSet) {
							
							if(iter.next().username.equals(user)) {
								System.out.println("Username already exists. Try another username : ");
								userSet = false;
								break;
							}else {
								userSet = true;
							}
						}
						if(userSet==true) ourAcct.username = user;
					}
					
					System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 "
							+ "uppercase, 1 special character[!@#$%^&*_]) : ");
					while(true) {
						password1 = sc.nextLine();
						if(password1.matches("[0-9a-zA-Z\\!@#%\\^&\\*_]{8,}")) {
							break;
						}else {
							System.out.println("Invalid password condition. Set again :");
						}
					}
					ourAcct.password = password1;
				}
				
				serializeList(accounts);
				break;
			case 4:
				System.out.println("Thank you for banking with MyBank");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice");
			}
		}
	}

}


class Account2 implements Serializable{
	String name;
	String address;
	String phone;
	String username;
	String password;
	int balance;
	String inputTime;
	List<String> trans = new ArrayList<String>();
	public Account2(String name, String address, String phone, String username, String password, int balance) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.balance = balance;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		this.inputTime = dtf.format(now);
		this.trans.add("Initial deposit - Rs"+this.balance+" as on "+this.inputTime);
	}
	
	public void deposit(int amt) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		this.inputTime = dtf.format(now);
		this.balance += amt;
		this.trans.add("Rs "+amt+" credited to your account. Balance - Rs "+this.balance+" as on "+this.inputTime);
	}
	
	
}
