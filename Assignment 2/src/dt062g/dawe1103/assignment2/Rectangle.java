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
		double width;
		if(points[0].getValueX() > points[1].getValueX()) {
			width = points[0].getValueX() - points[1].getValueX();
		}
		else {
			width = points[1].getValueX() - points[0].getValueX();
		}
			
	
		
		return width;
	}
	
	
	public double getHeight()
	{
		double height;
		if(super.points[0].getValueX() > super.points[1].getValueX()) {
			height = super.points[0].getValueY() - super.points[1].getValueY();
		}
		else {
			height = super.points[1].getValueY() - super.points[0].getValueY();
		}
			
	
		
		return height;
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
		
		if(getHeight() > 0 && getWidth() > 0) {
			return (getHeight()*2)+(getWidth()*2);
		}
		else
			return -1;
		
	}


	@Override
	public double getArea() {
		if(getHeight() > 0 && getWidth() > 0) {
		return getHeight()*getWidth();
		}
		else
			return -1;
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

