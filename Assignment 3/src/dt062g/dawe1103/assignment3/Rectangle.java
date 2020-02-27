package dt062g.dawe1103.assignment3;

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

	public double getWidth() throws NoEndPointException
	{

		if(points[1] == null) {
			 throw new NoEndPointException("The rectangle has no end point, it's width can not be calculated");
		}
		return Math.abs(points[0].getX() - points[1].getX());

	}


	public double getHeight() throws NoEndPointException
	{
		if(points[1] == null) {
			 throw new NoEndPointException("The rectangle has no end point, it's height can not be calculated");
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
	public double getCircumference() throws NoEndPointException{
		try {
			return (getHeight()*2)+(getWidth()*2);
		}catch(NullPointerException e){ throw new NoEndPointException("The the rectangle has no end point, it's circumference can not be calculated");}

	}


	@Override
	public double getArea() throws NoEndPointException{
		try {
			return getHeight()*getWidth();
		}catch(NullPointerException e){ throw new NoEndPointException("The rectangle has no end point, it's area can not be calculated");}
	}


	public String toString(){

		try {
			return "Drawing a Rectangle[start="+super.points[0]+"; end="+super.points[1]+"; width="+getWidth()+"; height="+getHeight()+"; color="+getColor()+"]";
		}catch(NullPointerException | NoEndPointException e) { return "Drawing a Rectangle[start="+super.points[0]+"; end=N/A; width=N/A; height=N/A; color="+getColor()+"]"; }

	}

}
