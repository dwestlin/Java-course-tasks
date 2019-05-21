package dt062g.dawe1103.assignment4;

import dt062g.dawe1103.assignment4.Drawable;
import dt062g.dawe1103.assignment4.Point;

import java.util.*;

/**
* <h1>Shape</h1>
* This is the super-class called Shape and is used to describe shapes in its sub-classes.
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-20
*/

abstract class Shape implements Drawable{

	protected String color;
	//protected Point[] points = new Point[2];
	protected ArrayList<Point> points = new ArrayList<Point>();
	
	
	public Shape(double x, double y, String color)
	{
		this.color = color;
		points.add(new Point(x,y));
		
	}
	
	public Shape(Point p, String color)
	{
		this.color = color;
		points.add(p);
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	abstract public double getCircumference() throws NoEndPointException;
	
	abstract public double getArea() throws NoEndPointException;
	
	public void addPoint(Point p) {
		points.add(1,p);
	}
	
	public void addPoint(double x, double y) {		
		points.add(1,new Point(x,y));	
	}
	
	
		
	
}
