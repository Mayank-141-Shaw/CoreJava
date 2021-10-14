package com.neosoft.lab12;

import java.io.*;
public class FileMaker {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string to store in a file");
		String st = br.readLine();
		
		FileWriter fw = new FileWriter("res/output.txt");
		for(int i=0; i<st.length(); i++) {
			fw.write(st.charAt(i));
		}
		System.out.println("Writing successful");
		fw.close();
	}

}
