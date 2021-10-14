package com.neosoft.lab5;

public class ShapesAbstract {
	
	public static void main(String args[]) {
		
		Circle c = new Circle();
		c.draw();
		
		Triangle t = new Triangle();
		t.draw();
	}
}

abstract class Shape {
	abstract void draw(); 
	abstract void erase();	
}


class Circle extends Shape{
	@Override
	public void draw() { System.out.println("Drawn a circle"); }
	public void erase() { System.out.println("Erased a circle"); }
}


class Triangle extends Shape{
	@Override
	public void draw() {System.out.println("Drawn a triangle"); }
	public void erase() { System.out.println("Erased a triangle"); }
}

class Square extends Shape{
	@Override
	public void draw() { System.out.println("Drawn a square"); }
	public void erase() {System.out.println("Erased a square"); }
}
