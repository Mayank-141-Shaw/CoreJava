package com.neosoft.lab8;

public class Point {
	private int x,y;
	
	public Point() {
		this.setX(0);
		this.setY(0);
	}
	
	public Point(int x, int y) {
		this.setXY(x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
