package bankapp;

import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// make the app console here
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		AccountHolders accounts = new AccountHolders();
		BankOperations bops = new BankOperations();
		
		int ch;
		while(true) {
			System.out.println("-----------------------------");
			System.out.println("       BANK OF MYBANK        ");
			System.out.println("-----------------------------");
			System.out.println();
			System.out.println("1. Register Account");
			System.out.println("2. Login");
			System.out.println("3. Update Account");
			System.out.println("4. Show all account holders");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			ch = Integer.parseInt(br.readLine());
			switch(ch) {
			case 1:
				// registering a new account
				bops.registerNewAccount(accounts);
				break;
			case 2:
				// the user will be logged in and run unless it log outs
				bops.loginUser(accounts);
				break;
			case 3:
				bops.updateExistingAccount(accounts);
				break;
			case 4:
				bops.showAllHolderDetails(accounts);
				break;
			case 5:
				System.out.println("\nThank you for using MyBank");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice");
			}
		}
	}
}
