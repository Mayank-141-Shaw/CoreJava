package com.neosoft.lab11;

import java.io.*;

public class DirCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File newDir = new File("res\\newDir");
		boolean value = newDir.mkdir();
		if(value) {
			System.out.println("New Directory created");
		}else {
			System.out.println("The directory already exists at the path");
		}
		System.out.println(newDir.getAbsolutePath());
	}

}
