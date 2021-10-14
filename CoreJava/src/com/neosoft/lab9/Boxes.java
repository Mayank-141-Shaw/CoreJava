package com.neosoft.lab9;

public class Boxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box3D box = new Box3D(4,6,10);
		System.out.println("Surface area of the box = "+box.area());
		System.out.println("Volume of the box = "+box.volume());
	}

}

class Box{
	
	private int x;
	private int y;
	public Box(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return this.y;
	}
	
	public double perimeter() {
		return 2*(this.x+this.y);
	}
	
	public double area() {
		return this.x*this.y;
	}
	
}


class Box3D extends Box{
	
	private int z;
	Box3D(int x, int y, int z){
		super(x,y);
		this.z = z;
	}
	
	public void setZ(int z) {
		this.z = z;
	}
	
	public int getZ() {
		return this.z;
	}
	
	// surface area of cuboid = 2*(lw + lh + wh)
	// ===> 2lw + 2(l+w)*h
	// ===> 2*area + perimeter*h
	
	public double area() {
		return 2*super.area() + super.perimeter()*this.z;
	}
	
	public double volume() {
		return super.area()*this.z;
	}
}