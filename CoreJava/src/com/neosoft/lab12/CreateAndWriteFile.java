package com.neosoft.lab12;

import java.io.*;
import java.io.DataInputStream;

public class CreateAndWriteFile {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("res\\file.txt");
		DataInputStream dis = new DataInputStream(System.in);
		FileOutputStream fs = new FileOutputStream(file, true);
		BufferedOutputStream bs = new BufferedOutputStream(fs, 1024);
		System.out.println("Enter text (with @ at the end)");
		char ch;
		
		while((ch=(char)dis.read())!='@') {
			bs.write(ch);
		}
		bs.close();
		fs.close();
		dis.close();
		
	}

}
