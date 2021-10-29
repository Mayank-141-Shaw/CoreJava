package bankapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class AccountHolders {
	
	private ArrayList<Account> members;

	
	static void serializeList(ArrayList<Account> accounts) throws IOException {
		FileOutputStream file = new FileOutputStream("res/accounts.txt");
		ObjectOutputStream oos = new ObjectOutputStream(file);
		
		oos.writeObject(accounts);
		
		oos.close();
		file.close();
	}
	
	@SuppressWarnings("unchecked")
	static ArrayList<Account> deserializeList() throws IOException{
		FileInputStream file = new FileInputStream("res/accounts.txt");
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(file);
		
		try {
			return (ArrayList<Account>)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public AccountHolders() {
		super();
		this.setMembers(new ArrayList<Account>());
	}

	public ArrayList<Account> getMembers() {
		// this.members data will be fetched from accounts.txt
		// by de-serialize
		try {
			this.members = AccountHolders.deserializeList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.members;
	}

	public void setMembers(ArrayList<Account> members) {
		// this.members value is going to be serialized
		// whenever it is set
		this.members = members;
		try {
			AccountHolders.serializeList(members);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addNewMember(Account member) {
		// get list by de-serialize
		// add new member
		// again serialize it
		try {
			this.members = AccountHolders.deserializeList();
			this.members.add(member);
			AccountHolders.serializeList(this.members);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayHolders() {
		// get the list display it
		try {
			this.members = AccountHolders.deserializeList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.members.forEach( holder -> holder.show() );
	}
}
