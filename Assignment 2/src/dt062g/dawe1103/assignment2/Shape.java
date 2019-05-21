package dt062g.dawe1103.assignment2;

/**
* <h1>Shape</h1>
* This is the super-class called Shape and is used to describe shapes in its sub-classes.
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-16
*/

abstract class Shape implements Drawable{

	protected String color;
	protected Point[] points = new Point[2];
	
	
	public Shape(double x, double y, String color)
	{
		this.color = color;
		points[0] = new Point(x,y);
		
	}
	
	
	public Shape(Point p, String color)
	{
		this.color = color;
		points[0] = p;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	abstract public double getCircumference();
	
	abstract public double getArea();
	
	public void addPoint(Point p) {
		points[1] = p;
	}
	
	public void addPoint(double x, double y) {
		points[1] = new Point(x,y);
	}
	
	
		
	
}
