package com.neosoft.lab11;

import java.io.*;
public class FileRename {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i<args.length; i++)
		{
			File f = new File("C:\\java", args[i]);
			File f1 = new File("C:\\java\\refile");
			if (f.exists())
			{
				System.out.println(f + " does exists.");
				System.out.println("Its size is" + f.length()+ "bytes");
				f.renameTo(f1);
				System.out.println("Renamed file name :" + f1 + (i+1));
				System.out.println("Deleting the renamed file"+f1+(i+1));
				System.out.println ("=======================");
				f.delete();
			}
			else System.out.println(f +" does not exists");
		}
	}

}
