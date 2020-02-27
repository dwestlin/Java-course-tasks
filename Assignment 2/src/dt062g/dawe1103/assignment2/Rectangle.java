package dt062g.dawe1103.assignment2;

import java.awt.Graphics;

/**
* <h1>Rectangle</h1>
* This sub-class creates a rectangle from the super-class Shape. 
* It can calculate radius, circumference, area as well as print information about these.
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-16
*/


public class Rectangle extends Shape {

	
	Rectangle(Point p, String color){
		super(p, color);
	}
	
	
	Rectangle(double x, double y, String color){
	
		super(new Point(x,y), color);
		
	}
	
	public double getWidth() {	
		if(points[1] == null) {
			return -1;
		}
		return Math.abs(points[0].getX() - points[1].getX());
	}
	
	
	public double getHeight()
	{
		if(points[1] == null) {
			return -1;
		}
		return Math.abs(points[0].getY() - points[1].getY());
	}


	@Override
	public void draw() {
		System.out.println(toString());
		
	}


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public double getCircumference() {
		if(points[0] == null || points[1] == null) {
			return -1;
		}
		
		return (getHeight() * 2) + (getWidth() * 2);
	}


	@Override
	public double getArea() {
		if(points[0] == null || points[1] == null) {
			return -1;
		}
		
		return getHeight() * getWidth();
	}
	
	
	public String toString() {
		
		if(super.points[0] == null)
			return "Drawing a Rectangle[start=N/A; end=N/A; width=N/A; height=N/A; color="+getColor()+"]";
		else if(super.points[1] == null)
			return "Drawing a Rectangle[start="+super.points[0]+"; end=N/A; width=N/A; height=N/A; color="+getColor()+"]";
		else
			return "Drawing a Rectangle[start="+super.points[0]+"; end="+super.points[1]+"; width="+getWidth()+"; height="+getHeight()+"; color="+getColor()+"]";
		
		
	}
	
}

