package com.session;

public class P4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle(3);
		Triangle t = new Triangle(4,5);
		Square s = new Square(4.5);
		
		c.area();
		c.draw();
		t.area();
		t.draw();
		s.area();
		s.draw();
	}

}

class Shape{
	void area() {
		System.out.println("Calculating area");
	}
	void draw() {
		System.out.println("Drawing shape");
	}
}

class Circle extends Shape{
	double r;
	Circle(double r){
		super();
		this.r = r;
	}
	
	void area() {
		super.area();
		double area = Math.PI * this.r * this.r;
		System.out.println("Area of circle is = "+area);
	}
	
	void draw() {
		super.draw();
		System.out.println("Drawing Circle with center at (0,0) and radius "+this.r);
	}
}

class Triangle extends Shape{
	double height;
	double base;
	public Triangle(double height, double base) {
		super();
		this.height = height;
		this.base = base;
	}
	
	void area() {
		super.area();
		double area = 0.5 * this.base * this.height;
		System.out.println("Area of triangle is = "+area);
	}
	
	void draw() {
		super.draw();
		System.out.println("Drawing a triangle with height = "+this.height+" and base = "+this.base);
		System.out.println("Its cordinates are \n"+
						"A(0,0) B(0,"+this.height+") C("+this.base+",0)");
	}
}

class Square extends Shape{
	double side;
	public Square(double side) {
		this.side = side;
	}
	
	void area() {
		super.area();
		double area = this.side * this.side;
		System.out.println("Area of square is = "+area);
	}
	
	void draw() {
		super.draw();
		System.out.println("Drawing a square with side of length = "+this.side);
		System.out.println("Its cordinates are \n"
				+ "A(0,0) "+"B("+this.side+",0)"+" C("+this.side+","+this.side+") D(0,"+this.side+")");
	}
}