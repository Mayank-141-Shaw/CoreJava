package com.neosoft.lab5;


class ShapeN{
	public void draw() { System.out.println("The shape drawn is "); }
	public void erase() { System.out.println("The shape erased is "); }
}

class CircleN extends ShapeN{
	public void draw() { System.out.println("Circle was drawn"); }
	public void erase() { System.out.println("Circle was erased"); }
}

class TriangleN extends ShapeN{
	public void draw() { System.out.println("Triangle was drawn"); }
	public void erase() { System.out.println("Triangle was erased"); }
}

class SquareN extends ShapeN{
	public void draw() { System.out.println("Square was drawn"); }
	public void erase() { System.out.println("Square was erased"); }
}




public class Shapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeN circle = new CircleN();
		ShapeN triangle = new TriangleN();
		ShapeN square = new SquareN();
		ShapeN shape = new ShapeN();
		
		shape.draw();
		shape.erase();
		circle.draw();
		triangle.draw();
		square.draw();
		circle.erase();
		triangle.erase();
		square.erase();
	}

}
