package com.session;

import java.io.*;
import java.util.*;
public class P15 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String emailFileName = "res/"+args[0];
		String domainFileName = "res/"+args[1];
		ArrayList<String> emails = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 5 emails");
		int i=0;
		String mailPattern = "\\w+\\.?\\w+@[a-z]+\\.com$";
		while(i<5) {
			String mail = sc.nextLine();
			if(mail.matches(mailPattern)) {
				emails.add(mail);
				i++;
			}else {
				System.out.println("Not a valid mail enter again");
			}
		}
		
		
		FileWriter fw = new FileWriter(emailFileName, true);
		BufferedWriter bw = new BufferedWriter(fw);
		Iterator<String> itr = emails.iterator();
		while(itr.hasNext()) {
			bw.write(itr.next());
			bw.newLine();
		}
		
		bw.close();
		fw.close();
		
		FileWriter domainFile = new FileWriter(domainFileName, true);
		BufferedWriter domainWriter = new BufferedWriter(domainFile);
		emails.forEach( mail -> {
			try {
				domainWriter.write(mail.substring(mail.indexOf('@')+1));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
