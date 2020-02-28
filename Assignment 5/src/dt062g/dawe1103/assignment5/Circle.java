package dt062g.dawe1103.assignment5;

import java.awt.Graphics;
import dt062g.dawe1103.assignment5.NoEndPointException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
* <h1>Circle</h1>
* This sub-class creates a circle from the super-class Shape. 
* It can calculate radius, circumference, area as well as print information about these.
*
* @author  Daniel Westlin (dawe1103)
* @version 1.0
* @since   2017-11-20
*/


@XmlRootElement
public class Circle extends Shape{

	@XmlTransient
	final double pi = 3.14;
	
	Circle(){
		super();
	}
	
	Circle(Point p, String color){
		super(p, color);
	}
	
	
	Circle(double x, double y, String color){
		super(new Point(x,y), color);
		
	}
	
	
	public double getRadius() throws NoEndPointException {
			
			try {
				double squareRadius;
				double xCord;
				double yCord;
				double radius;

				if(super.points.get(0).getValueX() > super.points.get(1).getValueX()) {
					xCord = super.points.get(0).getValueX() - super.points.get(1).getValueX();
					if(super.points.get(0).getValueY() > super.points.get(1).getValueY())
						yCord = super.points.get(0).getValueY() - super.points.get(1).getValueY();
					else {
						yCord = super.points.get(1).getValueY() - super.points.get(0).getValueY();
					}
					squareRadius = (yCord*yCord)+(xCord*xCord);
					
					radius = Math.sqrt(squareRadius);
					return radius;
						
				}
				else {
					xCord = super.points.get(1).getValueX() - super.points.get(0).getValueX();
					if(super.points.get(0).getValueY() > super.points.get(1).getValueY())
						yCord = super.points.get(0).getValueY() - super.points.get(1).getValueY();
					else {
						yCord = super.points.get(1).getValueY() - super.points.get(0).getValueY();
					}
					squareRadius = (yCord*yCord)+(xCord*xCord);
					
					radius = Math.sqrt(squareRadius);
					return radius;
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
			return (getRadius()*2)*pi;
		}catch(NullPointerException e){ throw new NoEndPointException("The circle has no end point, it's circumference can not be calculated");}
	}


	@Override
	public double getArea() throws NoEndPointException {

		try {
			return (getRadius()*getRadius())*pi;
		}catch(NullPointerException e){ throw new NoEndPointException("The circle has no end point, it's area can not be calculated");}
	}
	
	public String toString() {
	
		try {
			return "Circle[start="+super.points.get(0)+"; end="+super.points.get(1)+"; radius="+getRadius()+"; color="+getColor()+"]";
		}catch(NullPointerException | NoEndPointException e) {return "Drawing a Circle[start="+super.points.get(0)+"; end=N/A; radius=N/A color="+getColor()+"]"; }
	
	}
	
}
