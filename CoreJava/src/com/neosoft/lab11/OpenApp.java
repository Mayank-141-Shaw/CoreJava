package com.neosoft.lab11;
import java.io.*;
public class OpenApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		Runtime r;
		r = Runtime.getRuntime();
		System.out.println(r.freeMemory());
		int x[] = {1};
		r.gc();
		System.out.println(r.freeMemory());
		Process p = r.exec(chromePath);
		System.out.println(r.freeMemory());
	}

}
