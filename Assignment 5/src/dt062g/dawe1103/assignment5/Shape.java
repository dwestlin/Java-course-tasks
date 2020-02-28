package dt062g.dawe1103.assignment5;

import dt062g.dawe1103.assignment5.Drawable;
import dt062g.dawe1103.assignment5.Point;

import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
/**
* <h1>Shape</h1>
* This is the super-class called Shape and is used to describe shapes in its sub-classes.
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-20
*/

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlSeeAlso({Rectangle.class, Circle.class})
abstract class Shape implements Drawable{

	@XmlElement
	protected String color;
	
	@XmlElement(name="point")
	protected ArrayList<Point> points = new ArrayList<Point>();
	
	public Shape() {
		
	}
	
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
		points.add(p);
	}
	
	public void addPoint(double x, double y) {
		points.add(new Point(x,y));
	}
	
	
		
	
}
