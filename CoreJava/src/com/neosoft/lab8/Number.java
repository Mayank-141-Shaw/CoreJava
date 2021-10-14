package com.neosoft.lab8;

public class Number {
	private double num;

	public Number(int num){
		this.setNum(num);
	}
	
	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}
	
	public boolean isZero() {
		return this.num == 0;
	}
	
	public boolean isPositive() {
		return this.num >0;
	}
	
	public boolean isNegative() {
		return this.num < 0;
	}
	
	public boolean isOdd() {
		return (int)this.num%2!=0;
	}
	
	public boolean isEven() {
		return (int)this.num%2==0;
	}
	
	public boolean isPrime() {
		for(int i=2; i<=(int)(this.num/2); i++) {
			if((int)this.num%i==0) return false;
		}
		return true;
	}
		
	public boolean isArmstrong() {
		int n = (int)this.num, dig, sum=0;
		while(n!=0) {
			dig = n%10;
			sum = sum + (dig*dig*dig);
			n = (int)(n/10);
		}
		if(sum == (int)this.num) return true;
		return false;
	}
	
	public double getFactorial() {
		int n = (int)this.num;
		int f = 1;
		while(n!=1) {
			f = f*n--;
		}
		return f;
	}
	
	public double getSqrt() {
		return Math.sqrt(this.num);
	}
	
	public double Sqr() {
		return Math.pow(this.num, 2);
	}
	
	public double sumDigits() {
		String s = Double.toString(this.num);
		double sum = 0;
		int dig;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) != '.' ) {
				dig = Integer.parseInt(s.substring(i, i+1));
				sum += dig;
			}
		}
		return sum;
	}
	
	public double getReverse() {
		StringBuilder st = new StringBuilder(Double.toString(this.num));
		return Double.parseDouble(st.reverse().toString());
	}
	
	void listFactor() {
		int n = (int)this.num;
		for(int i=1; i <= n; i++) {
	           if(n % i == 0)
	               System.out.print(i+"\t");
	       }
	}
	
	void dispBinary() {
		System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(this.num)));
	}
	
}
