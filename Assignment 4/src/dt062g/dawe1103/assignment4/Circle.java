package dt062g.dawe1103.assignment4;

import java.awt.Graphics;

import dt062g.dawe1103.assignment4.NoEndPointException;
/**
* <h1>Circle</h1>
* This sub-class creates a circle from the super-class Shape. 
* It can calculate radius, circumference, area as well as print information about these.
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-20
*/



public class Circle extends Shape{

	final double PI = 3.14;
	
	
	Circle(Point p, String color){
		super(p, color);
	}
	
	
	Circle(double x, double y, String color){
		super(new Point(x,y), color);
		
	}
	
	
	public double getRadius() throws NoEndPointException {
			
			try {
				if(super.points.get(1) == null)
					throw new NoEndPointException("The circle has no end point, it's radius can not be calculated");
				else {
				
					double x = Math.abs(super.points.get(0).getX() - super.points.get(1).getX());
					double y = Math.abs(super.points.get(0).getY() - super.points.get(1).getY());
					
				    return Math.sqrt(((Math.pow(x, 2) + Math.pow(y, 2))));		
				}
			}catch(IndexOutOfBoundsException e){ throw new NoEndPointException("The circle has no end point, it's radius can not be calculated");}
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
	public double getCircumference() throws NoEndPointException {
		
		try {
			return (getRadius()*2)*PI;
		}catch(NullPointerException e){ throw new NoEndPointException("The circle has no end point, it's circumference can not be calculated");}
	}


	@Override
	public double getArea() throws NoEndPointException {

		try {
			return (getRadius()*getRadius())*PI;
		}catch(NullPointerException e){ throw new NoEndPointException("The circle has no end point, it's area can not be calculated");}
	}
	
	public String toString() {
	
		try {
			return "Circle[start="+super.points.get(0)+"; end="+super.points.get(1)+"; radius="+getRadius()+"; color="+getColor()+"]";
		}catch(NullPointerException | NoEndPointException e) {return "Drawing a Circle[start="+super.points.get(0)+"; end=N/A; radius=N/A color="+getColor()+"]"; }
	
	}
	
}
