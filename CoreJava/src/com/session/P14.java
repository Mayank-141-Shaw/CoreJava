package com.session;

import java.io.*;
public class P14 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader fr = new FileReader("res/p14.txt");
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter("res/p14write.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line;
		int lines=0, words=0;
		
		while((line = br.readLine()) != null) {
			if(line.toLowerCase().contains("java")) {
				lines++;
				words += line.split("\\s").length;
				bw.write(line);
				bw.newLine();
			}
		}
		
		br.close();
		bw.close();
		fr.close();
		fw.close();
		System.out.println("No. of lines printed : "+lines);
		System.out.println("No of words printed : "+words);
	}

}
