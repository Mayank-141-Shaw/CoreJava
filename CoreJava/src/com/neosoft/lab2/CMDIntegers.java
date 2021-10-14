package com.neosoft.lab2;

public class CMDIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// printing sum of cmd integers
		int n, cnt=0, sum=0;
		for(int i=0;i<args.length;i++)
		{
			try
			{
				n=Integer.parseInt(args[i]);
				sum= sum+n;
			}
			catch (NumberFormatException e)
			{
				//system.out.println("invalid integer:");
				cnt++;
			}
		}
		System.out.println("Sum of only valid integers is= "+sum) ;

		System.out.println("Invalid integers are: "+cnt) ;
	}

}
